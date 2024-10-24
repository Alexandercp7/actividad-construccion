package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldPassword;
	private JButton btnIngresar;
	private JLabel lblContra;
	private JLabel lblUsuario;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/view/img/semaforo.png")));
		setTitle("Registro Vehicular");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(263, 61, 400, 160);
		lblLogo.setIcon(new ImageIcon(LoginView.class.getResource("/view/img/car_logoproject.png")));
		contentPane.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("Bienvenido al Sistema de Registro Vehicular");
		lblTitulo.setBounds(183, 226, 560, 37);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Poppins Medium", Font.BOLD, 24));
		contentPane.add(lblTitulo);
		
		JLabel lblSubtitulo = new JLabel("Por favor, ingrese sus credenciales.");
		lblSubtitulo.setBounds(288, 268, 350, 30);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setFont(new Font("Poppins", Font.ITALIC, 20));
		contentPane.add(lblSubtitulo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(403, 333, 79, 30);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Poppins", Font.PLAIN, 20));
		contentPane.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(352, 368, 181, 25);
		textFieldUsuario.setToolTipText("");
		textFieldUsuario.setFont(new Font("Poppins", Font.PLAIN, 12));
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(5);
		
		lblContra = new JLabel("Contraseña:");
		lblContra.setBounds(381, 428, 122, 30);
		lblContra.setHorizontalAlignment(SwingConstants.CENTER);
		lblContra.setFont(new Font("Poppins", Font.PLAIN, 20));
		contentPane.add(lblContra);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(352, 463, 181, 23);
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textFieldPassword);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(255, 255, 255));
		btnIngresar.setBorderPainted(false);
		btnIngresar.setBounds(391, 519, 102, 27);
		btnIngresar.setFont(new Font("Poppins", Font.PLAIN, 12));
		contentPane.add(btnIngresar);
	}

	
		public JTextField getTextFieldUsuario() {
			return textFieldUsuario;
		}
	
		public void setTextFieldUsuario(JTextField textFieldUsuario) {
			this.textFieldUsuario = textFieldUsuario;
		}
	
		public JPasswordField gettextFieldPassword() {
			return textFieldPassword;
		}
	
		public void settextFieldPassword(JPasswordField passwordField) {
			this.textFieldPassword = passwordField;
		}
	

		public JButton getBtnIngresar() {
			return btnIngresar;
		}

		public void setBtnIngresar(JButton btnIngresar) {
			this.btnIngresar = btnIngresar;
		}

		public JLabel getLblUsuario() {
			return lblUsuario;
		}

		public void setLblUsuario(JLabel lblUsuario) {
			this.lblUsuario = lblUsuario;
		}


		public void setLblContra(JLabel lblContra) {
			this.lblContra = lblContra;
		}

}

