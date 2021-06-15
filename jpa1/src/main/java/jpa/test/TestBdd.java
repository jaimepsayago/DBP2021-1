package jpa.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.*;

import org.junit.Test;

public class TestBdd {
	
	//testing a la base de datos
	
	@Test
	public void crearEntityManagerTest() {
		//crear objeto de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		
		//prueba de objeto no nulo o digamos que si no existe se me cree un objeto
		assertNotNull(em);
		
		em.close();
		
		
		
	}
	

}
