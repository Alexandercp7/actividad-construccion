package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import DAO.AgentesDAO;
import View.UsuariosVista;
import model.AgenteDeTrafico;

public class UserControl implements ActionListener{
	private UsuariosVista usersView; 
	private AgenteDeTrafico userModel;
	AgentesDAO ageDAO = new AgentesDAO();
	
	public UserControl(UsuariosVista usersView, AgenteDeTrafico user) {
		this.usersView = usersView;
		this.userModel = user;
		this.usersView.getBtnBuscarUsuario().addActionListener(this);
		this.usersView.getBtnEliminar().addActionListener(this);
		this.usersView.getBtnLimpiar().addActionListener(this);
		this.usersView.getBtnRegistrar().addActionListener(this);
		this.usersView.getBtnVolver().addActionListener(this);
	}
	
	public void showUsersMenu() {
		this.usersView.setVisible(true);
	}
	public void hideUsersMenu() {
		
		this.usersView.getTextApellidoUsr().setText("");
		this.usersView.getTextCargo().setText(""); 
		this.usersView.getTextFieldContraseña().setText("");
		this.usersView.getTextNombreUsr().setText("");
		this.usersView.getTextUsuario().setText("");
		this.usersView.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.usersView.getBtnVolver() == e.getSource()) {
			RegistroVehicularControl.switchToMainMenu();
		}
		
		if(this.usersView.getBtnBuscarUsuario() == e.getSource()) {
			String usr = this.usersView.getTextUsuario().getText();
			String pwd = this.usersView.getTextFieldContraseña().getText();
			this.userModel = ageDAO.getFromCSV("Usuario", usr, "Clave", pwd);
			
			if (this.userModel == null) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Usuario no encontrado.", "Error de Usuario", JOptionPane.PLAIN_MESSAGE);
			} else {
				this.usersView.getTextApellidoUsr().setText(userModel.getApellidos());
				this.usersView.getTextCargo().setText(userModel.getCargo()); 
				this.usersView.getTextFieldContraseña().setText(userModel.getClave()); 
				this.usersView.getTextNombreUsr().setText(userModel.getNombres());
				this.usersView.getTextUsuario().setText(userModel.getUsuario());
			}
						
		}
		
		if(this.usersView.getBtnEliminar() == e.getSource()) {
			String usr = this.usersView.getTextUsuario().getText();
			String pwd = this.usersView.getTextFieldContraseña().getText();
			if(ageDAO.deleteCSV("Usuario", usr, "Clave", pwd)) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.", "Acción Exitosa", JOptionPane.PLAIN_MESSAGE);
			}else {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "El usuario no se ha borrado exitosamente o no se ha encontrado.", "Acción Exitosa", JOptionPane.PLAIN_MESSAGE);

			}				
		}
		
		if(this.usersView.getBtnLimpiar() == e.getSource()) {
			this.usersView.getTextApellidoUsr().setText("");
			this.usersView.getTextCargo().setText(""); 
			this.usersView.getTextFieldContraseña().setText(""); 
			this.usersView.getTextNombreUsr().setText("");
			this.usersView.getTextUsuario().setText("");
		}
		
		if(this.usersView.getBtnRegistrar() == e.getSource()) {
			String apellidos = this.usersView.getTextApellidoUsr().getText();
			String cargo = this.usersView.getTextCargo().getText();
			String pwd = this.usersView.getTextFieldContraseña().getText();
			String nombres = this.usersView.getTextNombreUsr().getText();
			String usuario = this.usersView.getTextUsuario().getText();
			this.userModel = new AgenteDeTrafico(nombres, apellidos, cargo, usuario, pwd);
			
			if(ageDAO.insertCSV(userModel)) {
			UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
        	UIManager.put("Button.background", Color.WHITE);
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.", "Acción Exitosa", JOptionPane.PLAIN_MESSAGE);
			}else {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Usuario no ha sido registrado", "Registro Fallido", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
