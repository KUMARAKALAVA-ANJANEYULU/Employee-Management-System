package com.employee.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


	
	
	
	public class UpdateEmployee extends JFrame implements ActionListener{
		
	
		
		JTextField tfeducation,tffname,tfaddress,tfphone,tfemail,tfsalary,tfdesignation;
	
	
		JLabel lblempId,labelempId;
		JButton add,back;
		JDateChooser dateChooser;
		String empId;
		
		UpdateEmployee(String empId) {
			
			this.empId = empId;
			
			getContentPane().setBackground(Color.WHITE);
			
			setLayout(null);
			
			JLabel heading = new JLabel("Update Employee Detail");
			heading.setBounds(320,30,500,50);
			heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
			add(heading);
			
			
			JLabel labelname = new JLabel("Name");
			labelname.setBounds(50, 150,150, 30);
			labelname.setFont(new Font("serif",Font.PLAIN,20));
			add(labelname);
			
		    JLabel lblname = new JLabel();
		    lblname.setBounds(200,150,150,30);
			add(lblname);
			
			
			JLabel labelfname = new JLabel("Fathers Name");
			labelfname.setBounds(400, 150,150, 30);
			labelfname.setFont(new Font("serif",Font.PLAIN,20));
			add(labelfname);
			
		    tffname = new JTextField();
			tffname.setBounds(600,150,150,30);
			add(tffname);
			
			
			JLabel labeldob = new JLabel("Date of Birth");
			labeldob.setBounds(50, 200,150, 30);
			labeldob.setFont(new Font("serif",Font.PLAIN,20));
			add(labeldob);
			
			dateChooser = new JDateChooser();
			dateChooser.setBounds(200,200,150,30);
			add(dateChooser);
			
			
			JLabel labelsalary = new JLabel("Salary");
			labelsalary .setBounds(400, 200,150, 30);
			labelsalary .setFont(new Font("serif",Font.PLAIN,20));
			add(labelsalary);
			
		    tfsalary = new JTextField();
			tfsalary.setBounds(600,200,150,30);
			add(tfsalary);
			
			
			JLabel labeladdress = new JLabel("Address");
			labeladdress .setBounds(50, 250,150, 30);
			labeladdress .setFont(new Font("serif",Font.PLAIN,20));
			add(labeladdress);
			
		    tfaddress = new JTextField();
			tfaddress.setBounds(200,250,150,30);
			add(tfaddress);
			
			
			JLabel labelphone = new JLabel("Phone");
			labelphone.setBounds(400, 250,150, 30);
			labelphone.setFont(new Font("serif",Font.PLAIN,20));
			add(labelphone);
			
		    tfphone = new JTextField();
			tfphone.setBounds(600,250,150,30);
			add(tfphone);
			
			
			JLabel labelemail = new JLabel("Email");
			labelemail .setBounds(50, 300,150, 30);
			labelemail .setFont(new Font("serif",Font.PLAIN,20));
			add(labelemail);
			
			tfemail = new JTextField();
			tfemail.setBounds(200,300,150,30);
			add(tfemail);
			
			
			JLabel labeleducation = new JLabel("Highest Education");
			labeleducation.setBounds(400, 300,150, 30);
			labeleducation.setFont(new Font("serif",Font.PLAIN,20));
			add(labeleducation);
			
		    tfeducation = new JTextField();
		    tfeducation.setBackground(Color.white);
		    tfeducation.setBounds(600,300,150,30);
		    add(tfeducation);
			
			
			
			JLabel labeldesignation = new JLabel("Designation");
			labeldesignation .setBounds(50, 350,150, 30);
			labeldesignation .setFont(new Font("serif",Font.PLAIN,20));
			add(labeldesignation);
			
			tfdesignation = new JTextField();
			tfdesignation.setBounds(200,350,150,30);
			add(tfdesignation);
			
			
			JLabel labeladhar = new JLabel("Adhar Number");
			labeladhar.setBounds(400, 350,150, 30);
			labeladhar.setFont(new Font("serif",Font.PLAIN,20));
			add(labeladhar);
			
			JLabel lbladhar = new JLabel();
			lbladhar.setBounds(600,350,150,30);
			add(lbladhar);
			
			
			
			labelempId = new JLabel("Employee Id");
			labelempId.setBounds(50, 400,150, 30);
			labelempId.setFont(new Font("serif",Font.PLAIN,20));
			add(labelempId);
			
			
		    lblempId = new JLabel();
			lblempId.setBounds(200, 400,150, 30);
			lblempId.setFont(new Font("serif",Font.PLAIN,20));
			add(lblempId);
			
			back = new JButton("Back");
			back.setBounds(450,550,150,40);
			
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.addActionListener(this);
			
			try {
				Conn c = new Conn();
				String query = "select * from employee where empId = '" +empId+"'";
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					lblname.setText(rs.getString("name"));
					tffname.setText(rs.getString("fname"));
					
					java.util.Date dob = rs.getDate("dob");
					if(dob!=null) {
						dateChooser.setDate(dob);
					}
					tfaddress.setText(rs.getString("address"));
					tfsalary.setText(rs.getString("salary"));
					tfphone.setText(rs.getString("phone"));
					tfemail.setText(rs.getString("email"));
					tfeducation.setText(rs.getString("education"));
					lbladhar.setText(rs.getString("aadhar"));
					lblempId.setText(rs.getString("empId"));
					tfdesignation.setText(rs.getString("designation"));
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		
			
			
		    add = new JButton("Update Details");
			add.setBounds(250, 550, 150, 40);
			add.addActionListener(this);
		    add.setBackground(Color.BLACK);
		    add.setForeground(Color.white);
			add(add);
			
			
			back = new JButton("Back");
			back.setBounds(450, 550, 150, 40);
			back.addActionListener(this);
		    back.setBackground(Color.BLACK);
		    back.setForeground(Color.white);
			add(back);
			
			
			
			
			
			
			
			
			
			
			
			setSize(900,700);
			setLocation(300,50);
			setVisible(true);
			
		}
		
		

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			

				//String name = tfname.getText();
				if(ae.getSource()==add) {
					
				String fname  = tffname.getText();
				
				
				
				String salary = tfsalary.getText();
				String address = tfaddress.getText();
				
				String phone = tfphone.getText();
				String email = tfemail.getText();
				String education = tfeducation.getText();
				String designation = tfdesignation.getText();
				
				if(dateChooser.getDate()==null) {
					JOptionPane.showMessageDialog(null,"Please select Date of Birth");
					return ;
				}
				String dob = new java.text.SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
				
				
				
				try {
					Conn conn = new Conn();
					String query = "UPDATE employee SET "
					        + "fname = '" + fname + "', "
					        + "dob = '" + dob + "', "
					        + "salary = '" + salary + "', "
					        + "address = '" + address + "', "
					        + "phone = '" + phone + "', "
					        + "email = '" + email + "', "
					        + "education = '" + education + "', "
					        + "designation = '" + designation + "' "
					        + "WHERE empId = '" + empId + "'";

					conn.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null,"Details updated Successfully");
					setVisible(false);
					new Home();
					
				}catch (Exception e) {
					e.printStackTrace();
					
				}
				}else {
					setVisible(false);
					}
				new Home();
				
	}
					
			
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new UpdateEmployee("");
	}
			}


