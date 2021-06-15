package jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="autor_id")
	private Integer autorId;

	private String email;

	private String nombre;

	private Integer version;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="autorBean")
	private List<Mensaje> mensajes;

	public Autor() {
	}
	
	public Autor(String nombre, String correo, int version) {
		this.nombre = nombre;
		this.email= correo;
		this.version = version;
		
	}

	public Integer getAutorId() {
		return this.autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<Mensaje> getMensajes() {
		return this.mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje addMensaje(Mensaje mensaje) {
		getMensajes().add(mensaje);
		mensaje.setAutorBean(this);

		return mensaje;
	}

	public Mensaje removeMensaje(Mensaje mensaje) {
		getMensajes().remove(mensaje);
		mensaje.setAutorBean(null);

		return mensaje;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Autor autor = (Autor) o;

	        if (!email.equals(autor.email)) return false;
	        if (!nombre.equals(autor.nombre)) return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = email.hashCode();
	        result = 31 * result + nombre.hashCode();
	        return result;
	    }

	    @Override
	    public String toString() {
	        return "Autor{" +
	                "id=" + autorId +
	                ", correo='" + email + '\'' +
	                ", nombre='" + nombre + '\'' +
	                ", mensajes=" + mensajes +
	                '}';
	    }
	}