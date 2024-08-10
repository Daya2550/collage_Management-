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

public class admin extends JFrame {
	 private Connection connection;
	 private Statement statement;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField roll;
	private JTextField na;
	private JTextField T;
	private JTextField P;
	private JButton btnNewButton;
	public String subject ="";
	JComboBox comboBox;
	
	 private Connection conn;
	 private Statement stmt;
	/**
	 * Launch the application.
	 */
	
	 public void connectToDatabase() {
	        try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/nbnscoe", "root", "");
	            statement = connection.createStatement();
	            JOptionPane.showMessageDialog(this, "cannected ....... " );
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(this, " Not cannected ....... " );
	   }
	 }

    
 //logic for feche the data database 
   public void fetchData1() {
	   String tableName = subject;
        try {
            String id = roll.getText();
            String query = "SELECT total, present,name FROM " + tableName + "  WHERE id = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
            	String namest=resultSet.getString("name");
              int to = resultSet.getInt("total");
                int  pr = resultSet.getInt("present");
                
                T.setText(String.valueOf(to));
                P.setText(String.valueOf(pr));
                na.setText(namest);
                
                // Store fetched data in variables or display as needed
               // JOptionPane.showMessageDialog(this, "data found for Roll no: " + namest);
                 
            } else {
               JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
    
   
   
   // update data in data base
    public void updateData() {
    	String tableName = subject;
        try {
            String id =  roll.getText();
            String total = T.getText();
            String present = P.getText();
            String name= na.getText();

            String query = "UPDATE " + tableName + "  SET total = '" + total + "', present = '" + present + "' WHERE id = '" + id + "'";
            int rowsAffected = statement.executeUpdate(query);
            
            if (rowsAffected > 0) {
               JOptionPane.showMessageDialog(this, "Data updated successfully");
            } else {
               JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
    
   // add data in data base
    private void addData() {
    	String tableName = subject;
    	try {
     	String name= na.getText();
  	    String id =roll.getText();
        String total =T.getText();
        String present =P.getText();
            String query = "INSERT INTO " + tableName + "  ( id, name ,total, present) VALUES ('" + id + "', '" + name + "', '" + total + "', '" + present + "')";
           statement.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Data added successfully");  
        
    	  }
    	catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Samting error");  
      }
    	
    	
   }	
	
    public void studant() {
        try {
            // Connect to your database
            String url = "jdbc:mysql://localhost:3307/";
            String dbName = "loginst";
            String driver = "com.mysql.cj.jdbc.Driver";
            String userName = "root";
            String password = "";

            // Register JDBC driver
            Class.forName(driver);

            // Open a connection
            conn = DriverManager.getConnection(url + dbName, userName, password);

            // Create a statement object to perform queries
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  public void teacher() {
        try {
            // Connect to your database
            String url = "jdbc:mysql://localhost:3307/";
            String dbName = "logintr";
            String driver = "com.mysql.cj.jdbc.Driver";
            String userName = "root";
            String password = "";

            // Register JDBC driver
            Class.forName(driver);

            // Open a connection
            conn = DriverManager.getConnection(url + dbName, userName, password);

            // Create a statement object to perform queries
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
  // Close resources
  public void close() {
      try {
          if (stmt != null)
              stmt.close();
          if (conn != null)
              conn.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  } 

  public void createTable() {
      try {
          String sql = "CREATE TABLE IF NOT EXISTS users (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY," +
                       "name VARCHAR(255)," +
                       "phone VARCHAR(20)," +
                       "email VARCHAR(255)," +
                       "password VARCHAR(255))";
          stmt.executeUpdate(sql);
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
  
  
  public  void createDatabase1() {
      String url = "jdbc:mysql://localhost:3307/";
      String username = "root";
      String password = "";
      String dbName = "nbnscoe";
      String tableName =subject;
     
      try {
          Connection connection = DriverManager.getConnection(url, username, password);
          Statement statement = connection.createStatement();
          String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS  loginst";
          statement.executeUpdate(createDatabaseQuery);
          createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS  logintr";
          statement.executeUpdate(createDatabaseQuery);
         // statement.close();
       //   connection.close();
	       	JOptionPane.showMessageDialog(this, "DataBase added successfully");  

      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  public  void deleteDatabase1() {
		
 	 
		 String url = "jdbc:mysql://localhost:3307/";
	        String username = "root";
	        String password = "";
	        String dbName = "nbnscoe";
	        String tableName = subject;
		 
		 try {
	            // Establish connection to MySQL server
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Create a Statement object
	            Statement statement = conn.createStatement();

	            // SQL query to drop the database
	            String sql = "DROP DATABASE logintr";

	            // Execute the query to drop the database
	            statement.executeUpdate(sql);
	            
	            
	            // SQL query to drop the database
	            sql = "DROP DATABASE loginst" ;

	            // Execute the query to drop the database
	            statement.executeUpdate(sql);
	            
	            
	            
	            
	            System.out.println("Database '" + dbName + "' deleted successfully.");

	            // Close connections
	            statement.close();
	            conn.close();
	        	JOptionPane.showMessageDialog(this, "DataBase Deleted successfully"); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
  

  //All name of class 
  public static String data(int index) {
      String[] name = new String[100];
      name[0] = "";
      name[1] = "Saurabh aglave";
      name[2] = "Devashree agnihotri";
      name[3] = "Rohit bandgar";
      name[4] = "Aditya boddu";
      name[5] = "Atharva chaudhari";
      name[6] = "Samarth chavan";
      name[7] = "Paras dhajal";
      name[8] = "Shruti dhumal";
      name[9] = "Shreedhar doijode";
      name[10] = "anushka dussa";
      name[11] = "Vaishnavi emekar";
      name[12] = "Ritej gaikwad";
      name[13] = "Onkar gawade";
      name[14] = "Shubham ghadage";
      name[15] = "Ambadas gote";
      name[16] = "Nurandayya hiremath";
      name[17] = "Sagar hulle";
      name[18] = "Akshay ingale";
      name[19] = "Prakash jadhav";
      name[20] = "Dayanand jagdale";
      name[21] = "Devidas kakade";
      name[22] = "Aditya kamble";
      name[23] = "Pratik kamble";
      name[24] = "Sakshi kamble";
      name[25] = "Vaishnavi kamble";
      name[26] = "Samarth kanagi";
      name[27] = "Sapana kandalgaonkar";
      name[28] = "Samir karache";
      name[29] = "Kirtan karwa";
      name[30] = "Bhargav katkam";
      name[31] = "Swapnil kengar";
      name[32] = "Neha kore";
      name[33] = "Ashvini lad";
      name[34] = "Dharmavir londhe";
      name[35] = "Sonal mahamuni";
      name[36] = "Ananya menchekaa";
      name[37] = "Uday more";
      name[38] = "Vishal mote";
      name[39] = "Raj naik";
      name[40] = "Anuja narsale";
      name[41] = "Rutuja nilange";
      name[42] = "Viresh paramahetti";
      name[43] = "Vaishnavi patil";
      name[44] = "Vinayak patil";
      name[45] = "Shivani pethe";
      name[46] = "Dhanashri pujari";
      name[47] = "Sakshi raje";
      name[48] = "Mahavir rupnavar";
      name[49] = "Onkar salunke";
      name[50] = "Anjali salunke";
      name[51] = "Sunil sangolkar";
      name[52] = "Faizan shaikh";
      name[53] = "Mohasin shaikh";
      name[54] = "Rohit shalgar";
      name[55] = "Teja shevale";
      name[56] = "Sujay shewale";
      name[57] = "Aparna shinde";
      name[58] = "Srushti shinde";
      name[59] = "Ismail shirgapure";
      name[60] = "Sushil shivasharan";
      name[61] = "Shrinivas solapure";
      name[62] = "Dnyaneshwar suryawanshi";
      name[63] = "Tamanna tamboli";
      name[64] = "Vaishnavi tapase";
      name[65] = "Athrav vijapure";
      name[66] = "Ajay waghmare";
      name[67] = "Yash waghmare";
      name[68] = "Khandu waghmode";
      name[69] = "Kartik yemul";
      name[70] = "Asawari jambhale";
      name[71] = "Pooja rathod";
      name[72] = "Vaibhavi belamkar";
      name[73] = "Laya kokkul";
      name[74] = "Manasi swadde";
      name[75] = "Sanket honkar";
      name[76] = "Rohan tatipamul";
      name[77] = "Harshada bhore";
      name[78] = "Vaishnavi yeladi";
      return name[index];
  }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public  void createDatabaseAndTable() {
        String url = "jdbc:mysql://localhost:3307/";
        String username = "root";
        String password = "";
        String dbName = "nbnscoe";
        String tableName =subject;
       
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.executeUpdate(createDatabaseQuery);
            statement.execute("USE " + dbName);
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                                      "id INT PRIMARY KEY," +
                                      "name VARCHAR(255) DEFAULT NULL," +
                                      "total INT DEFAULT 0," +
                                      "present INT DEFAULT 0)";
            statement.executeUpdate(createTableQuery);
            System.out.println("Database 'newdata' and table 'data' created successfully.");
            statement.close();
            connection.close();
	       	JOptionPane.showMessageDialog(this, "DataBase added successfully");  

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	
	 public  void deleteDatabase() {
		
    	 
		 String url = "jdbc:mysql://localhost:3307/";
	        String username = "root";
	        String password = "";
	        String dbName = "nbnscoe";
	        String tableName = subject;
		 
		 try {
	            // Establish connection to MySQL server
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Create a Statement object
	            Statement statement = conn.createStatement();

	            // SQL query to drop the database
	            String sql = "DROP DATABASE " + dbName;

	            // Execute the query to drop the database
	            statement.executeUpdate(sql);

	            System.out.println("Database '" + dbName + "' deleted successfully.");

	            // Close connections
	            statement.close();
	            conn.close();
	        	JOptionPane.showMessageDialog(this, "DataBase Deleted successfully"); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 // add data in data base
	    private void namedata() {
	    	 String tableName =subject;
	        
	    	try {
	             connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/nbnscoe", "root", "");
	             statement = connection.createStatement();
	         } catch (SQLException e) {
	    }
	    	try {
	          Allclass a=new Allclass();
	       	  a.connectToDatabase();
	       	for (int i=1;i<79;i++) {
	       	String name= data(i);
	  	    String id =""+i;
	        String total =""+0;
	        String present =""+0;
	            String query = "INSERT INTO " + tableName + " ( id, name ,total, present) VALUES ('" + id + "', '" + name + "', '" + total + "', '" + present + "')";
	            statement.executeUpdate(query);
	            
	        }
	       	JOptionPane.showMessageDialog(this, "Data Add successfully");  
	    	  }
	    	catch (SQLException e) {
	           
	        }
	    }
	   
	    // update data in data base
	     public void reset() {
	    	 String tableName =subject;
	    	
	         try {
	        	 for (int i=1;i<79;i++) {
	             String id =String.valueOf(i);
	             String total ="0";
	             String present = "0";
	             String query = "UPDATE  " + tableName + " SET total = '" + total + "', present = '" + present + "' WHERE id = '" + id + "'";
	             int rowsAffected = statement.executeUpdate(query);
	        	 }
	        	 JOptionPane.showMessageDialog(this, "Data Reset successfully");
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	        
	     }
	    
	     public  void deleteTable(String tableName) {
	    	 
	    	
	         try {
	             Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3307/nbnscoe", "root", "");
	             Statement statement = connection.createStatement();
	             String sqlQuery = "DROP TABLE IF EXISTS " + tableName;
	             statement.executeUpdate(sqlQuery);    
	             System.out.println("Table " + tableName + " deleted successfully.");
	             statement.close();
	             connection.close();
	             JOptionPane.showMessageDialog(this, "Data Delete successfully");
	         } catch (SQLException e) {
	             System.err.println("Error deleting table: " + e.getMessage());
	         }
	     }
	/**
	 * Create the frame.
	 */
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 682);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 249, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		roll = new JTextField();
		roll.setFont(new Font("Tahoma", Font.BOLD, 20));
		roll.setBounds(174, 410, 74, 33);
		contentPane.add(roll);
		roll.setColumns(10);
		
		na = new JTextField();
		na.setFont(new Font("Tahoma", Font.BOLD, 20));
		na.setBounds(174, 457, 424, 42);
		contentPane.add(na);
		na.setColumns(10);
		
		T = new JTextField();
		T.setBackground(new Color(189, 255, 206));
		T.setFont(new Font("Tahoma", Font.BOLD, 20));
		T.setBounds(174, 515, 129, 33);
		contentPane.add(T);
		T.setColumns(10);
		
		P = new JTextField();
		P.setBackground(new Color(187, 187, 255));
		P.setFont(new Font("Tahoma", Font.BOLD, 20));
		P.setBounds(572, 515, 130, 33);
		contentPane.add(P);
		P.setColumns(10);
		
		JButton add = new JButton("add");
		add.setBackground(new Color(0, 128, 255));
		add.setFont(new Font("Tahoma", Font.BOLD, 20));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				addData();
			}
			
		});
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 255, 128));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"java", "coa", "cn", "toc", "am2", "mds"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox.setBounds(206, 10, 85, 31);
		contentPane.add(comboBox);
		
		
		add.setBounds(799, 570, 167, 33);
		contentPane.add(add);
		
		JButton btnNewButton_1 = new JButton("feach");
		btnNewButton_1.setBackground(new Color(0, 189, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				fetchData1();
			}
		});
		btnNewButton_1.setBounds(169, 570, 167, 33);
		contentPane.add(btnNewButton_1);
		
		JButton update = new JButton("update");
		update.setBackground(new Color(0, 189, 0));
		update.setFont(new Font("Tahoma", Font.BOLD, 20));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				updateData();
			}
			
		});
		update.setBounds(521, 570, 162, 33);
		contentPane.add(update);
		
		btnNewButton = new JButton("Connect");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				connectToDatabase();
			}
		});
		btnNewButton.setBounds(142, 108, 122, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Admin Section");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 60));
		lblNewLabel.setBounds(301, 10, 440, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Roll NO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(37, 415, 95, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(45, 466, 95, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(45, 520, 95, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Present :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(410, 520, 95, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Database :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(23, 107, 109, 31);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnNewButton_2 = new JButton("Create DataBase");
		btnNewButton_2.setBackground(new Color(0, 255, 64));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				createDatabaseAndTable();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(10, 170, 202, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Delete DataBase");
		btnNewButton_2_1.setBackground(new Color(255, 0, 0));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				deleteDatabase();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(806, 170, 202, 31);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Reset DataBase");
		btnNewButton_1_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				reset();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(467, 170, 202, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Add DATA");
		btnNewButton_1_1_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				namedata();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1_1.setBounds(233, 170, 202, 31);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnClearAh = new JButton("clear");
		btnClearAh.setBackground(new Color(255, 128, 0));
		btnClearAh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roll.setText("");
				na.setText("");
				T.setText("");
				P.setText("");
			}
		});
		btnClearAh.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClearAh.setBounds(799, 515, 167, 33);
		contentPane.add(btnClearAh);
		
		JButton back = new JButton("back");
		back.setBackground(new Color(0, 128, 255));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login h=new Login();
        		h.setVisible(true);
        		dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setBounds(10, 10, 85, 33);
		contentPane.add(back);
		
		JButton dele = new JButton("Delete");
		dele.setBackground(new Color(255, 0, 0));
		dele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject=((String)comboBox.getSelectedItem());
				deleteTable(subject);
			}
		});
		dele.setFont(new Font("Tahoma", Font.BOLD, 20));
		dele.setBounds(690, 170, 99, 31);
		contentPane.add(dele);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Subject :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(107, 12, 99, 27);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(168, 211, 255));
		panel.setBounds(0, 79, 1022, 165);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(226, 198, 255));
		panel_1.setBounds(10, 254, 1012, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Login ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(22, 10, 131, 26);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_2_2 = new JButton("Create DataBase");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createDatabase1();
				studant();
				createTable() ;
				close();
				createDatabase1();
				teacher();
				createTable() ;
				close();
			}
		});
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_2.setBackground(new Color(0, 255, 64));
		btnNewButton_2_2.setBounds(295, 77, 202, 31);
		panel_1.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_1_1 = new JButton("Delete DataBase");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDatabase1();
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1_1.setBackground(Color.RED);
		btnNewButton_2_1_1.setBounds(642, 77, 202, 31);
		panel_1.add(btnNewButton_2_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(174, 255, 174));
		panel_2.setBounds(10, 399, 998, 234);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(47, 207, 1022, 648);
		contentPane.add(lblNewLabel_4);
		
		JButton back_1 = new JButton("st");
		back_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st h=new st();
        		h.setVisible(true);
        		dispose();
			}
		});
		back_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		back_1.setBackground(new Color(0, 128, 255));
		back_1.setBounds(829, 23, 63, 33);
		contentPane.add(back_1);
		
		JButton back_2 = new JButton("Tr");
		back_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h=new Home();
        		h.setVisible(true);
        		dispose();
			}
		});
		back_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		back_2.setBackground(new Color(0, 128, 255));
		back_2.setBounds(915, 23, 63, 33);
		contentPane.add(back_2);
	}
}
