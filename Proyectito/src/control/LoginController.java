package control;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import DAO.AgentesDAO;
import View.LoginView;


	public class LoginController  implements ActionListener{
		
		private LoginView loginView;
		
		LoginController(LoginView loginView) {
			this.loginView =loginView;
			this.loginView.getBtnIngresar().addActionListener(this);
			
		}
		
		public void hideLogin() {
			loginView.setVisible(false);
		}
		
		public void showLogin() {
			loginView.gettextFieldPassword().setText("");
			loginView.getTextFieldUsuario().setText("");
			loginView.setVisible(true);
		}
	
	
	@Override
		public void actionPerformed(ActionEvent e) {
			if(this.loginView.getBtnIngresar() == e.getSource()) {
				AgentesDAO agenteDAO = new AgentesDAO();
				String user = loginView.getTextFieldUsuario().getText();
				@SuppressWarnings("deprecation")
				String pwd = loginView.gettextFieldPassword().getText();
				
		        if (agenteDAO.existinCSV("Usuario", user, "Clave", pwd)) {
		            RegistroVehicularControl.switchToMainMenu();      
		        } else {
		  		    UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
		        	UIManager.put("Button.background", Color.WHITE);
		            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error de Login", JOptionPane.PLAIN_MESSAGE);
		        }
			}
		}

}