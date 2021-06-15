package jpa.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.*;

import jpa.entities.Autor;

public class Borrar {

	public static void main(String[] args) {
		//factoria de entities
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		//entity manager
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		//introducir los datos
		System.out.println("eliminando autor");
		String palabra = leerTexto("introduce el id del autor: ");
		Integer id = new Integer(palabra);
		
		//buscar el autor a ser eliminado
		Autor autor = em.find(Autor.class, id);
		
		//eliminar el autor encontrado
		em.remove(autor);
		em.getTransaction().commit();
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

