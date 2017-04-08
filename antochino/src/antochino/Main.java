package antochino;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import java.net.InetAddress;
import javax.swing.JFrame;

public class Main extends JFrame implements Runnable {


	private static ObjectInputStream input1;
	private static ObjectOutputStream output1;
	private Socket connection;
	public static void main(String[] args) {
		new Thread (new Main("Client")).start();
		new Thread (new Server()).start();
	}
	public  Main(String name){
		super(name);
		setLayout(new FlowLayout());
		setSize(500 , 500);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JLabel l1 = new JLabel("Введите Ваше имя");
		JTextField t1= new JTextField(15);
		JButton b1 =new JButton("Зарегистрировать");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
					sendDate(t1.getText());
		}
		}
		}
		);
		add(l1);
		add(t1);
		add(b1);
	}
	public void run() {
	while(true){
			 try {
				connection= new Socket (InetAddress.getByName("192.168.43.236"),5678);
				output1=new ObjectOutputStream(connection.getOutputStream());
				input1 = new ObjectInputStream(connection.getInputStream());
				try {
					JOptionPane.showMessageDialog(null, (String)input1.readObject());
				} catch (HeadlessException e) {
				} catch (ClassNotFoundException e) {}
			 	} catch (UnknownHostException e) {
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
}

