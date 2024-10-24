package model;

public class AgenteDeTrafico extends Persona{
	private String usuario;
	private String cargo;
	private String clave;
	
	
	public AgenteDeTrafico(String nombre, String apellidos,String cargo, String usuario,  String clave) {
		super(nombre,apellidos);
		this.cargo = cargo;
		this.usuario=usuario;
		this.clave=clave;
	}
	
	public AgenteDeTrafico() {
		super();
	}

	//getters y setters	
	
	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
	
	public void setClave(String clave) {
		this.clave=clave;
	}
	public String getClave() {
		return this.clave;
	}
}
