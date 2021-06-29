package puce.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * data = getters and setters/ construtores uno vacio y otro con todas la variables / equals / hashcode / toStribng
 * 
 */

@Data  @AllArgsConstructor @NoArgsConstructor
public class PersonaLombok {
	private String identificacion;
	private String nombre;
	private String apellido;
	private String telefono;
	private String ciudad;
	private String direccion;
	private int edad;
	
	
	
	
}
