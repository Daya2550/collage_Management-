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

public class studentresult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputst;
	private Connection connection;
	private Statement statement;
	JLabel presentst ;
	String Namelec1 ="";
	 int Totallec1=0;
	 int   Presentlec1=0;
	 String total2="";
	 String present2="";
	 JLabel parsent25;
	 JLabel instruction;
	 JLabel percentage1 ;
	 public String subject ="";
	// String tableName =subject;
	// subject=((String)comboBox.getSelectedItem());
	/**
	 * Launch the application.
	 */
	 public void connectToDatabase() {
	        try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/exam", "root", "");
	            statement = connection.createStatement();
	        } catch (SQLException e) {
	   }
	    }
	    
	
//logic for feche the data database 
   public void fetchData(String roll) {
	      String tableName =subject;
        try {
            String id = roll;
            String query = "SELECT total, marks,name FROM " + tableName + " WHERE id = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
              Namelec1=resultSet.getString("name");
              Totallec1 = resultSet.getInt("total");
              Presentlec1 = resultSet.getInt("marks");
               
                //JOptionPane.showMessageDialog(this, "data found for Roll no: " + namest);
                 
            } else {
               // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
	
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentresult frame = new studentresult();
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
	public studentresult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Section -Result");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 60));
		lblNewLabel.setBounds(262, 10, 635, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Roll No :");
		lblNewLabel_1.setForeground(new Color(64, 0, 128));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(303, 193, 216, 48);
		contentPane.add(lblNewLabel_1);
		
		inputst = new JTextField();
		inputst.setFont(new Font("Yu Gothic", Font.BOLD, 30));
		inputst.setBounds(541, 193, 226, 48);
		contentPane.add(inputst);
		inputst.setColumns(10);
		
		JLabel well = new JLabel("");
		well.setForeground(new Color(0, 128, 255));
		well.setFont(new Font("Trebuchet MS", Font.BOLD, 80));
		well.setBounds(330, 108, 418, 160);
		contentPane.add(well);
		
		JLabel namest = new JLabel("");
		namest.setForeground(new Color(128, 0, 255));
		namest.setFont(new Font("Imprint MT Shadow", Font.BOLD, 50));
		namest.setBounds(341, 294, 657, 91);
		contentPane.add(namest);
		
		JLabel totalst = new JLabel("");
		totalst.setForeground(new Color(0, 255, 0));
		totalst.setFont(new Font("Tahoma", Font.BOLD, 25));
		totalst.setBounds(72, 457, 447, 60);
		contentPane.add(totalst);
		
		JLabel presentst = new JLabel("");
		presentst.setForeground(new Color(255, 0, 0));
		presentst.setFont(new Font("Tahoma", Font.BOLD, 25));
		presentst.setBounds(625, 457, 417, 60);
		contentPane.add(presentst);
		
		JButton back = new JButton("Back");
		back.setBackground(new Color(0, 128, 255));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st h=new st();
        		h.setVisible(true);
        		dispose();
			}
		});
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(64, 0, 128));
		comboBox.setBackground(new Color(6, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"java", "coa", "cn", "toc", "am2", "mds"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox.setBounds(126, 32, 85, 31);
		contentPane.add(comboBox);
		
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setBounds(50, 606, 124, 21);
		contentPane.add(back);
		
		JLabel percentage1 = new JLabel("");
		percentage1.setForeground(new Color(115, 185, 255));
		percentage1.setFont(new Font("Tahoma", Font.BOLD, 40));
		percentage1.setBounds(247, 514, 594, 60);
		contentPane.add(percentage1);
		
		JButton btnNewButton = new JButton("Submit ");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				
				connectToDatabase();
					String input=inputst.getText();
					inputst.setVisible(false);
					lblNewLabel_1.setVisible(false);
					btnNewButton.setVisible(false);
					
					well.setText("welcome!");
					fetchData(input);
					 total2=""+Totallec1;
					 present2=""+Presentlec1;
					namest.setText(Namelec1);
				   totalst.setText("Total marks :"+total2);
				   presentst.setText("Youer are marks  :"+present2);
				 
				  int par=(Presentlec1*100)/Totallec1;
				  
				  percentage1.setText("Percentage = "+String.valueOf(par)+"%");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(551, 251, 216, 33);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Subject :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(27, 34, 99, 27);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("All Subjects ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allresult h=new allresult();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(37, 68, 174, 31);
		contentPane.add(btnNewButton_2);
	}
}
