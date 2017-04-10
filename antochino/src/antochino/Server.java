package antochino;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.*;
import java.io.*;
import javax.swing.JFrame;
import java.net.*;

public class Server  implements Runnable {
	private static ServerSocket server;
	private static Socket connection;
	private static ObjectInputStream input1;
	private static ObjectOutputStream output1;
	static String a;
	
	public void run() {
	try{
		server= new ServerSocket(5678, 10);
	while(true){
			connection= server.accept();
			output1 = new ObjectOutputStream(connection.getOutputStream());
			input1 = new ObjectInputStream(connection.getInputStream());
			output1.writeObject("Ваше сообщение получено "+ (String)input1.readObject());
			Reader("profiles" , input1);
	}
	
	}catch(Exception e ){ System.out.println("Ошибка");
			System.exit(1);		
	};
	 }

	
	
	
	
	
	public static void Reader (String file_name ,  Object obj){ 
		try {
			FileOutputStream fileout = new FileOutputStream (file_name+".ser");
			ObjectOutputStream out = new ObjectOutputStream (fileout);
			out.writeObject(obj);
			fileout.close();
			out.close();
		}catch (FileNotFoundException e ){
			System.out.println("Файл не найден");
			System.exit(1);
		} catch (IOException e) {
				System.out.println("Ошибка ввода , вывода");
				System.exit(2);
		}
		

	}
	}

	



