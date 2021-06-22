package puce.web.model;

public class Persona {
	private String identificacion;
	private String nombre;
	private String apellido;
	private String telefono;
	private String ciudad;
	private String direccion;
	private int edad;
	
	public Persona() {
		
	}
	public Persona(String identificacion, String nombre, String apellido, String telefono, int edad)
	{
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono= telefono;
		this.edad = edad;
		
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString()
	{
		return "Id: "+identificacion+", Nombre Completos "+nombre +" "+apellido +", edad "+edad+" ";
	}
	
	
}
