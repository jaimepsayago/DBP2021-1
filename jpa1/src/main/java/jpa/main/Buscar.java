package jpa.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.*;

import jpa.entities.Mensaje;

public class Buscar {
	//consulta para busqueda de mensajes con parametros
			private static final String Query_busca_mensajes = 
					"Select m from Mensaje m where m.texto like :patron";
			
			public static void main(String[] args) {
				//factoria
						EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
						//entitymanager
						EntityManager em = emf.createEntityManager();
						
						System.out.println("buscando los mensajes");
						String palabra = leerTexto("introduce una palabra");	
			//agregar la palabra a la variable para la consulta / query	
						String patron = "%" + palabra + "%";	
			//consulta ejecucion con el parametro patron en este caso
			Query query = em.createQuery(Query_busca_mensajes);	
			//agregar paramero a la consulta
			query.setParameter("patron", patron);
			
			//Crear una lista con la informacion de la query o consulta
			List<Mensaje> mensajes = query.getResultList();
			if(mensajes.isEmpty()) {
				System.out.println("no existen datos");
			}else {
				for (Mensaje mensaje:mensajes) {
					System.out.println(mensaje.getTexto()+ "--****---"+ mensaje.getAutorBean().getNombre());
				}
			}
		em.close();
		emf.close();
			
}
			public static String leerTexto(String mensaje) {
				String texto;
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					System.out.print(mensaje);
					texto = in.readLine();
				} catch (IOException e) {
					texto = "error";
				}
			return texto;
			}
		}
