 

package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Random;

public class TarjetaCirculacion {
	
	private Propietario propietario;
	private String fechaExpedicion;
	private String fechaVigencia;
	private int numFolio;
	private Vehiculo vehiculo;
	
	
	public TarjetaCirculacion(Propietario propietario, Vehiculo vehiculo) {
		this.propietario = propietario;
		this.fechaExpedicion = getFechaHoy();
		this.fechaVigencia = getFechaPosterior(4);
		this.numFolio = getFolioNuevo();
		this.vehiculo = vehiculo;
	}
	
	public TarjetaCirculacion(){
		this.fechaExpedicion = getFechaHoy();
		this.fechaVigencia = getFechaPosterior(4);
		this.numFolio = getFolioNuevo();
	}
	
	public String getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
	public String getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public static String getFechaHoy() {
		LocalDate now = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String hoy = now.format(formato);
		return hoy;

	}
	public static String getFechaPosterior(int tiempoDeVigencia ) {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaFuturaF = hoy.plusYears(tiempoDeVigencia);
		String fechaFutura = fechaFuturaF.format(formatter);
		return fechaFutura;
	}
    public static int getFolioNuevo() {
        Random random = new Random();
        int folio = 0;
        // Generar un número de 5 dígitos 
        for (int i = 0; i < 5; i++) {
            int digito = random.nextInt(10); // Números aleatorios entre 0 y 9
            folio = folio * 10 + digito;
        }
        return folio;
    }
	public int getNumFolio() {
		return numFolio;
	}
	public void setNumFolio(int numFolio) {
		this.numFolio = numFolio;
	}
}
