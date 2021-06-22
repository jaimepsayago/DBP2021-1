package puce.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import puce.web.model.Persona;

@Named
@SessionScoped
public class MemoryStore implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Persona> personas;
	
	//una metodo postconstruct 
	@PostConstruct
	public void inicializar() {
		personas = new HashMap<>();
	}
	
	//metodo para agregar persona
	public void addPersona (Persona persona) {
		String idenficacion = persona.getIdentificacion();
		
		if(personas.containsKey(idenficacion)) {
			personas.remove(idenficacion);
		}
		
		personas.put(idenficacion, persona);
	}
	
	//listar la persona
	
	public List<Persona> getPersonas(){
		return new ArrayList<>(personas.values());
	}
	//obtener el id de la persona
	public Persona getPersona(String identificacion) {
		return personas.get(identificacion);
	}
	

}
