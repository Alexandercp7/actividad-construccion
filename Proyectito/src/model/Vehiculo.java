package model;

import java.util.Random;


public abstract class Vehiculo {
	protected String placaActual;
	protected String marca;
	protected String numeroDeLlantas;
	protected String modelo;
	protected String tipoCombustible;
	protected String numSerie;
	protected String numMotor;
	protected String modificaciones;
	protected String linea;
	protected String tipoVehiculo;
	protected String cilindros;
	protected String origen;
	protected String placaAnterior;
	protected String entidad;
	protected Propietario propietario;

	public Vehiculo(Propietario propietario, String placaActual, String marca, String numeroDeLlantas, String modelo, String tipoCombustible,
			String numSerie, String numMotor, String modificaciones, String linea, String tipoVehiculo, String cilindros, String entidad,String origen,String placaAnterior) {
		this.propietario = propietario;
		this.placaActual = placaActual;
		this.placaAnterior = placaAnterior;
		this.marca = marca;
		this.numeroDeLlantas = numeroDeLlantas;
		this.modelo = modelo;
		this.tipoCombustible = tipoCombustible;
		this.numSerie = numSerie;
		this.numMotor = numMotor;
		this.modificaciones = modificaciones;
		this.linea = linea;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindros = cilindros;
		this.origen = origen;
		this.entidad =entidad;
	}
	public Vehiculo() {
		
	}
	//Creando getters y setters
	public Propietario getPropietario() {
		return propietario;
	}
	
	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getPlacaAnterior() {
		return placaAnterior;
	}

	public void setPlacaAnterior(String placaAnterior) {
		this.placaAnterior = placaAnterior;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	public String getPlacaActual() {
		return placaActual;
	}
	
	public void setPlacaActual(String placaActual) {
		this.placaActual = placaActual;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNumeroDeLlantas() {
		return numeroDeLlantas;
	}
	public void setNumeroDeLlantas(String numeroDeLlantas) {
		this.numeroDeLlantas = numeroDeLlantas;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipoCombustible() {
		return tipoCombustible;
	}
	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getNumMotor() {
		return numMotor;
	}
	public void setNumMotor(String numMotor) {
		this.numMotor = numMotor;
	}
	public String getModificaciones() {
		return modificaciones;
	}
	public void setModificaciones(String modificaciones) {
		this.modificaciones = modificaciones;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getCilindros() {
		return cilindros;
	}
	public void setCilindros(String cilindros) {
		this.cilindros = cilindros;
	}
	
	public static String placaNueva() {
		StringBuilder placaBuilder = new StringBuilder();
        Random random = new Random();
        

        // Generar letras
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(26); // 26 letras en el alfabeto
            char letra = (char) ('A' + index);
            placaBuilder.append(letra);
        }

        // Separador "-"
        placaBuilder.append("-");

        // Generar números
        for (int i = 0; i < 2; i++) {
            int numero = random.nextInt(10); // 10 números posibles
            placaBuilder.append(numero);
        }

        // Separador "-"
        placaBuilder.append("-");

        // Generar números
        for (int i = 0; i < 2; i++) {
            int numero = random.nextInt(10);
            placaBuilder.append(numero);
        }
        return placaBuilder.toString();
    }
	
}