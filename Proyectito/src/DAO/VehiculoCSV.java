package DAO;

public class VehiculoCSV {
	
	public static String con = "Vehiculos.csv";
	
	public VehiculoCSV() {

	}
	

	public static String getCon() {
		return con;
	}

	public static void setCon(String vehiculos_dir) {
		con = vehiculos_dir;
	}
	
}
