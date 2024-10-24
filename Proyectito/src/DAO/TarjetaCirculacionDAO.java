package DAO;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Automovil;
import model.Motocicleta;
import model.TarjetaCirculacion;
import model.VehiculosDeCarga;

public class TarjetaCirculacionDAO implements DAO<TarjetaCirculacion>{

	private String con = TarjetaCirculacionCSV.getCon();
	
	public  TarjetaCirculacionDAO(){
		createCSV();
	} 
	
	
	
	
	
	@Override
	public boolean insertCSV(TarjetaCirculacion tarjeta) {
	    try (PrintWriter pw = new PrintWriter(new FileWriter(con, true));
	         BufferedReader br = new BufferedReader(new FileReader(con))) {

	        String line;

	        // Verificar si el número de serie ya existe
	        boolean serieExistente = false;
	        while ((line = br.readLine()) != null) {
	            String[] values = line.split(",");
	            if (values.length >= 16 && values[15].trim().equals(tarjeta.getVehiculo().getNumSerie() ) || (values.length >= 16 && values[5].trim().equals(tarjeta.getVehiculo().getPlacaActual()))) {
	                serieExistente = true;
	                System.out.println("Tarjeta no creada, número de serie o placa actual en uso");
	                return false;
	            }
	        }

	        // Si el número de serie no existe, se puede agregar la nueva tarjeta
	        if (!serieExistente) {
	            if (tarjeta.getVehiculo() instanceof Motocicleta) {
	                pw.println(tarjeta.getNumFolio() + "," + tarjeta.getPropietario().getNombres() + ","
	                        + tarjeta.getPropietario().getApellidos() + "," + tarjeta.getFechaExpedicion() + ","
	                        + tarjeta.getFechaVigencia() + "," + tarjeta.getVehiculo().getPlacaActual() + ","
	                        + tarjeta.getVehiculo().getPlacaAnterior() + "," + tarjeta.getPropietario().getMunicipio() + ","
	                        + tarjeta.getPropietario().getLocalidad() + "," + tarjeta.getVehiculo().getEntidad() + ","
	                        + tarjeta.getVehiculo().getOrigen() + "," + tarjeta.getVehiculo().getTipoVehiculo() + ","
	                        + tarjeta.getVehiculo().getMarca() + "," + tarjeta.getVehiculo().getModelo() + ","
	                        + tarjeta.getVehiculo().getNumSerie() + "," + tarjeta.getVehiculo().getNumMotor() + ","
	                        + tarjeta.getVehiculo().getLinea() + "," + tarjeta.getVehiculo().getTipoCombustible() + ","
	                        + tarjeta.getVehiculo().getCilindros() + "," + "," + "," + "," + "," + "," + ","
	                        + ((Motocicleta) tarjeta.getVehiculo()).getCilindraje());
	                return true;
	            } else if (tarjeta.getVehiculo() instanceof VehiculosDeCarga) {
	                pw.println(tarjeta.getNumFolio() + "," + tarjeta.getPropietario().getNombres() + ","
	                        + tarjeta.getPropietario().getApellidos() + "," + tarjeta.getFechaExpedicion() + ","
	                        + tarjeta.getFechaVigencia() + "," + tarjeta.getVehiculo().getPlacaActual() + ","
	                        + tarjeta.getVehiculo().getPlacaAnterior() + "," + tarjeta.getPropietario().getMunicipio() + ","
	                        + tarjeta.getPropietario().getLocalidad() + "," + tarjeta.getVehiculo().getEntidad() + ","
	                        + tarjeta.getVehiculo().getOrigen() + "," + tarjeta.getVehiculo().getTipoVehiculo() + ","
	                        + tarjeta.getVehiculo().getMarca() + "," + tarjeta.getVehiculo().getModelo() + ","
	                        + tarjeta.getVehiculo().getNumSerie() + "," + tarjeta.getVehiculo().getNumMotor() + ","
	                        + tarjeta.getVehiculo().getLinea() + "," + tarjeta.getVehiculo().getTipoCombustible() + ","
	                        + tarjeta.getVehiculo().getCilindros() + "," + ((VehiculosDeCarga) tarjeta.getVehiculo()).getEjeDir()
	                        + "," + ((VehiculosDeCarga) tarjeta.getVehiculo()).getEjeMotriz() + ","
	                        + ((VehiculosDeCarga) tarjeta.getVehiculo()).getEjeArrastre() + ","
	                        + ((VehiculosDeCarga) tarjeta.getVehiculo()).getDimAncho() + ","
	                        + ((VehiculosDeCarga) tarjeta.getVehiculo()).getDimAlto() + ","
	                        + ((VehiculosDeCarga) tarjeta.getVehiculo()).getDimLargo() + ","
	                        + ((VehiculosDeCarga) tarjeta.getVehiculo()).getCapacidadCarga());
	                return true;
	            } else if (tarjeta.getVehiculo() instanceof Automovil) {
	                pw.println(tarjeta.getNumFolio() + "," + tarjeta.getPropietario().getNombres() + ","
	                        + tarjeta.getPropietario().getApellidos() + "," + tarjeta.getFechaExpedicion() + ","
	                        + tarjeta.getFechaVigencia() + "," + tarjeta.getVehiculo().getPlacaActual() + ","
	                        + tarjeta.getVehiculo().getPlacaAnterior() + "," + tarjeta.getPropietario().getMunicipio() + ","
	                        + tarjeta.getPropietario().getLocalidad() + "," + tarjeta.getVehiculo().getEntidad() + ","
	                        + tarjeta.getVehiculo().getOrigen() + "," + tarjeta.getVehiculo().getTipoVehiculo() + ","
	                        + tarjeta.getVehiculo().getMarca() + "," + tarjeta.getVehiculo().getModelo() + ","
	                        + tarjeta.getVehiculo().getNumSerie() + "," + tarjeta.getVehiculo().getNumMotor() + ","
	                        + tarjeta.getVehiculo().getLinea() + "," + tarjeta.getVehiculo().getTipoCombustible() + ","
	                        + tarjeta.getVehiculo().getCilindros() + "," + ((Automovil) tarjeta.getVehiculo()).getEjeDir()
	                        + "," + ((Automovil) tarjeta.getVehiculo()).getEjeMotriz());
	               return true;
	            }
	        }

	    } catch (IOException e) {
	        System.err.println("Error: No se ha encontrado el archivo de TarjetasDeCirculacion.csv");
	        e.printStackTrace();
	        return false;
	    }
	    return false;
	}
		


