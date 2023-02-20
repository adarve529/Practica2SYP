package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FrameServidor{

	 public JFrame frame;
	 static JLabel lblImagenUsuario;
	 static JTextArea txtConversacion;
	 static JTextField txtFieldMensajes;
	 static JButton btnEnviar;
	 static ServerSocket serverSocket;
	 static Socket socket;
	 static DataInputStream in;
	 static DataOutputStream out;
	 static Date date;
	 
	 static boolean validacion;
	 private static JScrollPane scrollPane;
	

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
		
        
//		 date = new Date();
//		 SimpleDateFormat dateFormat = new SimpleDateFormat(" HH:mm");
//		 String formattedDate = dateFormat.format(date);
				
		 String mensaje = "";
		 
		  try {
		      serverSocket = new ServerSocket(3434);
		      getTxtConversacion().setText("Servidor arrancado.");
		      
		      
		      socket = serverSocket.accept();
//		      getTxtConversacion().setText(getTxtConversacion().getText() + "\n Cliente conectado.");
	     
		       in = new DataInputStream(socket.getInputStream());
		       out = new DataOutputStream(socket.getOutputStream());
	
		       

		       
		       
		      while (!FrameCliente.isClosed) {
		        mensaje = in.readUTF();
		        txtConversacion.setText(txtConversacion.getText().trim() + "\n Cliente: " + mensaje);
		        
     	        out.writeUTF(mensaje);



		       while (!FrameCliente.isClosed) {
		    	   mensaje = in.readUTF();
		    	   if(mensaje.equals("ttt_gh56h")) {
		    		   txtFieldMensajes.setEditable(true);
		    	   }
		    	   else {
		    	   System.out.println(mensaje);
		    		   txtConversacion.setText(txtConversacion.getText().trim() + "\n Cliente: " + mensaje);
		    	   }
		    	   

		    	   // System.out.print("Escribe un mensaje: ");
		    	   //		        Scanner scanner = new Scanner(System.in);
		    	   //		        mensaje = scanner.nextLine();
		    	   //
//		        out.writeUTF(mensaje);

		        
		      }
		      if(FrameCliente.isClosed) {
		    	  socket.close();
		      }
		     	     
		      
		    }
		  }catch (IOException e) {
		      e.printStackTrace();
		    }
	}

	/**
	 * Create the application.
	 */
	public FrameServidor() {
		validacion = false;
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
		frame.getContentPane().add(getScrollPane());
		frame.setResizable(false);
		frame.getContentPane().add(getLblImagenUsuario());
		frame.getContentPane().add(getTxtFieldMensajes());
		frame.getContentPane().add(getBtnEnviar());
		
	}
	public static JLabel getLblImagenUsuario() {
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
	public static JTextArea getTxtConversacion() {
		if (txtConversacion == null) {
			txtConversacion = new JTextArea();
			txtConversacion.setText(null);
			txtConversacion.setFont(new Font("Courier New", Font.PLAIN, 14));
			txtConversacion.setEditable(false);
		}
		return txtConversacion;
	}
	
	private static JScrollPane getScrollPane() {
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
			txtFieldMensajes.setBounds(10, 401, 424, 51);
			txtFieldMensajes.setColumns(10);
			txtFieldMensajes.setEditable(false);
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
							
							txtConversacion.setText(txtConversacion.getText().trim() + "\n>>>>> Servidor: " + mensaje);
							
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
	
}


