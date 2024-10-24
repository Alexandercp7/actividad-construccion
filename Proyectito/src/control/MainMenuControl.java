package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MenuVista;

public class MainMenuControl implements ActionListener{
	
	
	private MenuVista mVista;
	
	public MainMenuControl(MenuVista mVista) {
		this.mVista =mVista;
		this.mVista.getBtnMenuVehiculos().addActionListener(this);;
		this.mVista.getBtnCerrarSesion().addActionListener(this);
		this.mVista.getBtnMenuPropietarios().addActionListener(this);
		this.mVista.getBtnMenuUsuarios().addActionListener(this);
	}
	
	public void showMenu() {
		this.mVista.setVisible(true);
	}
	public void hideMenu() {
		this.mVista.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.mVista.getBtnCerrarSesion() == e.getSource()) {
			RegistroVehicularControl.switchToLogin(); 
		}
		
		if(this.mVista.getBtnMenuPropietarios() == e.getSource()) {
			RegistroVehicularControl.switchToOwnersMenu();
		}
		
		if(this.mVista.getBtnMenuUsuarios() == e.getSource()) {
			RegistroVehicularControl.switchToUsersMenu();
		}
		
		if(this.mVista.getBtnMenuVehiculos() == e.getSource()) {
			RegistroVehicularControl.switchToVehiclesMenu();
		}
		
		
	}
	
}
