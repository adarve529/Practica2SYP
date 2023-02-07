package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCliente {

	private JFrame frame;
	private JLabel lblImagenUsuario;
	private JTextArea txtConversacion;
	private JTextField txtFieldMensajes;
	private JButton btnEnviar;
	private JButton btnSalir;
	private JPanel panelLogin;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JPasswordField pswField;
	private JTextField txtFieldUsuario;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCliente window = new FrameCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 456, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanelLogin());
		frame.getContentPane().add(getLblImagenUsuario());
		frame.getContentPane().add(getTxtConversacion());
		frame.getContentPane().add(getTxtFieldMensajes());
		frame.getContentPane().add(getBtnEnviar());
		frame.getContentPane().add(getBtnSalir());
	}
	private JLabel getLblImagenUsuario() {
		if (lblImagenUsuario == null) {
			lblImagenUsuario = new JLabel("");
			lblImagenUsuario.setIcon(new ImageIcon("C:\\Users\\miloi\\Documents\\Entregas\\Desarrollo de interfaces\\61d183263a856e0004c6334a.png"));
			lblImagenUsuario.setBounds(144, 11, 113, 109);
		}
		return lblImagenUsuario;
	}
	private JTextArea getTxtConversacion() {
		if (txtConversacion == null) {
			txtConversacion = new JTextArea();
			txtConversacion.setEditable(false);
			txtConversacion.setBounds(10, 131, 423, 259);
		}
		return txtConversacion;
	}
	private JTextField getTxtFieldMensajes() {
		if (txtFieldMensajes == null) {
			txtFieldMensajes = new JTextField();
			txtFieldMensajes.setBounds(10, 401, 424, 51);
			txtFieldMensajes.setColumns(10);
		}
		return txtFieldMensajes;
	}
	private JButton getBtnEnviar() {
		if (btnEnviar == null) {
			btnEnviar = new JButton("Enviar");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnEnviar.setBounds(10, 463, 105, 44);
		}
		return btnEnviar;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnSalir.setBounds(329, 463, 105, 44);
		}
		return btnSalir;
	}
	private JPanel getPanelLogin() {
		if (panelLogin == null) {
			panelLogin = new JPanel();
			panelLogin.setBackground(new Color(255, 228, 181));
			panelLogin.setBounds(78, 200, 281, 139);
			panelLogin.setLayout(null);
			panelLogin.add(getLblUsuario());
			panelLogin.add(getLblPassword());
			panelLogin.add(getPswField());
			panelLogin.add(getTxtFieldUsuario());
			panelLogin.add(getBtnAceptar());
		}
		return panelLogin;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(23, 31, 48, 14);
		}
		return lblUsuario;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(23, 79, 70, 14);
		}
		return lblPassword;
	}
	private JPasswordField getPswField() {
		if (pswField == null) {
			pswField = new JPasswordField();
			pswField.setBounds(118, 76, 125, 20);
		}
		return pswField;
	}
	private JTextField getTxtFieldUsuario() {
		if (txtFieldUsuario == null) {
			txtFieldUsuario = new JTextField();
			txtFieldUsuario.setBounds(118, 28, 125, 20);
			txtFieldUsuario.setColumns(10);
		}
		return txtFieldUsuario;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(1==1) {
						getPanelLogin().setVisible(false);
						getPanelLogin().setEnabled(false);
					}
				}
			});
			btnAceptar.setBounds(89, 107, 89, 23);
		}
		return btnAceptar;
	}
}

