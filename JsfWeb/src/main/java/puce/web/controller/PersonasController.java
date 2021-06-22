package puce.web.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import puce.web.model.Persona;
import puce.web.util.MemoryStore;

@Named
@RequestScoped
public class PersonasController {

	//listar los datos de la persona
	
	
	//inyecccion de dependencia o conexion a la capa de datos
	//memory store
	@Inject
	private MemoryStore ms;
	
	//metodo para listar las personas
	public List<Persona> getPersonas(){
		return ms.getPersonas();
	}
}
