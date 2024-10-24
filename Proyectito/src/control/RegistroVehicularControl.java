package control;

import View.LoginView;
import View.MenuVista;
import View.PropietarioVista;
import View.UsuariosVista;
import View.VehiculosView;
import model.AgenteDeTrafico;
import model.Automovil;
import model.Motocicleta;
import model.Propietario;
import model.VehiculosDeCarga;

public class RegistroVehicularControl {

    private LoginView logView;
    private static LoginController logControl;
    private MenuVista menuView;
    private static MainMenuControl menuControl;
    private UsuariosVista usersMenuView;
    private static UserControl usersMenuControl;
    private AgenteDeTrafico modeloAgente;
    private static PropietarioControl proControl;
    private Propietario modeloPro;
    private PropietarioVista proView;
    private static VehiculoControl vehControl;
    private Automovil modeloAuto;
    private Motocicleta modeloMoto;
    private VehiculosDeCarga modeloCarga;
    private VehiculosView vehView;
    public RegistroVehicularControl() {
    	
        logView = new LoginView();
        logControl = new LoginController(logView);
        
        menuView = new MenuVista();
        menuControl = new MainMenuControl(menuView);      
        
        modeloAgente = new AgenteDeTrafico();
        usersMenuView = new UsuariosVista();
        usersMenuControl = new UserControl(usersMenuView, modeloAgente);
        
        modeloPro = new Propietario();
        proView = new PropietarioVista();
        proControl = new PropietarioControl(proView, modeloPro);
        
        modeloAuto = new Automovil();
        vehView= new VehiculosView();
        vehControl = new VehiculoControl(vehView, modeloMoto, modeloAuto, modeloCarga);
        logControl.showLogin(); 
    }
    
    public static void switchToMainMenu() {
    	RegistroVehicularControl.hideAll();
    	menuControl.showMenu();
    }
    
    public static void switchToLogin() {
    	RegistroVehicularControl.hideAll();
    	logControl.showLogin();
    }
   public static void switchToOwnersMenu() {
	   RegistroVehicularControl.hideAll();
	   proControl.showOwnersMenu();
   }
    public static void switchToUsersMenu() {
    	RegistroVehicularControl.hideAll();
    	usersMenuControl.showUsersMenu();
    }
    public static void switchToVehiclesMenu() {
    	RegistroVehicularControl.hideAll();
    	vehControl.showVehicleMenu();
    }

    
    public static void hideAll() {
    	logControl.hideLogin();
    	menuControl.hideMenu();
    	proControl.hideOwnersMenu();
    	usersMenuControl.hideUsersMenu();
    	vehControl.HideVehicleMenu();
    }
}
