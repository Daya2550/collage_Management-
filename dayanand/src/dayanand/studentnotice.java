package dayanand;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class studentnotice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel out ;
    private static final String DB_URL = "jdbc:mysql://localhost:3307/";
    private static final String DB_NAME = "notice";
    private static final String USER = "root";
    private static final String PASS = "";

	/**
	 * Launch the application.
	 */
    
    
    // Function to fetch data from the database
    public static String fetchData(int id) {
    	String data="";
        String sql = "SELECT * FROM data WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	data=data+rs.getInt("id")+" :  "+rs.getString("message")+"  ";
            	data=data+"\n";
               // System.out.println("ID: " + rs.getInt("id") + ", Message: " + rs.getString("message"));
            }
        } catch (SQLException e) {
        	
        	//
        }
        return data;
    }
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentnotice frame = new studentnotice();
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
	public studentnotice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Notices ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(441, 27, 238, 60);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st h=new st();
        		h.setVisible(true);
        		dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setBackground(new Color(0, 128, 255));
		back.setBounds(24, 27, 124, 21);
		contentPane.add(back);
		
		JLabel out = new JLabel("");
		out.setVerticalAlignment(SwingConstants.TOP);
		out.setFont(new Font("Tahoma", Font.BOLD, 23));
		out.setBounds(24, 122, 1043, 37);
		contentPane.add(out);
		
		JLabel out1 = new JLabel("");
		out1.setVerticalAlignment(SwingConstants.TOP);
		out1.setFont(new Font("Tahoma", Font.BOLD, 23));
		out1.setBounds(24, 185, 1043, 37);
		contentPane.add(out1);
		
		JLabel out2 = new JLabel("");
		out2.setVerticalAlignment(SwingConstants.TOP);
		out2.setFont(new Font("Tahoma", Font.BOLD, 23));
		out2.setBounds(24, 250, 1043, 37);
		contentPane.add(out2);
		
		JLabel out3 = new JLabel("");
		out3.setVerticalAlignment(SwingConstants.TOP);
		out3.setFont(new Font("Tahoma", Font.BOLD, 23));
		out3.setBounds(24, 313, 1043, 37);
		contentPane.add(out3);
		
		JLabel out4 = new JLabel("");
		out4.setVerticalAlignment(SwingConstants.TOP);
		out4.setFont(new Font("Tahoma", Font.BOLD, 23));
		out4.setBounds(24, 381, 1043, 37);
		contentPane.add(out4);
		
		JLabel out5 = new JLabel("");
		out5.setVerticalAlignment(SwingConstants.TOP);
		out5.setFont(new Font("Tahoma", Font.BOLD, 23));
		out5.setBounds(24, 451, 1043, 37);
		contentPane.add(out5);
		
		JLabel out6 = new JLabel("");
		out6.setVerticalAlignment(SwingConstants.TOP);
		out6.setFont(new Font("Tahoma", Font.BOLD, 23));
		out6.setBounds(24, 514, 1043, 37);
		contentPane.add(out6);
		
		JLabel out7 = new JLabel("");
		out7.setVerticalAlignment(SwingConstants.TOP);
		out7.setFont(new Font("Tahoma", Font.BOLD, 23));
		out7.setBounds(24, 581, 1043, 37);
		contentPane.add(out7);
		
		
		String data1= fetchData(1);
		out.setText(data1);
		data1=fetchData(2);
		out1.setText(data1);
		data1= fetchData(3);
		out2.setText(data1);
		data1= fetchData(4);
		out3.setText(data1);
		data1= fetchData(5);
		out4.setText(data1);
		data1= fetchData(6);
		out5.setText(data1);
		data1= fetchData(7);
		out6.setText(data1);
		data1= fetchData(8);
		out7.setText(data1);
	}
	
}
