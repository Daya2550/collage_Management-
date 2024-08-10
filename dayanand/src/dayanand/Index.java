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

public class Index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1166, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("N. B. Navale Sinhgad College");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblNewLabel_1_1.setBounds(239, 10, 770, 67);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Of Engineering,Solapur ");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblNewLabel_1_1_1.setBounds(300, 93, 770, 67);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("College Management System ");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 70));
		lblNewLabel_1.setBounds(167, 223, 1057, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Computer Science Engineering ");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(337, 278, 474, 58);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sy-cse-1");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(511, 333, 101, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Guidance By : Dhanave Sir");
		lblNewLabel_6.setForeground(new Color(0, 128, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(430, 373, 277, 30);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login h=new Login();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton.setBackground(new Color(68, 162, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
		btnNewButton.setBounds(446, 446, 241, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("About Us");
		btnNewButton_1.setBackground(new Color(136, 196, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about h=new about();
        		h.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_1.setBounds(989, 554, 153, 43);
		contentPane.add(btnNewButton_1);
	}
}
