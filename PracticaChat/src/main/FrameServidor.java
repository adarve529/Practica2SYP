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

public class FrameServidor {

	private JFrame frame;
	private JLabel lblImagenUsuario;
	private JTextArea txtConversacion;
	private JTextField txtFieldMensajes;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameServidor window = new FrameServidor();
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
	public FrameServidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 456, 552);
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().add(getLblImagenUsuario());
		frame.getContentPane().add(getTxtConversacion());
		frame.getContentPane().add(getTxtFieldMensajes());
		frame.getContentPane().add(getBtnEnviar());
	}
	private JLabel getLblImagenUsuario() {
		if (lblImagenUsuario == null) {
			lblImagenUsuario = new JLabel("");
			lblImagenUsuario.setBounds(163, 11, 113, 109);
			
			Image img= new ImageIcon("img\\amongus_verde.png").getImage();
			ImageIcon img2=new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));

			lblImagenUsuario.setIcon(img2);
			
//			lblImagenUsuario.setIcon(new ImageIcon());
			
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
}


