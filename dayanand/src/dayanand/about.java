package dayanand;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class about extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about frame = new about();
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
	public about() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("College Management System ");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 70));
		lblNewLabel_1.setBounds(103, 10, 970, 67);
		contentPane.add(lblNewLabel_1);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index h=new Index();
        		h.setVisible(true);
        		dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setBackground(new Color(0, 128, 255));
		back.setBounds(10, 546, 85, 33);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel(" College Management System ");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblNewLabel.setBounds(90, 121, 949, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblExamsManagementSystem = new JLabel(" Exams  Management System ");
		lblExamsManagementSystem.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblExamsManagementSystem.setBounds(90, 201, 949, 50);
		contentPane.add(lblExamsManagementSystem);
		
		JLabel lblAttendanceManagementSystem = new JLabel(" Attendance Management System ");
		lblAttendanceManagementSystem.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblAttendanceManagementSystem.setBounds(90, 285, 949, 50);
		contentPane.add(lblAttendanceManagementSystem);
		
		JLabel lblNewLabel_2_1 = new JLabel("Automation of create DataBase ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblNewLabel_2_1.setBounds(90, 370, 949, 50);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Notice writings ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblNewLabel_3_1.setBounds(90, 454, 949, 50);
		contentPane.add(lblNewLabel_3_1);
	}

}
