package controller;


import java.io.Serializable;

import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.jsp.tagext.TryCatchFinally;

import dao.PersonaService;
import model.Persona;

/*
 * aqui se integra las distintas capas de la appweb
 * 
 */
@Named
@RequestScoped
public class PersonaController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//conectarme a la capa de negocio
	@Inject
	private PersonaService personaService;
	
	//ojbeto tipo Persona
	private Persona persona;
	
	//datamodel pueda cargar la informacion de Persona
	DataModel<Persona> lista;
	
	Long idSeleccionado;
	
	//constructor
	public PersonaController() {
		if(persona == null) {
			persona = new Persona();
		}
	}
	
	//guardar
	public String guardar() {
		try {
			System.out.println("service: " + personaService);
			personaService.save(persona);
			
			
		} catch (Exception e) {
			System.out.print("error" + e.getMessage());
			return "";
		}
		return "listarPersonaPrimefaces";
	}
	
	//editar
	public void editar() {
		if(idSeleccionado == null) {
			return;
		}
		//buscar persona por id
		persona = personaService.find(idSeleccionado);
	}
	
	//eliminar
	public String remover(ActionEvent e) {
		try {
			persona = new Persona();
			String i = e.getComponent().getAttributes().get("itemEliminar").toString(); //obtener parametro desde datatable
			Long l  = new Long(i); //conversion
			persona.setId(l);
			personaService.remove(persona);
			
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return "";
		}
		return "listarPersonaPrimefaces";
		
	
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public DataModel<Persona> getLista() {
		lista = new ListDataModel<Persona>(personaService.findAll());
		return lista;
	}

	public void setLista(DataModel<Persona> lista) {
		this.lista = lista;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}
	
	
	
	

}
