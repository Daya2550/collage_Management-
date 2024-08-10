package dayanand;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private Connection conn;
	 private Statement stmt;
	 private JTextField na;
	 private JTextField ph;
	 private JTextField em;
	 private JTextField pa;
	 private JTextField lpa;
	 private JTextField lid;
	 public String pass ="";
	 public int uid =0;
	 private JTextField adl;
	 JPanel panel_1;
	 JPanel panel_2;
	 JPanel panel;
	 private JTextField textField;
	/**
	 * Launch the application.
	 */
	 
	 
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

	    // Function to add data to the table
	    public void addData(String name, String phone, String email, String password) {
	        try {
	            String sql = "INSERT INTO users (name, phone, email, password) " +
	                         "VALUES ('" + name + "', '" + phone + "', '" + email + "', '" + password + "')";
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Function to update data in the table
	    public void updateData(int id, String name, String phone, String email, String password) {
	        try {
	            String sql = "UPDATE users SET name = '" + name + "', phone = '" + phone + "', " +
	                         "email = '" + email + "', password = '" + password + "' WHERE id = " + id;
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Function to fetch data from the table by id
	    public String fetchDataById(int id) {
	    	 String  passward ="";
	        try {
	            String sql = "SELECT * FROM users WHERE id = " + id;
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	              //  System.out.println("ID: " + rs.getInt("id"));
	               // System.out.println("Name: " + rs.getString("name"));
	               // System.out.println("Phone: " + rs.getString("phone"));
	              //  System.out.println("Email: " + rs.getString("email"));
	               // System.out.println("Password: " + rs.getString("password"));
	                
	              passward =rs.getString("password");
	           	  uid =rs.getInt("id");
	                
	                
	            } else {
	                System.out.println("No user found with ID: " + id);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return passward ;
	    }


	    // Function to fetch data from the table by id
	    public String fetchDataByemail(String email) {
	    	 String  passward ="";
	        try {
	            String sql = "SELECT * FROM users WHERE phone = " + email;
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	              //  System.out.println("ID: " + rs.getInt("id"));
	               // System.out.println("Name: " + rs.getString("name"));
	               // System.out.println("Phone: " + rs.getString("phone"));
	              //  System.out.println("Email: " + rs.getString("email"));
	               // System.out.println("Password: " + rs.getString("password"));
	                
	              passward =rs.getString("id");
	           	 
	                
	                
	            } else {
	                System.out.println("No user found with ID: " + email);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return passward ;
	    }
 
	    
	    
	    
	    // Function to delete data from the table by id
	    public void deleteDataById(int id) {
	        try {
	            String sql = "DELETE FROM users WHERE id = " + id;
	            int rowsAffected = stmt.executeUpdate(sql);
	            if (rowsAffected > 0) {
	                System.out.println("User with ID " + id + " deleted successfully.");
	            } else {
	                System.out.println("No user found with ID: " + id);
	            }
	        } catch (SQLException e) {
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
	 
	 
	 
	    public static boolean isValidPhoneNumber(String phoneNumber) {
	        // Regular expression for a simple phone number format: xxx-xxx-xxxx
	        String regex = "\\d{10}";
	        return phoneNumber.matches(regex);
	    }	 
	 
	 
	 
	 
	 
	 
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JComboBox co = new JComboBox();
		co.setBackground(new Color(136, 196, 255));
		co.setFont(new Font("Tahoma", Font.BOLD, 25));
		co.setModel(new DefaultComboBoxModel(new String[] {"student", "Teacher"}));
		co.setBounds(29, 49, 135, 33);
		contentPane.add(co);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(217, 255, 255));
		panel.setBounds(29, 122, 474, 364);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name :");
		lblNewLabel_1_1.setBounds(10, 29, 98, 27);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1_1);
		
		na = new JTextField();
		na.setBounds(118, 33, 344, 27);
		na.setFont(new Font("Tahoma", Font.BOLD, 20));
		na.setColumns(10);
		panel.add(na);
		
		JLabel lblNewLabel_1_2 = new JLabel("phone No :");
		lblNewLabel_1_2.setBounds(10, 83, 113, 27);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1_2);
		
		ph = new JTextField();
		ph.setBounds(118, 87, 344, 27);
		ph.setFont(new Font("Tahoma", Font.BOLD, 20));
		ph.setColumns(10);
		panel.add(ph);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setBounds(10, 151, 98, 27);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1_3);
		
		em = new JTextField();
		em.setBounds(120, 155, 344, 27);
		em.setFont(new Font("Tahoma", Font.BOLD, 20));
		em.setColumns(10);
		panel.add(em);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password ");
		lblNewLabel_1_4.setBounds(10, 222, 113, 27);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1_4);
		
		pa = new JTextField();
		pa.setBounds(118, 226, 344, 27);
		pa.setFont(new Font("Tahoma", Font.BOLD, 20));
		pa.setColumns(10);
		panel.add(pa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(215, 255, 215));
		panel_1.setBounds(513, 122, 430, 364);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("sign In");
		lblNewLabel_2.setBounds(152, 32, 181, 43);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		panel_1.add(lblNewLabel_2);
		
		lpa = new JTextField();
		lpa.setBounds(110, 208, 310, 27);
		lpa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lpa.setColumns(10);
		panel_1.add(lpa);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Password ");
		lblNewLabel_1_4_1.setBounds(10, 208, 113, 27);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Id :");
		lblNewLabel_1_5.setBounds(36, 134, 98, 27);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_5);
		
		lid = new JTextField();
		lid.setBounds(110, 134, 310, 27);
		lid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lid.setColumns(10);
		panel_1.add(lid);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBounds(156, 255, 205, 33);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ch=((String)co.getSelectedItem());
				if (ch.equals("student")){
					studant();
				int inputid =Integer.parseInt(lid.getText());

				String pass1 = lpa.getText();
					 String pass2 =fetchDataById(inputid);
					if (pass1.equals(pass2)) {
						JOptionPane.showMessageDialog(Login.this, "Login Suseefully ! ");
						st h=new st();
		        		h.setVisible(true);
		        		dispose();	
		        		close();
					}
					
					else {
						JOptionPane.showMessageDialog(Login.this, "InValid user ! ");
					}
				}
				
				
				else if (ch.equals("Teacher")) {
					teacher();
					int inputid =Integer.parseInt(lid.getText());

					String pass1 = lpa.getText();
						 String pass2 =fetchDataById(inputid);
						if (pass1.equals(pass2)) {
							JOptionPane.showMessageDialog(Login.this, "Login Suseefully ! ");
							student h=new student();
							Home hh=new Home();
			        		hh.setVisible(true);
			        		dispose();
						}
						
						else {
							JOptionPane.showMessageDialog(Login.this, "InValid user ! ");
						}
				}
				
				
				
				else {
					JOptionPane.showMessageDialog(Login.this, "error !");
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBackground(new Color(0, 255, 64));
		panel_1.add(btnLogin);
		
		JButton btnNewButton_1_1 = new JButton("Sign up");
		btnNewButton_1_1.setBounds(212, 298, 98, 21);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("sign in and sige up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(195, 20, 595, 73);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 238));
		panel_2.setBounds(10, 496, 493, 137);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 10, 214, 40);
		panel_2.add(lblNewLabel_1);
		
		adl = new JTextField();
		adl.setFont(new Font("Tahoma", Font.BOLD, 20));
		adl.setColumns(10);
		adl.setBounds(143, 51, 304, 27);
		panel_2.add(adl);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Password ");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_4_1_1.setBounds(20, 51, 113, 27);
		panel_2.add(lblNewLabel_1_4_1_1);
		
		JButton btnLogin_1 = new JButton("login");
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passadmin =adl.getText();
				if (passadmin.equals("dayanand")) {
					admin ad=new admin();
	        		ad.setVisible(true);
	        		dispose();
					
				}
				else {
					
					JOptionPane.showMessageDialog(Login.this, "YOU ARE NO ADMIN !");
					
				}
			}
		});
		btnLogin_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin_1.setBackground(new Color(0, 255, 64));
		btnLogin_1.setBounds(247, 88, 102, 33);
		panel_2.add(btnLogin_1);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
				btnNewButton.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(32, 517, 245, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign in");
		btnNewButton_1.setBounds(200, 324, 98, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnNewButton_1);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ch=((String)co.getSelectedItem());
				if (ch.equals("student")){
					studant();
					addData(na.getText(),ph.getText(), em.getText(), pa.getText()) ;
					JOptionPane.showMessageDialog(Login.this, "Sign up submited ! ");
					panel_1.setVisible(true);
					panel.setVisible(false);
					
				}
				else if (ch.equals("Teacher")) {
					teacher();
					addData(na.getText(),ph.getText(), em.getText(), pa.getText()) ;
					JOptionPane.showMessageDialog(Login.this, "Sign up submited ! ");
					panel_1.setVisible(true);
					panel.setVisible(false);
				}
			}
		});
		btnSubmit_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit_1.setBackground(new Color(0, 128, 255));
		btnSubmit_1.setBounds(153, 281, 205, 33);
		panel.add(btnSubmit_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(512, 496, 431, 137);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Get id :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 73, 19);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone No :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 59, 116, 25);
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(137, 59, 284, 25);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(116, 0, 138, 35);
		panel_3.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("submit");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studant();
				String dataemail =fetchDataByemail(textField.getText());
				lblNewLabel_5.setText(dataemail);
				
				
				
			}
		});
		btnNewButton_2.setBounds(224, 92, 125, 21);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ID");
		btnNewButton_3.setBackground(new Color(128, 128, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(904, 0, 49, 11);
		contentPane.add(btnNewButton_3);
		
		
		
		panel_2.setVisible(false);
		panel_1.setVisible(true);
		panel.setVisible(false);
		panel_3.setVisible(false);
		
	}
}
