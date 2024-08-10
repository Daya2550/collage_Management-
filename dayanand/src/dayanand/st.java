package dayanand;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class st extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	 
	 public  void openLink(String url) {
	        if (Desktop.isDesktopSupported()) {
	            Desktop desktop = Desktop.getDesktop();
	            if (desktop.isSupported(Desktop.Action.BROWSE)) {
	                try {
	                    URI uri = new URI(url);
	                    desktop.browse(uri);
	                } catch (IOException | URISyntaxException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                System.err.println("Desktop browsing is not supported.");
	            }
	        } else {
	            System.err.println("Desktop is not supported.");
	        }
	    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					st frame = new st();
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
	public st() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Exam Result ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentresult h=new studentresult();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(266, 447, 164, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Student Section");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 60));
		lblNewLabel_1.setBounds(276, 139, 447, 101);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Notes");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLink("https://whitespace1.great-site.net/");
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1_1_1.setBounds(512, 447, 164, 31);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Notice");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentnotice h=new studentnotice();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1_1.setBounds(743, 447, 164, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Attendance");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student h=new student();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_2.setBackground(new Color(255, 128, 0));
		btnNewButton_1_2.setBounds(44, 447, 164, 31);
		contentPane.add(btnNewButton_1_2);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login h=new Login();
        		h.setVisible(true);
        		dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setBackground(new Color(0, 128, 255));
		back.setBounds(10, 10, 124, 21);
		contentPane.add(back);
		
		JLabel lblNewLabel_1_1 = new JLabel("College Management System ");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 70));
		lblNewLabel_1_1.setBounds(51, 62, 888, 67);
		contentPane.add(lblNewLabel_1_1);
	}
}
