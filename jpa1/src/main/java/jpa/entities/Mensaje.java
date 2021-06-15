package jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mensaje database table.
 * 
 */
@Entity
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mensaje_id")
	private Integer mensajeId;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String texto;

	private Integer version;

	//bi-directional many-to-one association to Autor
	@ManyToOne
	@JoinColumn(name="autor")
	private Autor autorBean;

	public Mensaje() {
	}

	public Mensaje(String texto, Autor autor,int version) {
        this.texto = texto;
        this.autorBean = autor;
        this.version= version;
    }
	
	public Integer getMensajeId() {
		return this.mensajeId;
	}

	public void setMensajeId(Integer mensajeId) {
		this.mensajeId = mensajeId;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Autor getAutorBean() {
		return this.autorBean;
	}

	public void setAutorBean(Autor autorBean) {
		this.autorBean = autorBean;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensaje mensaje = (Mensaje) o;

        if (!autorBean.equals(mensaje.autorBean)) return false;
        if (!texto.equals(mensaje.texto)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = texto.hashCode();
        result = 31 * result + autorBean.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + mensajeId +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                ", autor=" + autorBean +
                '}';
    }
}