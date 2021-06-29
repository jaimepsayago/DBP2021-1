package controller;

import java.io.Serializable;

import javax.enterprise.context.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

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
