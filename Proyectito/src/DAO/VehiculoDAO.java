package DAO;

import model.Automovil;
import model.Motocicleta;
import model.Propietario;
import model.VehiculosDeCarga;
import model.Vehiculo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class VehiculoDAO implements DAO<Vehiculo> {

	private String con = VehiculoCSV.getCon();
	private PropietariosDAO proDAO = new PropietariosDAO();

	public VehiculoDAO() {
		createCSV();
	}

	public boolean insertCSV(Vehiculo vehiculo) {
	    try (BufferedReader br = new BufferedReader(new FileReader(con))) {

	        String line;
	        String[] value = null;
	        boolean serieExistente = false;

	        while ((line = br.readLine()) != null) {
	            value = line.split(",");
	            if (value.length >= 7 && value[6].trim().equals(vehiculo.getNumSerie()) || value.length >= 7 && value[0].trim().equals(vehiculo.getPlacaActual()) ) {
	                serieExistente = true;
	                System.out.println("Vehiculo no creado, numero de serie o placa actual en uso");
	                return false; // Salir del bucle si el número de serie ya existe
	            }
	        }

	        if (!serieExistente) {
	            try (PrintWriter pw = new PrintWriter(new FileWriter(con, true))) {
	                // Crea un nuevo vehículo
	                if (vehiculo instanceof Automovil) {
	                    pw.println(vehiculo.getPlacaActual() + "," + vehiculo.getPropietario().getNombres() + ","
	                            + vehiculo.getPropietario().getApellidos() + "," + vehiculo.getMarca() + ","
	                            + vehiculo.getModelo() + "," + vehiculo.getLinea() + "," + vehiculo.getNumSerie() + ","
	                            + vehiculo.getTipoVehiculo() + "," + vehiculo.getTipoCombustible() + ","
	                            + vehiculo.getNumeroDeLlantas() + "," + vehiculo.getNumMotor() + ","
	                            + vehiculo.getModificaciones() + "," + vehiculo.getCilindros() + "," + vehiculo.getEntidad()
	                            + "," + vehiculo.getOrigen() + "," + vehiculo.getPlacaAnterior() + ","
	                            + ((Automovil) vehiculo).getEjeDir() + "," + ((Automovil) vehiculo).getEjeMotriz());
	                    return true;
	                } else if (vehiculo instanceof Motocicleta) {
	                    pw.println(vehiculo.getPlacaActual() + "," + vehiculo.getPropietario().getNombres() + ","
	                            + vehiculo.getPropietario().getApellidos() + "," + vehiculo.getMarca() + ","
	                            + vehiculo.getModelo() + "," + vehiculo.getLinea() + "," + vehiculo.getNumSerie() + ","
	                            + vehiculo.getTipoVehiculo() + "," + vehiculo.getTipoCombustible() + ","
	                            + vehiculo.getNumeroDeLlantas() + "," + vehiculo.getNumMotor() + ","
	                            + vehiculo.getModificaciones() + "," + vehiculo.getCilindros() + "," + vehiculo.getEntidad()
	                            + "," + vehiculo.getOrigen() + "," + vehiculo.getPlacaAnterior() + "," + "," + "," + "," + ","
	                            + "," + "," + "," + ((Motocicleta) vehiculo).getCilindraje());
	                    return true;
	                } else if (vehiculo instanceof VehiculosDeCarga) {
	                    pw.println(vehiculo.getPlacaActual() + "," + vehiculo.getPropietario().getNombres() + ","
	                            + vehiculo.getPropietario().getApellidos() + "," + vehiculo.getMarca() + ","
	                            + vehiculo.getModelo() + "," + vehiculo.getLinea() + "," + vehiculo.getNumSerie() + ","
	                            + vehiculo.getTipoVehiculo() + "," + vehiculo.getTipoCombustible() + ","
	                            + vehiculo.getNumeroDeLlantas() + "," + vehiculo.getNumMotor() + ","
	                            + vehiculo.getModificaciones() + "," + vehiculo.getCilindros() + "," + vehiculo.getEntidad()
	                            + "," + vehiculo.getOrigen() + "," + vehiculo.getPlacaAnterior() + ","
	                            + ((VehiculosDeCarga) vehiculo).getEjeDir() + ","
	                            + ((VehiculosDeCarga) vehiculo).getEjeMotriz() + ","
	                            + ((VehiculosDeCarga) vehiculo).getCapacidadCarga() + ","
	                            + ((VehiculosDeCarga) vehiculo).getDimAlto() + ","
	                            + ((VehiculosDeCarga) vehiculo).getDimAncho() + ","
	                            + ((VehiculosDeCarga) vehiculo).getDimLargo() + ","
	                            + ((VehiculosDeCarga) vehiculo).getEjeArrastre());
	                    return true;	
	                }
	            } catch (IOException e) {
	                System.err.println("Error al escribir en el archivo Vehiculos.svc");
	                e.printStackTrace();
	                return false;
	            }
	        }

	    } catch (IOException e) {
	        System.err.println("Error: No se ha encontrado el archivo Vehiculos.svc");
	        e.printStackTrace();
	        return false;
	    }
	    return false;
	}

	
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
	                temp.delete(); // Eliminar el archivo temporal si aún existe
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
		            if (temp.exists()) {
		                temp.delete(); // Eliminar el archivo temporal si aún existe
		            }
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
	public void createCSV() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(con, true));
				BufferedReader br2 = new BufferedReader(new FileReader(con))) {

			if (br2.lines().findFirst().isPresent()) {
				// Verifica si la base existe entonces no hace nada
			} else {
				pw.println(
						"Placa,Nombres Propietario,Apellidos Propietario,Marca,Modelo,Linea,#Serie,TipoVehiculo,Tipo de combustible,#Llantas,#Motor,Modificaciones,Cilindros,Entidad,Origen,Placa Anterior,EjeDir,EjeMotriz,CapacidadCarga,Dimension Alto,Dimension Ancho,Dimension Largo,EjeArraste,Cilindraje");
				System.out.println("Archivo de Vehiculos creado correctamente...");
			}
		} catch (IOException e) {
			System.err.println("Error: No se ha encontrado el archivo de Vehiculos");
		}
	}

	@Override
	public Vehiculo getFromCSV(String header1, String value1, String header2, String value2) {
		try (BufferedReader br = new BufferedReader(new FileReader(con))) {
			String line;
			String[] headers = null;

			if ((line = br.readLine()) != null) {
				headers = line.split(",");
			}

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				if (headers != null && values.length >= 2) {
					int index1 = -1;
					int index2 = -1;
					for (int i = 0; i < headers.length; i++) {
						if (headers[i].trim().equals(header1)) {
							index1 = i;
						}
						if (headers[i].trim().equals(header2)) {
							index2 = i;
						}
					}

					if (index1 != -1 && index2 != -1 && values.length > index1 && values.length > index2
							&& values[index1].trim().equals(value1) && values[index2].trim().equals(value2)) {
						Propietario pro = proDAO.getFromCSV("Apellidos", values[2], "Nombres", values[1]);

						if ("Moto".equals(values[7])) {
							Motocicleta motoModel = new Motocicleta(pro, values[0], values[3], values[9], values[4],
									values[8], values[6], values[10], values[11], values[5], values[7], values[12],
									values[23], values[13], values[14], values[15]);
							return motoModel;
						} else if ("Automovil".equals(values[7])) {
							Automovil autoModel = new Automovil(pro, values[0], values[3], values[9], values[4],
									values[8], values[6], values[10], values[11], values[5], values[7], values[12],
									values[13], values[14], values[15], values[17], values[16]);
							return autoModel;
						} else if ("Carga".equals(values[7])) {
							VehiculosDeCarga cargaModel = new VehiculosDeCarga(pro, values[0], values[3], values[9],
									values[4], values[8], values[6], values[10], values[11], values[5], values[7],
									values[12], values[13], values[14], values[15], values[18], values[22], values[21],
									values[20], values[19], values[17], values[16]);
							return cargaModel;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateCSV(Vehiculo vehiculo) {
		try (BufferedReader br = new BufferedReader(new FileReader(con));
				PrintWriter pw = new PrintWriter(new FileWriter("temp.csv"))) {

			boolean updated = false;

			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				
				
				if (values.length >= 2 && values[6].trim().equals(vehiculo.getNumSerie())) {
					// encontrado
					if (values.length >= 2 && values[0].trim().equals(vehiculo.getPlacaActual())) {	
					}else {
						vehiculo.setPlacaAnterior(values[0]);
					}
					if (vehiculo instanceof Automovil) {
						updated = true;
						pw.println(vehiculo.getPlacaActual() + "," + vehiculo.getPropietario().getNombres() + ","
								+ vehiculo.getPropietario().getApellidos() + "," + vehiculo.getMarca() + ","
								+ vehiculo.getModelo() + "," + vehiculo.getLinea() + "," + vehiculo.getNumSerie() + ","
								+ vehiculo.getTipoVehiculo() + "," + vehiculo.getTipoCombustible() + ","
								+ vehiculo.getNumeroDeLlantas() + "," + vehiculo.getNumMotor() + ","
								+ vehiculo.getModificaciones() + "," + vehiculo.getCilindros() + ","
								+ vehiculo.getEntidad() + "," + vehiculo.getOrigen() + "," + vehiculo.getPlacaAnterior()
								+ "," + ((Automovil) vehiculo).getEjeDir() + ","
								+ ((Automovil) vehiculo).getEjeMotriz());
					}
					if (vehiculo instanceof Motocicleta) {
						updated = true;
						pw.println(vehiculo.getPlacaActual() + "," + vehiculo.getPropietario().getNombres() + ","
								+ vehiculo.getPropietario().getApellidos() + "," + vehiculo.getMarca() + ","
								+ vehiculo.getModelo() + "," + vehiculo.getLinea() + "," + vehiculo.getNumSerie() + ","
								+ vehiculo.getTipoVehiculo() + "," + vehiculo.getTipoCombustible() + ","
								+ vehiculo.getNumeroDeLlantas() + "," + vehiculo.getNumMotor() + ","
								+ vehiculo.getModificaciones() + "," + vehiculo.getCilindros() + ","
								+ vehiculo.getEntidad() + "," + vehiculo.getOrigen() + "," + vehiculo.getPlacaAnterior()
								+ "," + "," + "," + "," + "," + "," + "," + ","
								+ ((Motocicleta) vehiculo).getCilindraje());
					} else {
						if (vehiculo instanceof VehiculosDeCarga) {
							pw.println(vehiculo.getPlacaActual() + "," + vehiculo.getPropietario().getNombres() + ","
									+ vehiculo.getPropietario().getApellidos() + "," + vehiculo.getMarca() + ","
									+ vehiculo.getModelo() + "," + vehiculo.getLinea() + "," + vehiculo.getNumSerie()
									+ "," + vehiculo.getTipoVehiculo() + "," + vehiculo.getTipoCombustible() + ","
									+ vehiculo.getNumeroDeLlantas() + "," + vehiculo.getNumMotor() + ","
									+ vehiculo.getModificaciones() + "," + vehiculo.getCilindros() + ","
									+ vehiculo.getEntidad() + "," + vehiculo.getOrigen() + ","
									+ vehiculo.getPlacaAnterior() + "," + ((VehiculosDeCarga) vehiculo).getEjeDir()
									+ "," + ((VehiculosDeCarga) vehiculo).getEjeMotriz() + ","
									+ ((VehiculosDeCarga) vehiculo).getCapacidadCarga() + ","
									+ ((VehiculosDeCarga) vehiculo).getDimAlto() + ","
									+ ((VehiculosDeCarga) vehiculo).getDimAncho() + ","
									+ ((VehiculosDeCarga) vehiculo).getDimLargo() + ","
									+ ((VehiculosDeCarga) vehiculo).getEjeArrastre());
							updated = true;
						}
					}
					System.out.println("Modificación exitosa.");
					updated = true;
				} else {
					// Copiando
					pw.println(line);
				}
			}
			br.close();
			pw.close();
			if (!updated) {
				System.out.println("Error: No se encontró el registro para actualizar.");
				br.close();
				pw.close();
				return false;
			}
		} catch (IOException e) {
			System.err.println("Error al actualizar el archivo de Propietarios");
			e.printStackTrace();

			return false;
		}

		// reemplazo archivos
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
	
	
	public Vehiculo getFromCSV(String header, String value1) {
		try (BufferedReader br = new BufferedReader(new FileReader(con))) {
			String line;
			String[] headers = null;

			if ((line = br.readLine()) != null) {
				headers = line.split(",");
			}

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				if (headers != null && values.length >= 2) {
					int index1 = -1;
	
					for (int i = 0; i < headers.length; i++) {
						if (headers[i].trim().equals(header)) {
							index1 = i;
						}
					}

					if (index1 != -1 && values.length > index1 && values[index1].trim().equals(value1) ) {
						Propietario pro = proDAO.getFromCSV("Apellidos", values[2], "Nombres", values[1]);

						if ("Moto".equals(values[7])) {
							Motocicleta motoModel = new Motocicleta(pro, values[0], values[3], values[9], values[4],
									values[8], values[6], values[10], values[11], values[5], values[7], values[12],
									values[23], values[13], values[14], values[15]);
							return motoModel;
						} else if ("Automovil".equals(values[7])) {
							Automovil autoModel = new Automovil(pro, values[0], values[3], values[9], values[4],
									values[8], values[6], values[10], values[11], values[5], values[7], values[12],
									values[13], values[14], values[15], values[17], values[16]);
							return autoModel;
						} else if ("Carga".equals(values[7])) {
							VehiculosDeCarga cargaModel = new VehiculosDeCarga(pro, values[0], values[3], values[9],
									values[4], values[8], values[6], values[10], values[11], values[5], values[7],
									values[12], values[13], values[14], values[15], values[18], values[22], values[21],
									values[20], values[19], values[17], values[16]);
							return cargaModel;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
