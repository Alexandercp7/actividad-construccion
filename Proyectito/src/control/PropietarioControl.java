package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import DAO.PropietariosDAO;
import View.PropietarioVista;
import model.Propietario;

public class PropietarioControl implements ActionListener{
	private PropietarioVista proView;
	private Propietario proModel;
	private PropietariosDAO proDAO = new PropietariosDAO();
	
	public PropietarioControl(PropietarioVista proView, Propietario proModel) {
		super();
		this.proView = proView;
		this.proModel = proModel;
		
		this.proView.getBtnBuscarProp().addActionListener(this);
		this.proView.getBtnLimpiarProp().addActionListener(this);
		this.proView.getBtnModificarProp().addActionListener(this);
		this.proView.getBtnRegistrarProp().addActionListener(this); 
		this.proView.getBtnVolverMenu().addActionListener(this);
		this.proView.getBtnEliminar().addActionListener(this);
	}
	public void showOwnersMenu() {
		this.proView.setVisible(true);
	}
	public void hideOwnersMenu() {
		this.proView.getTextApellidos().setText("");
		this.proView.getTextContacto().setText("");
		this.proView.getTextDirección().setText("");
		this.proView.getTextLocalidad().setText("");
		this.proView.getTextMunicipio().setText("");
		this.proView.getTextNombreProp().setText("");
		this.proView.getOpcTipoLicencia().setSelectedItem("");
		this.proView.getTxtFechaNacimiento().setText("");
		this.proView.setVisible(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.proView.getBtnBuscarProp() == e.getSource()) {
			String nombres = this.proView.getTextNombreProp().getText();
			String apellidos = this.proView.getTextApellidos().getText();
			this.proModel = proDAO.getFromCSV("Apellidos", apellidos, "Nombres", nombres);
			
			if (this.proModel == null) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Propietario no encotrado.", "Error de Búsqueda", JOptionPane.PLAIN_MESSAGE);
			} else {
				this.proView.getTextApellidos().setText(proModel.getApellidos());
				this.proView.getTextContacto().setText(proModel.getNumeroDeContacto());
				this.proView.getTextDirección().setText(proModel.getDireccion());
				this.proView.getTextLocalidad().setText(proModel.getLocalidad());
				this.proView.getTextMunicipio().setText(proModel.getMunicipio());
				this.proView.getTextNombreProp().setText(proModel.getNombres());
				this.proView.getOpcTipoLicencia().setSelectedItem(proModel.getTipoDeLicencia());
				this.proView.getTxtFechaNacimiento().setText(proModel.getFechaDeNacimiento());
			}
			
		}
		
		if(this.proView.getBtnLimpiarProp() == e.getSource()) {
			this.proView.getTextApellidos().setText("");
			this.proView.getTextContacto().setText("");
			this.proView.getTextDirección().setText("");
			this.proView.getTextLocalidad().setText("");
			this.proView.getTextMunicipio().setText("");
			this.proView.getTextNombreProp().setText("");
			this.proView.getOpcTipoLicencia().setSelectedItem("");
			this.proView.getTxtFechaNacimiento().setText("");
		}
		
		if(this.proView.getBtnVolverMenu() == e.getSource()) {
			RegistroVehicularControl.switchToMainMenu();
		}
		
		if(this.proView.getBtnModificarProp() == e.getSource()) {
			String nombres = this.proView.getTextNombreProp().getText();
			String apellidos = this.proView.getTextApellidos().getText();
			String fechaDeNacimiento = this.proView.getTxtFechaNacimiento().getText();
			String localidad = this.proView.getTextLocalidad().getText(); 
			String municipio = this.proView.getTextMunicipio().getText();
			String direccion = this.proView.getTextDirección().getText();
			String numeroDeContacto = this.proView.getTextContacto().getText();
			String tipoDeLicencia = (String) this.proView.getOpcTipoLicencia().getSelectedItem();
			this.proModel= new Propietario(nombres,apellidos,fechaDeNacimiento,localidad,municipio,direccion,numeroDeContacto,tipoDeLicencia);

				if(!proDAO.updateCSV(proModel)) {
					UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
		        	UIManager.put("Button.background", Color.WHITE);
		        	JOptionPane.showMessageDialog(null, "No se ha podido actualizar el Propietario.", "Error de Modificación", JOptionPane.PLAIN_MESSAGE);
		        	
				}else {
					UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
		        	UIManager.put("Button.background", Color.WHITE);
		            JOptionPane.showMessageDialog(null, "Propietario actualizado con éxito.", "Acción Exitosa", JOptionPane.PLAIN_MESSAGE);
				}
			
			
		}
		
		if(this.proView.getBtnRegistrarProp() == e.getSource()) {
			String nombres = this.proView.getTextNombreProp().getText();
			String apellidos = this.proView.getTextApellidos().getText();
			String fechaDeNacimiento = this.proView.getTxtFechaNacimiento().getText();
			String localidad = this.proView.getTextLocalidad().getText(); 
			String municipio = this.proView.getTextMunicipio().getText();
			String direccion = this.proView.getTextDirección().getText();
			String numeroDeContacto = this.proView.getTextContacto().getText();
			String tipoDeLicencia = (String) this.proView.getOpcTipoLicencia().getSelectedItem();
			this.proModel= new Propietario(nombres,apellidos,fechaDeNacimiento,localidad,municipio,direccion,numeroDeContacto,tipoDeLicencia);
			if(proDAO.insertCSV(proModel)) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Propietario registrado con éxito.", "Acción Exitosa", JOptionPane.PLAIN_MESSAGE);
			
			}else {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "No se ha registrado correctamente el propietario", "Registro fallido", JOptionPane.PLAIN_MESSAGE);
			
			}
		}
		if(this.proView.getBtnEliminar() == e.getSource()) {
			String apellidos = this.proView.getTextApellidos().getText();
			String nombres = this.proView.getTextNombreProp().getText();
			
			
			
			if( proDAO.deleteCSV("Nombres", nombres, "Apellidos", apellidos)) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Propietario eliminado con éxito.", "Acción Exitosa", JOptionPane.PLAIN_MESSAGE);
			}else {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "El propietario no se ha borrado exitosamente o no se ha encontrado.", "Error al borrar", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