	@Override
    public boolean deleteCSV(String header1, String value1, String header2, String value2) {
		boolean coincidencia = false;
		try {
			File archivoOriginal = new File(con);
			File temp = new File("temp.csv");

			BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
			PrintWriter pw = new PrintWriter(new FileWriter(temp));

			// Leyendo los encabezados
			String encabezado = reader.readLine();
			pw.println(encabezado);

			// Encontrando los índices de los encabezados
			String[] encabezados = encabezado.split(",");
			int index1 = -1;
			int index2 = -1;

			for (int i = 0; i < encabezados.length; i++) {
				if (encabezados[i].equals(header1)) {
					index1 = i;
				} else if (encabezados[i].equals(header2)) {
					index2 = i;
				}
			}

			if (index1 == -1 || index2 == -1) {
				System.err.println("Error: Al menos uno de los encabezados no encontrado.");
				reader.close();
				pw.close();
				return false; 
			}

			// Leyendo por linea
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] values = linea.split(",");
				if (values.length > index1 && values.length > index2 && values[index1].equals(value1)
						&& values[index2].equals(value2)) {
					coincidencia = true; 
				}else
				pw.println(linea);
			}


			if(!coincidencia) {
				reader.close();
				pw.close();
	            if (temp.exists()) {
	                temp.delete(); 
	            }
				return false;
			}
			
