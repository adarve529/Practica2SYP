package main;

import java.awt.EventQueue;
import java.awt.Image;

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
import java.awt.Font;

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
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				FrameCliente window = new FrameCliente();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
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
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.setBounds(100, 100, 456, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().add(getPanelLogin());
		frame.getContentPane().add(getLblImagenUsuario());
		frame.getContentPane().add(getTxtConversacion());
		frame.getContentPane().add(getTxtFieldMensajes());
		frame.getContentPane().add(getBtnEnviar());
		frame.getContentPane().add(getBtnSalir());
	}
	public JLabel getLblImagenUsuario() {
		if (lblImagenUsuario == null) {
			lblImagenUsuario = new JLabel("");
			lblImagenUsuario.setBounds(163, 11, 113, 109);
			
			Image img= new ImageIcon("img\\amongus_rojo.png").getImage();
			ImageIcon img2=new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));

			lblImagenUsuario.setIcon(img2);
			
//			lblImagenUsuario.setIcon(new ImageIcon());
			
		}
		return lblImagenUsuario;
	}
	public JTextArea getTxtConversacion() {
		if (txtConversacion == null) {
			txtConversacion = new JTextArea();
			txtConversacion.setFont(new Font("Courier New", Font.PLAIN, 14));
			txtConversacion.setText("Introduce usuario y password...");
			txtConversacion.setEditable(false);
			txtConversacion.setBounds(10, 131, 423, 259);
		}
		return txtConversacion;
	}
	public JTextField getTxtFieldMensajes() {
		if (txtFieldMensajes == null) {
			txtFieldMensajes = new JTextField();
			txtFieldMensajes.setBounds(10, 401, 424, 51);
			txtFieldMensajes.setColumns(10);
		}
		return txtFieldMensajes;
	}
	public JButton getBtnEnviar() {
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
	public JButton getBtnSalir() {
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
	public JPanel getPanelLogin() {
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
	public JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(23, 31, 48, 14);
		}
		return lblUsuario;
	}
	public JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(23, 79, 70, 14);
		}
		return lblPassword;
	}
	public JPasswordField getPswField() {
		if (pswField == null) {
			pswField = new JPasswordField();
			pswField.setBounds(118, 76, 125, 20);
		}
		return pswField;
	}
	public JTextField getTxtFieldUsuario() {
		if (txtFieldUsuario == null) {
			txtFieldUsuario = new JTextField();
			txtFieldUsuario.setBounds(118, 28, 125, 20);
			txtFieldUsuario.setColumns(10);
		}
		return txtFieldUsuario;
	}
	public JButton getBtnAceptar() {
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

