package DAO;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.Propietario;

public class PropietariosDAO implements DAO<Propietario> {

	private String con = PropietariosCSV.getCon();

	public PropietariosDAO() {
		createCSV();
	}

	@Override
	public boolean insertCSV(Propietario propietario) {
		try (BufferedReader br = new BufferedReader(new FileReader(con))) {
			String line;

			// Verificar si el usuario y la clave ya existen en el archivo
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if (values.length >= 2 && values[0].trim().equals(propietario.getApellidos())
						&& values[1].trim().equals(propietario.getNombres())) {
					UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
		        	UIManager.put("Button.background", Color.WHITE);
		            JOptionPane.showMessageDialog(null, "El propietario ya existe.", "Error de Registro", JOptionPane.PLAIN_MESSAGE);
				
					return false; // No insertar si ya existen
				}
			}
		} catch (IOException e) {
			System.err.println("Error: No se ha encontrado el archivo de Agentes");
			return false;
		}

		// No hay, Copincidencias
		try (PrintWriter pw = new PrintWriter(new FileWriter(con, true))) {
			pw.println(propietario.getApellidos() + "," + propietario.getNombres() + ","
					+ propietario.getFechaDeNacimiento() + "," + propietario.getNumeroDeContacto() + ","
					+ propietario.getTipoDeLicencia() + (",") + propietario.getLocalidad() + (",")
					+ propietario.getMunicipio() + (",") + propietario.getDireccion());
			return true;
		} catch (IOException e) {
			System.err.println("Error: No se ha encontrado el archivo de Agentes");
			return false;
		}
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
				return false;
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());

			return false;
		}
		return true;
	}

	@Override
	public boolean updateCSV(Propietario propietario) {
		try (BufferedReader br = new BufferedReader(new FileReader(con));
				PrintWriter pw = new PrintWriter(new FileWriter("temp.csv"))) {

			boolean updated = false;

			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if (values.length >= 2 && values[0].trim().equals(propietario.getApellidos())
						&& values[1].trim().equals(propietario.getNombres())) {
					// encontrado
					pw.println(propietario.getApellidos() + "," + propietario.getNombres() + ","
							+ propietario.getFechaDeNacimiento() + "," + propietario.getNumeroDeContacto() + ","
							+ propietario.getTipoDeLicencia() + "," + propietario.getLocalidad() + ","
							+ propietario.getMunicipio() + "," + propietario.getDireccion());

		          
					updated = true;
				} else {
					// Copiando
					pw.println(line);
				}
			}
			br.close();
			pw.close();
			if (!updated) {
				br.close();
				pw.close();
				return false;
			}
		} catch (IOException e) {
			System.err.println("Error al actualizar el archivo de Propietarios");
			e.printStackTrace();
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

	@Override
	public void createCSV() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(con, true));
				BufferedReader br2 = new BufferedReader(new FileReader(con))) {

			if (br2.lines().findFirst().isPresent()) {
				// Verifica si la base existe entonces no hace nada.
			} else {
				pw.println("Apellidos,Nombres,FechaDeNacimiento,#Contacto,TipoLicencia,Localidad,Municipio,Direccion");
				System.out.println("Archivo de Propietarios creado correctamente...");
			}
		} catch (IOException e) {
			System.err.println("Error: No se ha encontrado el archivo de Propietarios.csv");
		}

	}

	@Override
	public Propietario getFromCSV(String header1, String value1, String header2, String value2) {
		try (BufferedReader br = new BufferedReader(new FileReader(con))) {
			String line;
			String[] headers = null;

			// Leer la primera línea para obtener los encabezados
			if ((line = br.readLine()) != null) {
				headers = line.split(",");
			}

			while ((line = br.readLine()) != null) {
				// Dividir la línea en valores utilizando la coma como delimitador
				String[] values = line.split(",");

				// Verificar si los valores coinciden con los proporcionados
				if (headers != null && values.length >= 2) {
					// Buscar los índices de los encabezados proporcionados
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

					// Verificar si los encabezados existen y si los valores coinciden
					if (index1 != -1 && index2 != -1 && values.length > index1 && values.length > index2
							&& values[index1].trim().equals(value1) && values[index2].trim().equals(value2)) {
						// Crear y devolver un objeto AgenteDeTrafico con los valores encontrados
						Propietario pro1 = new Propietario();

						// Suponiendo que los índices 0, 1, 2, 3, 4 corresponden a nombres, apellidos,
						// cargo, clave y usuario respectivamente

						pro1.setApellidos(values[0]);
						pro1.setNombres(values[1]);
						pro1.setFechaDeNacimiento(values[2]);
						pro1.setNumeroDeContacto(values[3]);
						pro1.setTipoDeLicencia(values[4]);
						pro1.setLocalidad(values[5]);
						pro1.setMunicipio(values[6]);
						pro1.setDireccion(values[7]);
					
						return pro1;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; // No se encontró coincidencia o hubo un error
	}

}
