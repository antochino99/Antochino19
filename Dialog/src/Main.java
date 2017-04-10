import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;



import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements Runnable {
	
	private static ObjectOutputStream output1;
	private Socket connection;
	private JFrame frmClient;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Thread (new Main()).start();
		new Thread (new Server1()).start();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmClient.getContentPane().setForeground(new Color(192, 192, 192));
		frmClient.setTitle("Client1");
		frmClient.setBounds(100, 100, 495, 388);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0414\u0438\u0430\u043B\u043E\u0433\u043E\u0432\u043E\u0435 \u043E\u043A\u043D\u043E:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 24, 169, 14);
		frmClient.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u041E\u0442\u043F\u0440\u0430\u0432\u0438\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
					sendDate(textField.getText());
				}
			}
			});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(366, 273, 103, 23);
		frmClient.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(201, 24, 268, 150);
		frmClient.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(201, 273, 103, 23);
		frmClient.getContentPane().add(btnNewButton_1);
	}
			
	public void run() {
		while(true){
			 try {
				connection= new Socket (InetAddress.getByName("192.168.43.236"),5678);
				output1=new ObjectOutputStream(connection.getOutputStream());
				
				
			}catch (IOException e) {
			}
		}
	 }
		 public void sendDate(Object obj){
			 try {
				output1.flush();
				} catch (IOException e) {
				}
			 try {
				output1.writeObject(obj);
				} catch (IOException e) {
			}
}
		 public static class Server1  implements Runnable {
				private static ServerSocket server;
				private static Socket connection;
				private static ObjectInputStream input1;
			
				
				public void run() {
					
					
					try {
						server = new ServerSocket(5678, 19);
						while(true){
							connection= server.accept();
							input1 = new ObjectInputStream(connection.getInputStream());
							
							try {
								JOptionPane.showMessageDialog(null, (String)input1.readObject());
							} catch (HeadlessException e) {
							
							} catch (ClassNotFoundException e) {
							
							}
						
								
							
						}
					} catch (IOException e) {
						
					}
					
					
	}
		 }
}