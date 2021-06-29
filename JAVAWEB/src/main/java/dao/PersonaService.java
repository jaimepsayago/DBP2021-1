package dao;

import java.util.List;

import javax.ejb.Local;

import model.Persona;

@Local
public interface PersonaService {

	//metodos necesarios para manipular entidad es decir un CRUD
	//guardar
	public Persona save(Persona p);
	//eliminar
	public void remove(Persona p);
	//buscar
	public Persona find(Long id);
	//listar todo
	public List<Persona> findAll();
	//otros metodos
	//buscar por nombre, apellido, borrar por fecha, etc...
	

}
