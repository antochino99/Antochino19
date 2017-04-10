import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main2 extends JFrame implements Runnable {
	
	private static ObjectOutputStream output1;
	private Socket connection;
	private JFrame frmClient;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Thread (new Main2()).start();
		new Thread (new Server2()).start();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 window = new Main2();
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
	public Main2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmClient.setTitle("Client2");
		frmClient.setBounds(100, 100, 540, 365);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(246, 42, 256, 114);
		frmClient.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0414\u0438\u0430\u043B\u043E\u0433\u043E\u0432\u043E\u0435 \u043E\u043A\u043D\u043E:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 42, 191, 23);
		frmClient.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u041E\u0442\u043F\u0440\u0430\u0432\u0438\u0442\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
					sendDate(textField.getText());
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(380, 241, 122, 23);
		frmClient.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(245, 241, 115, 23);
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
		 public static class Server2  implements Runnable {
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
