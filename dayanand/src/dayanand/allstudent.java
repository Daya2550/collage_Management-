package dayanand;


import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.awt.EventQueue;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileWriter;  
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class allstudent extends JFrame {
	JButton btnNewButton_1;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection connection;
	private Statement statement;
	int totalr=0;
	int markt=0;
	JLabel na ;
	JLabel sub1;
	JLabel sub2;
	JLabel sub3;
	JLabel sub4;
	JLabel sub5;
	JLabel sub6;
	String Namelec1 ="";
	String subject="";
	 int Totallec1=0;
	 int   Presentlec1=0;
	 String total2="";
	 String present2="";
	 JLabel parsent25;
	JLabel s5 ;JLabel s4; JLabel s3 ;JLabel s2 ;JLabel s1 ;JLabel s6;
	JLabel t1 ;JLabel t2 ;JLabel t3 ;JLabel t4 ;JLabel t5 ;JLabel t6 ;
private JTextField roll;
public void connectToDatabase() {
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/nbnscoe", "root", "");
        statement = connection.createStatement();
    } catch (SQLException e) {
}
}

//logic for feche the data database 
 public void fetchData(String roll) {
	      String tableName ="coa";
      try {
          String id = roll;
          String query = "SELECT total, present,name FROM " + tableName + " WHERE id = '" + id + "'";
          ResultSet resultSet = statement.executeQuery(query);

          if (resultSet.next()) {
            Namelec1=resultSet.getString("name");
            Totallec1 = resultSet.getInt("total");
            Presentlec1 = resultSet.getInt("present");
            subject="coa";
            
              // Store fetched data in variables or display as needed
              //JOptionPane.showMessageDialog(this, "data found for Roll no: " + namest);
               
          } else {
             // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
  }



	
	 public void fetchData1(String roll ,String table) {
	      String tableName =table;
	      String Name="";
	      subject=table;
       try {
           String id = roll;
           String query = "SELECT total, present,name FROM " + tableName + " WHERE id = '" + id + "'";
           ResultSet resultSet = statement.executeQuery(query);

           if (resultSet.next()) {
            
            Namelec1=resultSet.getString("name");
            Totallec1 = resultSet.getInt("total");
            Presentlec1 = resultSet.getInt("present");
            
           } else {
              // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       
   }
	 
	 public void fetchData2(String roll ,String table) {
	      String tableName =table;
	      subject=table;
      try {
          String id = roll;
          String query = "SELECT total,present,name FROM " + tableName + " WHERE id = '" + id + "'";
          ResultSet resultSet = statement.executeQuery(query);

          if (resultSet.next()) {
        
          Namelec1=resultSet.getString("name");
          Totallec1 = resultSet.getInt("total");
          Presentlec1 = resultSet.getInt("present");
               
          } else {
             // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
  }
	 
	 public void fetchData3(String roll ,String table) {
	      String tableName =table;
	      subject=table;
      try {
          String id = roll;
          String query = "SELECT total, present,name FROM " + tableName + " WHERE id = '" + id + "'";
          ResultSet resultSet = statement.executeQuery(query);

          if (resultSet.next()) {
        	  Namelec1=resultSet.getString("name");
              Totallec1 = resultSet.getInt("total");
              Presentlec1 = resultSet.getInt("present"); 
               
          } else {
             // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
  }
	 
	 public void fetchData4(String roll ,String table) {
	      String tableName =table;
	      subject=table;
      try {
          String id = roll;
          String query = "SELECT total, present,name FROM " + tableName + " WHERE id = '" + id + "'";
          ResultSet resultSet = statement.executeQuery(query);

          if (resultSet.next()) {
        	  Namelec1=resultSet.getString("name");
              Totallec1 = resultSet.getInt("total");
              Presentlec1 = resultSet.getInt("present");  
               
          } else {
             // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
  }
	 
	 public void fetchData5(String roll ,String table) {
	      String tableName =table;
	      subject=table;
      try {
          String id = roll;
          String query = "SELECT total, present,name FROM " + tableName + " WHERE id = '" + id + "'";
          ResultSet resultSet = statement.executeQuery(query);

          if (resultSet.next()) {
        	  Namelec1=resultSet.getString("name");
              Totallec1 = resultSet.getInt("total");
              Presentlec1 = resultSet.getInt("present");
               
          } else {
             // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
  }
	 
	 public void fetchData6(String roll ,String table) {
	      String tableName =table;
	      subject=table;
      try {
          String id = roll;
          String query = "SELECT total,present,name FROM " + tableName + " WHERE id = '" + id + "'";
          ResultSet resultSet = statement.executeQuery(query);

          if (resultSet.next()) {
        	  Namelec1=resultSet.getString("name");
              Totallec1 = resultSet.getInt("total");
              Presentlec1 = resultSet.getInt("present");
               
          } else {
             // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
  }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allstudent frame = new allstudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public allstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Attendance");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(276, 10, 620, 60);
		contentPane.add(lblNewLabel);
		
		JLabel na = new JLabel("");
		na.setFont(new Font("Tahoma", Font.BOLD, 40));
		na.setBounds(64, 84, 847, 60);
		contentPane.add(na);
		

		JLabel lblNewLabel_2 = new JLabel("Roll no");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(20, 10, 84, 27);
		contentPane.add(lblNewLabel_2);
		
		roll = new JTextField();
		roll.setFont(new Font("Tahoma", Font.BOLD, 20));
		roll.setBounds(100, 10, 125, 27);
		contentPane.add(roll);
		roll.setColumns(10);
		

		JLabel sub1 = new JLabel("");
		sub1.setFont(new Font("Tahoma", Font.BOLD, 30));
		sub1.setBounds(64, 154, 145, 43);
		contentPane.add(sub1);
		
		
		
		
		
		
		
		
		JLabel s1 = new JLabel("");
		s1.setFont(new Font("Tahoma", Font.BOLD, 30));
		s1.setBounds(276, 154, 195, 43);
		contentPane.add(s1);
		
		JLabel t1 = new JLabel("");
		t1.setFont(new Font("Tahoma", Font.BOLD, 30));
		t1.setBounds(625, 154, 195, 43);
		contentPane.add(t1);
		
		JLabel t2 = new JLabel("");
		t2.setFont(new Font("Tahoma", Font.BOLD, 30));
		t2.setBounds(625, 222, 195, 43);
		contentPane.add(t2);
		
		JLabel sub2 = new JLabel("");
		sub2.setFont(new Font("Tahoma", Font.BOLD, 30));
		sub2.setBounds(64, 222, 145, 43);
		contentPane.add(sub2);
		
		JLabel s2 = new JLabel("");
		s2.setFont(new Font("Tahoma", Font.BOLD, 30));
		s2.setBounds(276, 222, 195, 43);
		contentPane.add(s2);
		
		JLabel t3 = new JLabel("");
		t3.setFont(new Font("Tahoma", Font.BOLD, 30));
		t3.setBounds(625, 290, 195, 43);
		contentPane.add(t3);
		
		JLabel sub3 = new JLabel("");
		sub3.setFont(new Font("Tahoma", Font.BOLD, 30));
		sub3.setBounds(64, 290, 145, 43);
		contentPane.add(sub3);
		
		JLabel s3 = new JLabel("");
		s3.setFont(new Font("Tahoma", Font.BOLD, 30));
		s3.setBounds(276, 290, 195, 43);
		contentPane.add(s3);
		
		JLabel t4 = new JLabel("");
		t4.setFont(new Font("Tahoma", Font.BOLD, 30));
		t4.setBounds(625, 366, 195, 43);
		contentPane.add(t4);
		
		JLabel sub4 = new JLabel("");
		sub4.setFont(new Font("Tahoma", Font.BOLD, 30));
		sub4.setBounds(64, 366, 145, 43);
		contentPane.add(sub4);
		
		JLabel s4 = new JLabel("");
		s4.setFont(new Font("Tahoma", Font.BOLD, 30));
		s4.setBounds(276, 366, 195, 43);
		contentPane.add(s4);
		
		JLabel t5 = new JLabel("");
		t5.setFont(new Font("Tahoma", Font.BOLD, 30));
		t5.setBounds(625, 445, 195, 43);
		contentPane.add(t5);
		
		JLabel sub5 = new JLabel("");
		sub5.setFont(new Font("Tahoma", Font.BOLD, 30));
		sub5.setBounds(64, 445, 145, 43);
		contentPane.add(sub5);
		
		JLabel s5 = new JLabel("");
		s5.setFont(new Font("Tahoma", Font.BOLD, 30));
		s5.setBounds(276, 521, 195, 43);
		contentPane.add(s5);
		
		JLabel t6 = new JLabel("");
		t6.setFont(new Font("Tahoma", Font.BOLD, 30));
		t6.setBounds(625, 521, 195, 43);
		contentPane.add(t6);
		
		JLabel sub6 = new JLabel("");
		sub6.setFont(new Font("Tahoma", Font.BOLD, 30));
		sub6.setBounds(63, 521, 145, 43);
		contentPane.add(sub6);
		
		JLabel s6 = new JLabel("");
		s6.setFont(new Font("Tahoma", Font.BOLD, 30));
		s6.setBounds(276, 445, 195, 43);
		contentPane.add(s6);
		
		JLabel subt = new JLabel("");
		subt.setFont(new Font("Tahoma", Font.BOLD, 20));
		subt.setBounds(63, 585, 239, 35);
		contentPane.add(subt);
		
		JLabel totals = new JLabel("");
		totals.setFont(new Font("Tahoma", Font.BOLD, 20));
		totals.setBounds(336, 585, 249, 35);
		contentPane.add(totals);
		
		JLabel percentage = new JLabel("");
		percentage.setFont(new Font("Tahoma", Font.BOLD, 20));
		percentage.setBounds(665, 585, 207, 35);
		contentPane.add(percentage);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student h=new student();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(0, 630, 125, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("feach data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id1=roll.getText();
				int id= Integer.parseInt(roll.getText());
				
			
				
				
				connectToDatabase();
				fetchData1(roll.getText(),"java");
				na.setText("Name : "+Namelec1);
	            sub1.setText(subject);
	            s1.setText(String.valueOf(Presentlec1));
	            t1.setText(String.valueOf(Totallec1)); 
	            totalr+=Totallec1;
	            markt+=Presentlec1;
	            Presentlec1 =0;
	            Totallec1=0;
	            fetchData2(roll.getText(),"coa");
	            sub2.setText(subject);
	            s2.setText(String.valueOf(Presentlec1));
	            t2.setText(String.valueOf(Totallec1)); 
	            totalr+=Totallec1;
	            markt+=Presentlec1;
	            Presentlec1 =0;
	            Totallec1=0;
	            fetchData3(roll.getText(),"toc");
	            sub3.setText(subject);
	            s3.setText(String.valueOf(Presentlec1));
	            t3.setText(String.valueOf(Totallec1));  
	            totalr+=Totallec1;
	            markt+=Presentlec1;
	            Presentlec1 =0;
	            Totallec1=0;
	            fetchData4(roll.getText(),"am2");
	            sub4.setText(subject);
	            s4.setText(String.valueOf(Presentlec1));
	            t4.setText(String.valueOf(Totallec1));  
	            totalr+=Totallec1;
	            markt+=Presentlec1;
	            Presentlec1 =0;
	            Totallec1=0;
	            fetchData5(roll.getText(),"cn");
	            sub5.setText(subject);
	            s5.setText(String.valueOf(Presentlec1));
	            t5.setText(String.valueOf(Totallec1));  
	            totalr+=Totallec1;
	            markt+=Presentlec1;
	            Presentlec1 =0;
	            Totallec1=0;
	            fetchData6(roll.getText(),"mds");
	            sub6.setText(subject);
	            s6.setText(String.valueOf(Presentlec1));
	            t6.setText(String.valueOf(Totallec1));  
	            subt.setText("Total Present :"+String.valueOf(markt));
	            totals.setText("Total lec :"+String.valueOf(totalr));
	            int pr =(markt*100)/totalr;
	            percentage.setText("Parsentage : "+String.valueOf(pr)+"%");
	            
				
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(73, 41, 169, 31);
		contentPane.add(btnNewButton_1);
		
		
		
	}
}
