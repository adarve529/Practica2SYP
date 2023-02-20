package main;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class FrameCliente {

	public static JFrame frame;
	static JLabel lblImagenUsuario;
	static JTextArea txtConversacion;
	static JTextField txtFieldMensajes;
	static JButton btnEnviar;
	static JButton btnSalir;
	static JPanel panelLogin;
	static JLabel lblUsuario;
	static JLabel lblPassword;
	static JPasswordField pswField;
	static JTextField txtFieldUsuario;
	static JButton btnAceptar;
	static Socket socket;
	static DataInputStream in;
	static DataOutputStream out; 
	static boolean isClosed;
    static Date date;

    static boolean validacion;
    private JScrollPane scrollPane;
    private static JLabel lblDireccion;
    private static JTextField txtFieldDireccion;
    
    
    static String direccion;
    
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
		
//		 date = new Date();
//		 SimpleDateFormat dateFormat = new SimpleDateFormat(" HH:mm");
//		 String formattedDate = dateFormat.format(date);
			
			  try {
				  
				  //192.168.166.204
			        		

				  socket = new Socket("192.168.166.204", 3434);

				  socket = new Socket(direccion, 3434);

			      System.out.println("Conectado al servidor");

			      
			      in = new DataInputStream(socket.getInputStream());
			      out = new DataOutputStream(socket.getOutputStream());			  
			      
			      String mensaje = "";
			      isClosed = false;
//			      System.out.println(validacion);
			      while (!isClosed) {	
			    	  
//			    		System.out.println(validacion);
//			    		out.writeUTF("ttt_gh56h");
//			    		System.out.println("validacion a true y mando mensaje a servidor");
//						out.writeUTF("\nCliente conectado.");
						
			        mensaje = in.readUTF();
			        txtConversacion.setText(txtConversacion.getText().trim() + "\n Server: " + mensaje);

			      
			      } if(isClosed) {
			    	  socket.close();
			      }
			     
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
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
		
		frame.setResizable(false);
		frame.getContentPane().add(getPanelLogin());
		frame.getContentPane().add(getLblImagenUsuario());
		frame.getContentPane().add(getTxtFieldMensajes());
		frame.getContentPane().add(getBtnEnviar());
		frame.getContentPane().add(getBtnSalir());
		frame.getContentPane().add(getScrollPane());
	}
	public static JLabel getLblImagenUsuario() {
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
	public static JTextArea getTxtConversacion() {
		if (txtConversacion == null) {
			txtConversacion = new JTextArea();
			txtConversacion.setFont(new Font("Courier New", Font.PLAIN, 14));
			txtConversacion.setText("Introduce usuario y password...");
			txtConversacion.setEditable(false);
		}
		return txtConversacion;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 118, 424, 272);
			scrollPane.setViewportView(getTxtConversacion());
		}
		return scrollPane;
	}
	
	public static JTextField getTxtFieldMensajes() {
		if (txtFieldMensajes == null) {
			txtFieldMensajes = new JTextField();
			txtFieldMensajes.setEditable(false);
			txtFieldMensajes.setBounds(10, 401, 424, 51);
			txtFieldMensajes.setColumns(10);
			txtFieldMensajes.setFont(new Font("Courier New", Font.PLAIN, 14));
		}
		return txtFieldMensajes;
	}
	public static JButton getBtnEnviar() {
		if (btnEnviar == null) {
			btnEnviar = new JButton("Enviar");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							
					try {
						
						if(!txtFieldMensajes.getText().trim().isEmpty()) {
							
							String mensaje = "";
							mensaje = txtFieldMensajes.getText().trim();
							out.writeUTF(mensaje);
							
							txtFieldMensajes.setText("");	
							
							txtConversacion.setText(txtConversacion.getText().trim() + "\n>>>>> Cliente: " + mensaje);
							
						}
																		
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			btnEnviar.setBounds(10, 463, 105, 44);
		}
		return btnEnviar;
	}
	public static JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					isClosed = true;
					txtConversacion.setText(txtConversacion.getText() + "\n Conexión finalizada");
					
				
				}
			});
			btnSalir.setBounds(329, 463, 105, 44);
			
		}
		return btnSalir;
	}
	public static JPanel getPanelLogin() {
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
			panelLogin.add(getLblDireccion());
			panelLogin.add(getTxtFieldDireccion());
		}
		return panelLogin;
	}
	public static JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(23, 31, 48, 14);
		}
		return lblUsuario;
	}
	public static JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(23, 59, 70, 14);
		}
		return lblPassword;
	}
	public static JPasswordField getPswField() {
		if (pswField == null) {
			pswField = new JPasswordField();
			pswField.setBounds(118, 56, 125, 20);
		}
		return pswField;
	}
	public static JTextField getTxtFieldUsuario() {
		if (txtFieldUsuario == null) {
			txtFieldUsuario = new JTextField();
			txtFieldUsuario.setBounds(118, 28, 125, 20);
			txtFieldUsuario.setColumns(10);
		}
		return txtFieldUsuario;
	}
	public static JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					direccion = getTxtFieldDireccion().getText();
					if (validacion()) {
						// Acceso permitido
						// System.out.println("acceso permitido");
						txtConversacion.setText(txtConversacion.getText() + "\nConexión establecida corréctamente.");
						getPanelLogin().setVisible(false);
						getPanelLogin().setEnabled(false);

						getTxtConversacion().setText(getTxtConversacion().getText() + "\nCliente conectado.");

						txtFieldMensajes.setEditable(true);
						
						try {
							out.writeUTF("ttt_gh56h");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						System.out.println("envio a servidor ttt_gh56h");
						
					} else {

						// Acceso denegado
//						txtConversacion.setText(txtConversacion.getText() + "\n Conexión fallida.");
//						txtConversacion.setText(txtConversacion.getText() + "\n Introduce usuario y password...");
						
//						frame.setComponentZOrder(getPanelLogin(), 0);
						
						JOptionPane.showMessageDialog(frame, "Conexion fallida.\nIntroduce de nuevo los campos.","ERROR", JOptionPane.ERROR_MESSAGE);
						getTxtFieldUsuario().setText("");
						getTxtFieldDireccion().setText("");
						getPswField().setText("");


					}
				}
			});
			btnAceptar.setBounds(89, 107, 89, 23);
		}
		return btnAceptar;
	}
	
	public static boolean validacion() {
		
		String username = txtFieldUsuario.getText();
		  char[] passwordChar = pswField.getPassword();
		  String password = new String(passwordChar);
		  
		  if (username.equals("admin") && password.equals("admin")) {
		      // Acceso permitido
			 validacion = true;
			 return true;
			 
		  } else {
		      // Acceso denegado
		       return false;
		  }	
	}	
	private static JLabel getLblDireccion() {
		if (lblDireccion == null) {
			lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(23, 87, 70, 14);
		}
		return lblDireccion;
	}
	private static JTextField getTxtFieldDireccion() {
		if (txtFieldDireccion == null) {
			txtFieldDireccion = new JTextField();
			txtFieldDireccion.setColumns(10);
			txtFieldDireccion.setBounds(118, 84, 125, 20);
		}
		return txtFieldDireccion;
	}
}

