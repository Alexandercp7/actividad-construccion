package model;

public abstract class Persona {
	protected String nombres;
	protected String apellidos;
	protected String fechaDeNacimiento; //Checar si String
	protected String direccion;
	
	public Persona(String nombres,String apellidos, String fechaDeNacimiento, String direccion) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.direccion = direccion;
	}
	public Persona() {
		
	}
	public Persona(String nombres, String apellidos ) {
		this.nombres=nombres;
		this.apellidos = apellidos;
	
	}
	//getters y setters
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
