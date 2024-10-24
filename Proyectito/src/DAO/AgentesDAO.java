package DAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.AgenteDeTrafico;


public class AgentesDAO implements DAO<AgenteDeTrafico>{

	private String con = AgentesCSV.getCon();
	
	public AgentesDAO(){
		createCSV();
	}

	@Override
    public boolean insertCSV(AgenteDeTrafico agente) {
        try (BufferedReader br = new BufferedReader(new FileReader(con))) {
            String line;

            // Verificar si el usuario y la clave ya existen en el archivo
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2 &&
                        values[0].trim().equals(agente.getUsuario())) {
                    System.out.println("Error: Usuario ya existente.");
                    return false; // No insertar si ya existen
                }
            }
        } catch (IOException e) {
            System.err.println("Error: No se ha encontrado el archivo de Agentes");
            e.printStackTrace(); // Imprimir detalles del error
            return false;
        }

        // No hay coincidencias, proceder con la inserción
        try (PrintWriter pw = new PrintWriter(new FileWriter(con, true))) {
            pw.println(agente.getUsuario() + "," + agente.getClave() + "," +
                    agente.getNombres() + "," + agente.getApellidos() + "," + agente.getCargo());
            System.out.println("Inserción exitosa.");
            return true;
        } catch (IOException e) {
            System.err.println("Error al insertar en el archivo de Agentes");
            e.printStackTrace(); // Imprimir detalles del error
        }
		return false;
    }


	@SuppressWarnings("resource")
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
	public void createCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(con, true));
                BufferedReader br = new BufferedReader(new FileReader(con))) {

               if (br.lines().skip(1).findFirst().isPresent()) {

               } else {
                   pw.println("Usuario,Clave,Nombres,Apellidos,Cargo");
                   pw.println("Admin1,Password1");
                   System.out.println("Archivo de Agentes creado correctamente...");
               }
           } catch (IOException e) {
               System.err.println("Error: No se ha encontrado el archivo de Agentes");
           }
	}



    public boolean existinCSV(String header1, String value1, String header2, String value2) {
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
                    if (index1 != -1 && index2 != -1 &&
                            values.length > index1 && values.length > index2 &&
                            values[index1].trim().equals(value1) && values[index2].trim().equals(value2)) {
                        return true; // Coincidencia encontrada
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // No se encontró coincidencia
    }

	@Override
	public AgenteDeTrafico getFromCSV(String header1, String value1, String header2, String value2) {
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
	                if (index1 != -1 && index2 != -1 &&
	                        values.length > index1 && values.length > index2 &&
	                        values[index1].trim().equals(value1) && values[index2].trim().equals(value2)) {
	                    // Crear y devolver un objeto AgenteDeTrafico con los valores encontrados
	                    AgenteDeTrafico agente = new AgenteDeTrafico();
	                    
	                    // Suponiendo que los índices 0, 1, 2, 3, 4 corresponden a nombres, apellidos, cargo, clave y usuario respectivamente
	                    agente.setNombres(values[2]);
	                    agente.setApellidos(values[3]);
	                    agente.setCargo(values[4]);
	                    agente.setClave(values[1]);
	                    agente.setUsuario(values[0]);

	                    return agente;
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return null; // No se encontró coincidencia o hubo un error
	}

	@Override
	public boolean updateCSV(AgenteDeTrafico t) {
		return false;
	}

	

	

}
