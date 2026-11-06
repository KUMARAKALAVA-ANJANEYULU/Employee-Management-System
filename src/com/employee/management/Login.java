package com.employee.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JTextField tfusername,tfpassword;
	
	Login() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(40, 20, 100, 30);
		add(lblusername);
		
	    tfusername = new JTextField();
		tfusername.setBounds(150, 20, 150, 30);
		add(tfusername);
		
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(40, 70, 100, 30);
		add(lblpassword);
		
		 tfpassword = new JTextField();
		tfpassword.setBounds(150, 70, 150, 30);
		add(tfpassword);
		
		
		JButton login = new JButton("Login");
		login.setBounds(150, 140, 150, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		
		login.addActionListener(this);
		add(login);
		
		
		ImageIcon i1 =new ImageIcon(Splash.class.getResource("/icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		setSize(600,300);
		
		setLocation(440,200);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		try {
			
			String username = tfusername.getText();
			String password = tfpassword.getText();
			
			Conn c = new Conn();
			
			String query = "select * from login where username = ? AND password = ?";
			PreparedStatement ps = c.c.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Login Successful");
				setVisible(false);
				new Home();
				
				
				// next class
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username or password");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login(); 

	}

}
