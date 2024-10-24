package model;

public class VehiculosDeCarga extends Vehiculo{
	private String capacidadCarga;
	private String ejeArrastre;
	private String dimLargo;
	private String dimAncho;
	private String dimAlto;
	private String ejeMotriz;
	private String ejeDir;
	
	
	public VehiculosDeCarga(Propietario propietario,String placaActual, String marca, String numeroDeLlantas, String modelo,
			String tipoCombustible, String numSerie, String numMotor, String modificaciones, String linea,
			String tipoVehiculo, String cilindros, String entidad, String origen, String placaAnterior, String capacidadCarga, String ejeArrastre, String dimLargo,
			String dimAncho, String dimAlto, String ejeMotriz, String ejeDir) {
		
		super(propietario, placaActual, marca, numeroDeLlantas,modelo, tipoCombustible,numSerie, numMotor, modificaciones,linea, tipoVehiculo, cilindros,entidad,origen,placaAnterior);
		this.capacidadCarga = capacidadCarga;
		this.ejeArrastre = ejeArrastre;
		this.dimLargo = dimLargo;
		this.dimAncho = dimAncho;
		this.dimAlto = dimAlto;
		this.ejeMotriz = ejeMotriz;
		this.ejeDir = ejeDir;
	}
	
	public VehiculosDeCarga() {
		
	}
	//getters y setters

	public String getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(String capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getEjeArrastre() {
		return ejeArrastre;
	}

	public void setEjeArrastre(String ejeArrastre) {
		this.ejeArrastre = ejeArrastre;
	}

	public String getDimLargo() {
		return dimLargo;
	}

	public void setDimLargo(String dimLargo) {
		this.dimLargo = dimLargo;
	}

	public String getDimAncho() {
		return dimAncho;
	}

	public void setDimAncho(String dimAncho) {
		this.dimAncho = dimAncho;
	}

	public String getDimAlto() {
		return dimAlto;
	}

	public void setDimAlto(String dimAlto) {
		this.dimAlto = dimAlto;
	}

	public String getEjeMotriz() {
		return ejeMotriz;
	}

	public void setEjeMotriz(String ejeMotriz) {
		this.ejeMotriz = ejeMotriz;
	}

	public String getEjeDir() {
		return ejeDir;
	}

	public void setEjeDir(String ejeDir) {
		this.ejeDir = ejeDir;
	}
	
	
	
}
