package model;

public class Automovil extends Vehiculo{
	private String ejeMotriz;
	private String ejeDir;
	
	//getters y setters
	
	public Automovil(Propietario propietario, String placaActual, String marca, String numeroDeLlantas, String modelo, String tipoCombustible,
			String numSerie, String numMotor, String modificaciones, String linea, String tipoVehiculo,
			String cilindros, String entidad,String origen, String placaAnterior, String ejeMotriz, String ejeDir) {
		super(propietario, placaActual, marca, numeroDeLlantas,modelo, tipoCombustible,numSerie, numMotor, modificaciones,linea, tipoVehiculo, cilindros,entidad,origen,placaAnterior);
		this.ejeMotriz = ejeMotriz;
		this.ejeDir = ejeDir;
	}
	
	public Automovil() {
		
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
