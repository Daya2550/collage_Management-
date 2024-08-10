package dayanand;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
public class notices extends JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3307/";
    private static final String DB_NAME = "notice";
    private static final String USER = "root";
    private static final String PASS = "";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	
	
	
	
	
	// Function to create the database if it does not exist
    public  void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully.");
        } catch (SQLException e) {
        	 JOptionPane.showMessageDialog(this, "createdDatabase");
        }
    }

    // Function to create the table if it does not exist
    public  void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS data(id INT AUTO_INCREMENT PRIMARY KEY, message VARCHAR(255))";
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }

    
    
    // Function to add data to the database
    public void addData(int id, String message) {
        String sql = "INSERT INTO data (id, message) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, message);
            pstmt.executeUpdate();
            System.out.println("Data added successfully.");
        } catch (SQLException e) {
        	 JOptionPane.showMessageDialog(this, "Notice allread writed");
        }
    }

    // Function to fetch data from the database
    public String fetchData(int id) {
    	String data="";
        String sql = "SELECT * FROM data WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	data=data+rs.getString("message");
            	
               // System.out.println("ID: " + rs.getInt("id") + ", Message: " + rs.getString("message"));
            }
        } catch (SQLException e) {
        	 JOptionPane.showMessageDialog(this, "Notice not found");
        }
        return data;
    }

    // Function to update data in the database
    public  void updateData(int id, String newMessage) {
        String sql = "UPDATE data SET message=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newMessage);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Data updated successfully.");
        } catch (SQLException e) {
        	 JOptionPane.showMessageDialog(this, "error");
        }
    }

    // Function to delete data from the database
    public  void deleteData(int id) {
        String sql = "DELETE FROM data WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Data deleted successfully.");
        } catch (SQLException e) {
        	 JOptionPane.showMessageDialog(this, "Data deleted not successfully.");
        }
    }

    // Function to delete the entire database
    public  void deleteDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "DROP DATABASE IF EXISTS " + DB_NAME;
            stmt.executeUpdate(sql);
            System.out.println("Database deleted successfully.");
        } catch (SQLException e) {
        	 JOptionPane.showMessageDialog(this, "Database deleted not successfully.");
        }
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notices frame = new notices();
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
	public notices() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("No :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(132, 273, 95, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(238, 268, 74, 33);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Notice :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(132, 338, 95, 23);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(237, 329, 818, 42);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("feach");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(textField.getText());
				String d =fetchData(a);
				textField_1.setText(d);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(0, 189, 0));
		btnNewButton_1.setBounds(402, 425, 167, 33);
		contentPane.add(btnNewButton_1);
		
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(textField.getText());
				String b= textField_1.getText();
				 updateData(a, b);
				 JOptionPane.showMessageDialog(notices.this, "update data");
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 20));
		update.setBackground(new Color(0, 189, 0));
		update.setBounds(656, 425, 162, 33);
		contentPane.add(update);
		
		JButton btnClearAh = new JButton("clear");
		btnClearAh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(textField.getText());
				String b= textField_1.getText();
				 deleteData(a);
				 textField_1.setText("");
			     textField.setText("");
			     JOptionPane.showMessageDialog(notices.this, "deleted data ");
			}
		});
		btnClearAh.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClearAh.setBackground(new Color(255, 128, 0));
		btnClearAh.setBounds(888, 425, 167, 33);
		contentPane.add(btnClearAh);
		
		JButton add = new JButton("add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int a=Integer.parseInt(textField.getText());
			String b= textField_1.getText();
				addData(a, b);
				JOptionPane.showMessageDialog(notices.this, "added data ");
			}
		});
		add.setFont(new Font("Tahoma", Font.BOLD, 20));
		add.setBackground(new Color(0, 128, 255));
		add.setBounds(135, 425, 167, 33);
		contentPane.add(add);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h=new Home();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(0, 128, 255));
		btnBack.setBounds(10, 20, 167, 33);
		contentPane.add(btnBack);
		
		JButton btnNewButton_1_1 = new JButton("Database");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createDatabase();
		        createTable();
		        JOptionPane.showMessageDialog(notices.this, "Create Database ");
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(0, 189, 0));
		btnNewButton_1_1.setBounds(145, 84, 167, 33);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDatabase();
				JOptionPane.showMessageDialog(notices.this, "Delete Database ");
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBackground(new Color(255, 128, 0));
		btnDelete.setBounds(402, 84, 167, 33);
		contentPane.add(btnDelete);
	}
}
