package jpa.main;

import jpa.entities.Autor;
import jpa.entities.Mensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import antlr.ParseTree;

public class New {

	public static void main(String[] args) {
		// cargar la entidad que quiero guardar
		Autor autor;
		
		//crear la factoria de entities managers y en un entity principal
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
				EntityManager em = emf.createEntityManager();
				
		//transaccionalidad
				em.getTransaction().begin();
					
				
//*/*/*/*/*/*/*/*/*/*/*/pedir datos del autor
				String email = leerTexto("introduce el correo");
				String nombre = leerTexto("introduce el nombre");
				String version = leerTexto("introduce version");
				int v = Integer.parseInt(version);
		// crear el objeto con los datos del autor
				autor = new Autor(email, nombre, v);
		//guardar los datos del objeto autor a la base de datos
				em.persist(autor);
		
//*-*-*-*-*-*-*-*-*-*-*-*-*-agregar los dastos de la entidad mensaje-*-*-*-*-*-*-*-
				String mensajeString = leerTexto("introduce un mensaje");
				String mversion = leerTexto("introduce version");
				int mv = Integer.parseInt(mversion);
			//crear objeto mensaje 	
				Mensaje mensaje = new Mensaje(mensajeString,autor,mv);
				
			//establecer campos fecha de hoy
				mensaje.setFecha(new Date());
			//guardar los datos de la entidad mensaje en la bdd
				em.persist(mensaje);
				
			//guardar la transaccion
				em.getTransaction().commit();
		//cerrar la entidad y la factoria
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
