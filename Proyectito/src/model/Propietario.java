package model;

public class Propietario extends Persona{

	private String numeroDeContacto;
	private String tipoDeLicencia;
	private String municipio;
	private String localidad;
	
	
	//Constructor 
	public Propietario(String nombres, String apellidos, String fechaDeNacimiento,String localidad, String municipio, String direccion, String numeroDeContacto, String tipoDeLicencia) {
		super(nombres,apellidos, fechaDeNacimiento, direccion);
		this.municipio = municipio;
		this.localidad = localidad;
		this.tipoDeLicencia=tipoDeLicencia;
		this.numeroDeContacto=numeroDeContacto;
	}
	
	public Propietario() {
		
	}
	
	//getters y setters
	public String getNumeroDeContacto() {
		return numeroDeContacto;
	}
	public void setNumeroDeContacto(String numeroDeContacto) {
		this.numeroDeContacto = numeroDeContacto;
	}
	public String getTipoDeLicencia() {
		return tipoDeLicencia;
	}
	public void setTipoDeLicencia(String tipoDeLicencia) {
		this.tipoDeLicencia = tipoDeLicencia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
}
