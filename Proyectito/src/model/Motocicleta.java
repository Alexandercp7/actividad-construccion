package model;

public class Motocicleta extends Vehiculo{
	private String cilindraje;

	public Motocicleta(Propietario propietario, String placaActual, String marca, String numLlantas, String modelo, String tipoCombustible,
			String numSerie, String numMotor, String modificaciones, String linea, String tipoVehiculo,
			String numCilindros, String cilindraje, String entidad,String origen,String placaAnterior) {
		super(propietario, placaActual, marca, numLlantas,modelo, tipoCombustible,numSerie, numMotor, modificaciones,linea, tipoVehiculo, numCilindros,entidad,origen,placaAnterior);
		this.cilindraje = cilindraje;
	}
	
	public Motocicleta() {
		
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
}
