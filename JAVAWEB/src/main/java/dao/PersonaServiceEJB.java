package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Persona;

/*
 * implementar los metodos de la clase PersonaService con los metodos de la clase generica Persistenca
 *
 */

@Stateless
public class PersonaServiceEJB extends AbstractPersistence<Persona, Long> implements PersonaService{

	public PersonaServiceEJB() {
		super(Persona.class);

	}
	
	//implementacion JPA
	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	//metodo para que se maneje todas las operaciones de persistencia
	
	
	

}
