package facelet.alumno;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



/*controlador que sirve de puente entre el modelo(base de datos)
y la vista (pagina web)

*/

//etiquetas o decorados
//arrobas @
//que junto al nombre de la libreria se agregan para obtener dicha funcionalidad

@Named
@RequestScoped
public class StudentBean {
	
	private String nombre;
	private String apellido;
	private String direccion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//funcion para que imprima los datos y me retorna a una pagina web
	public String createStudentForm() {
        System.out.println("Nombre: " + nombre + " " + apellido + ", direccion: " + direccion);
        return "output";
    }
	

}
