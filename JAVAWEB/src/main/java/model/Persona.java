package model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NamedQuery(name="Persona.findAll", query="Select p from Persona p")
@Data @AllArgsConstructor @NoArgsConstructor
public class Persona implements AbsctractEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String apellido;

	private String ciudad;

	private String direccion;

	private Integer edad;

	private String nombre;

	private String telefono;

}
