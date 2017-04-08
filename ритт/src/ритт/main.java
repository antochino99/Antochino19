package ритт;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class main {

	public static void main(String[] args) {
	
		JFrame form1=new JFrame("form1");
		form1.setLayout(new FlowLayout());
		form1.setSize(500, 500);
		form1.setVisible(true);
		form1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form1.setResizable(false);
		form1.setLocationRelativeTo(null);
		JButton b1= new JButton("Send");
		TextField t1 = new TextField(15);
		JLabel l3 = new JLabel ("Введите ваше имя");
		form1.add(l3);
		form1.add(t1);
		form1.add(b1);
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1){
					JFrame form2= new JFrame("form2");
					form2.setLayout(new FlowLayout());
					form2.setSize(500, 500);
					form2.setVisible(true);
					form2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					form2.setResizable(false);
					form2.setLocationRelativeTo(null);
					JLabel l4 = new JLabel("");
					form2.add(l4);
					l4.setText("Здравствуйте  " + t1.getText());
					form1.setVisible(false);
				}
				
			}
		});
	}

}