			reader.close();
			pw.close();

			
			// Reemplazamos el archivo original con el archivo temporal
			if (archivoOriginal.delete()) {
				if (!temp.renameTo(archivoOriginal)) {
					System.err.println("Error: No se ha logrado cambiar el nombre.");
					reader.close();
					pw.close();
					return false;
				}
			} else {
				System.err.println("Error: No se ha podido borrar el archivo original");
				reader.close();
				pw.close();
	            if (temp.exists()) {
	                temp.delete(); // Eliminar el archivo temporal si aún existe
	            }
				return false;
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return false;
			
		}
		
		return true;
	}


	@Override
	public boolean updateCSV(TarjetaCirculacion tarjeta) {
		try (BufferedReader br = new BufferedReader(new FileReader(con));
		         PrintWriter pw = new PrintWriter(new FileWriter("temp.csv"))) {

		        boolean updated = false;

		        String line;
		        while ((line = br.readLine()) != null) {
		            String[] values = line.split(",");
		            if (values.length >= 2 && values[14].trim().equals(tarjeta.getVehiculo().getNumSerie()) ){
						if (values.length >= 2 && values[5].trim().equals(tarjeta.getVehiculo().getPlacaActual())) {	
						}else {
							tarjeta.getVehiculo().setPlacaAnterior(values[5]);
						}
		                // encontrado
		            	if(tarjeta.getVehiculo() instanceof Motocicleta) {
		        			pw.println(tarjeta.getNumFolio()+","+tarjeta.getPropietario().getNombres()+","+tarjeta.getPropietario().getApellidos()+","+tarjeta.getFechaExpedicion()+","+tarjeta.getFechaVigencia()+","+tarjeta.getVehiculo().getPlacaActual()+","+tarjeta.getVehiculo().getPlacaAnterior()+","+tarjeta.getPropietario().getMunicipio()+","+tarjeta.getPropietario().getLocalidad()+","+tarjeta.getVehiculo().getEntidad()+
		                 		   ","+tarjeta.getVehiculo().getOrigen()+","+tarjeta.getVehiculo().getTipoVehiculo()+","+tarjeta.getVehiculo().getMarca()+","+tarjeta.getVehiculo().getModelo()+","+tarjeta.getVehiculo().getNumSerie()+","+tarjeta.getVehiculo().getNumMotor()+","+tarjeta.getVehiculo().getLinea()+","+tarjeta.getVehiculo().getTipoCombustible()+","+tarjeta.getVehiculo().getCilindros()+","+","+","+","+","+","+","+","+((Motocicleta)tarjeta.getVehiculo()).getCilindraje());
		        			 updated = true;
		        		}else {
		    	    		if(tarjeta.getVehiculo() instanceof VehiculosDeCarga) {
		    	    			 updated = true;
		    	    			pw.println(tarjeta.getNumFolio()+","+tarjeta.getPropietario().getNombres()+","+tarjeta.getPropietario().getApellidos()+","+tarjeta.getFechaExpedicion()+","+tarjeta.getFechaVigencia()+","+tarjeta.getVehiculo().getPlacaActual()+","+tarjeta.getVehiculo().getPlacaAnterior()+","+tarjeta.getPropietario().getMunicipio()+","+tarjeta.getPropietario().getLocalidad()+","+tarjeta.getVehiculo().getEntidad()+
		    	                		   ","+tarjeta.getVehiculo().getOrigen()+","+tarjeta.getVehiculo().getTipoVehiculo()+","+tarjeta.getVehiculo().getMarca()+","+tarjeta.getVehiculo().getModelo()+","+tarjeta.getVehiculo().getNumSerie()+","+tarjeta.getVehiculo().getNumMotor()+","+tarjeta.getVehiculo().getLinea()+","+tarjeta.getVehiculo().getTipoCombustible()+","+tarjeta.getVehiculo().getCilindros()+","+((VehiculosDeCarga)tarjeta.getVehiculo()).getEjeDir()
		    	                		   +","+((VehiculosDeCarga)tarjeta.getVehiculo()).getEjeMotriz()+","+((VehiculosDeCarga)tarjeta.getVehiculo()).getEjeArrastre()+","+((VehiculosDeCarga)tarjeta.getVehiculo()).getDimAncho()+","+((VehiculosDeCarga)tarjeta.getVehiculo()).getDimAlto()+","+((VehiculosDeCarga)tarjeta.getVehiculo()).getDimLargo()+","+((VehiculosDeCarga)tarjeta.getVehiculo()).getCapacidadCarga());
		    	    		}else {
		    	    			if(tarjeta.getVehiculo() instanceof Automovil) {
		    	    				pw.println(tarjeta.getNumFolio()+","+tarjeta.getPropietario().getNombres()+","+tarjeta.getPropietario().getApellidos()+","+tarjeta.getFechaExpedicion()+","+tarjeta.getFechaVigencia()+","+tarjeta.getVehiculo().getPlacaActual()+","+tarjeta.getVehiculo().getPlacaAnterior()+","+tarjeta.getPropietario().getMunicipio()+","+tarjeta.getPropietario().getLocalidad()+","+tarjeta.getVehiculo().getEntidad()+
		    		                		   ","+tarjeta.getVehiculo().getOrigen()+","+tarjeta.getVehiculo().getTipoVehiculo()+","+tarjeta.getVehiculo().getMarca()+","+tarjeta.getVehiculo().getModelo()+","+tarjeta.getVehiculo().getNumSerie()+","+tarjeta.getVehiculo().getNumMotor()+","+tarjeta.getVehiculo().getLinea()+","+tarjeta.getVehiculo().getTipoCombustible()+","+tarjeta.getVehiculo().getCilindros()+","+((Automovil)tarjeta.getVehiculo()).getEjeDir()
		    		                		   +","+((Automovil)tarjeta.getVehiculo()).getEjeMotriz());
		    	    				 updated = true;
		    	    				 
		    	    			}
		    	    			}
		            	System.out.println("Modificación exitosa.");
		                updated = true;
		            }
		            	} else {
		                // Copiando
		                pw.println(line);
		            }
		        }
		        
		        if (!updated) {
		            System.out.println("Error: No se encontró el registro para actualizar.");
		            return false;
		        }
		    } catch (IOException e) {
		        System.err.println("Error al actualizar el archivo de TarjetaDeCirculacion.csv");
		        e.printStackTrace();
		        return false;
		    }

		    //reemplazo archivos
		    try (BufferedReader tempBr = new BufferedReader(new FileReader("temp.csv"));
		         PrintWriter originalPw = new PrintWriter(new FileWriter(con))) {

		        String tempLine;
		        while ((tempLine = tempBr.readLine()) != null) {
		            originalPw.println(tempLine);
		        }

		    } catch (IOException e) {
		        System.err.println("Error al reemplazar el archivo original con el temporal.");
		        e.printStackTrace();
		        return false;
		    }

		    // Borrar temporal
		    File tempFile = new File("temp.csv");
		    if (!tempFile.delete()) {
		        System.err.println("Error al eliminar el archivo temporal.");
		        return false;
		    }
		return true;
	}

	@Override
	public void createCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(con, true));
                BufferedReader br2 = new BufferedReader(new FileReader(con))) {

               if (br2.lines().findFirst().isPresent()) {
                   // Verifica si la base existe entonces no hace nada.
               } else {
                   pw.println("Num. Folio,Nombre Del Propietario,Apellidos Del Propietario,Fecha Expedicion,Fecha Vigencia,Placa Actual,PlacaAnterior, Municipio,Localidad,Entidad,Origen,Tipo Vehiculo,Marca,Modelo,#Serie,#Motor,Linea,Combustible,Cilindros,EjeDir,EjeMotriz,EjeArrastre,Ancho,Alto,Largo,Capacidad de Carga,Cilindraje,"); 
                   System.out.println("Archivo de Tarjetas_dir creado correctamente...");
               }
           } catch (IOException e) {
               System.err.println("Error: No se ha encontrado el archivo de TarjetasDeCirculacion.csv");
           }
		
	}

	@Override
	public TarjetaCirculacion getFromCSV(String header1, String value1, String Header2, String Value2) {
		return null;
	}

}
