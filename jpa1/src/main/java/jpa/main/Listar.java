package jpa.main;
import java.util.List;

import javax.persistence.*;

import jpa.entities.Mensaje;

public class Listar {

	// consulta para la busqueda de mensajes y autores
	private static final String Query_busca_mensajes = 
			"Select m from Mensaje m";
	
	public static void main(String[] args) {
	
		//factoria
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		//entitymanager
		EntityManager em = emf.createEntityManager();
		
		//consulta a la base de datos desde la entidad mensaje
		
		Query query = em.createQuery(Query_busca_mensajes);
		
		//crear una lista con la información que se genero o guardo en la variable query
		List<Mensaje> mensajes = query.getResultList();
		
		if(mensajes.isEmpty()) {
			System.out.println("no existen datos");
		}else {	
			for (Mensaje mensaje:mensajes) {
				System.out.println(mensaje.getTexto()+ "--"+ mensaje.getAutorBean().getNombre());
			}
		}
		em.close();
		emf.close();

	}

}
