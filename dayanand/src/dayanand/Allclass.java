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
public class Allclass extends JFrame {
	public String subject ="";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;
	private JTextField out1;
	private JTextField out2;
	JComboBox ch;
	JRadioButton py;
	JRadioButton aby;
	private String name="";
	int aa=0;
	 private JTextField fileNameField;
	 private JButton downloadButton;
	

	/**
	 * Launch the application.
	 */
	 private Connection connection;
	 private Statement statement;
	int[] present = new int[100];
    int[] check = new int[100];
    int[] spre = new int[100];
    int[] apre = new int[100];
    int[] abr = new int[100];
    int[] pr = new int[100];
	
    int total = 78;
    int start = 0;
    private JLabel lblNewLabel_2;
    private JTextField subj;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JButton re;
    int totallec=0;
    int presentlec=0;
    String namest="";
    String rollst="";
    private JLabel lblNewLabel_3;
    private JComboBox comboBox;
    //canecetion in data base
    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/nbnscoe", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
   }
    }
    
    
  void dataupdate() {
	 
	
	  
	  connectToDatabase();
	  for (int k = start + 1; k < total + 1; k++) {
		 
		  
		  if (spre[k] == 1) {

			String id=String.valueOf(k);
			int tot = fetchData(id);
			int pre = fetchData1(id);
		    String d=String.valueOf((tot+1));
			String P=String.valueOf(pre+1);
			updateData(id,d,P);
			     //  a.updateData(id,"0","0");
				 
		    }
		  
		  else
		  {
			String id=String.valueOf(k);
			int tot1 = fetchData(id);
			int pre1 =fetchData1(id);
			String d=String.valueOf((tot1+1));
			String P=String.valueOf(pre1);
			updateData(id,d,P);
			    	// a.updateData(id,"0","0"); 
			    } 
		}
	  JOptionPane.showMessageDialog(this, "Data Saved successfully");
	    
  }
    
//logic for feche the data database 
   public int fetchData(String roll) {
	   String tableName =subject;
	   int lect=0;
	 int lecp=0;
	 
        try {
            String id = roll;
            String query = "SELECT total, present,name FROM " + tableName + " WHERE id = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
            	String namest=resultSet.getString("name");
               lect = resultSet.getInt("total");
                  lecp = resultSet.getInt("present");
                // Store fetched data in variables or display as needed
                //JOptionPane.showMessageDialog(this, "data found for Roll no: " + namest);
                 
            } else {
               // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lect;
    }
    
 //logic for feche the data database 
   public int fetchData1(String roll) {
	   String tableName =subject;
	   int lect=0;
	 int lecp=0;
	
        try {
            String id = roll;
            String query = "SELECT total, present,name FROM " + tableName + " WHERE id = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
            	String namest=resultSet.getString("name");
               lect = resultSet.getInt("total");
                  lecp = resultSet.getInt("present");
                // Store fetched data in variables or display as needed
                //JOptionPane.showMessageDialog(this, "data found for Roll no: " + namest);
                 
            } else {
               // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecp;
    }
    
   
   
   // update data in data base
    public void updateData(String roll,String nolec,String prelec) {
    	 String tableName =subject;
        try {
            String id = roll;
            String total = nolec;
            String present = prelec;

            String query = "UPDATE " + tableName + " SET total = '" + total + "', present = '" + present + "' WHERE id = '" + id + "'";
            int rowsAffected = statement.executeUpdate(query);
            
            if (rowsAffected > 0) {
               // JOptionPane.showMessageDialog(this, "Data updated successfully");
            } else {
               // JOptionPane.showMessageDialog(this, "No data found for Roll no: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
    
    // add data in data base
    private void addData() {
    	 String tableName =subject;
    	 try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/nbnscoe", "root", "");
             statement = connection.createStatement();
         } catch (SQLException e) {
    }
    	try {
         
       	for (int i=1;i<79;i++) {
       	String name= data(i);
  	    String id =""+i;
        String total =""+0;
        String present =""+0;
            String query = "INSERT INTO " + tableName + " ( id, name ,total, present) VALUES ('" + id + "', '" + name + "', '" + total + "', '" + present + "')";
            statement.executeUpdate(query);
           // JOptionPane.showMessageDialog(this, "Data added successfully");  
        }
    	  }
    	catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	
    }
    
    
  
    
void display(int[] spre, int[] apre, int total, int start, String subject) {
// printing information about the present and absent
System.out.println("\n" + "Subject : " + subject + "\n");
int presentCount = 0;
int absentCount = 0;
String out="";


System.out.println("Present : ");
for (int k = start + 1; k < total + 1; k++) {
    if (spre[k] == 1) {
        System.out.println(k + ": " );
        out +=" " + k;
        presentCount++;

    }
}
out1.setText(out);
String outab="";
System.out.println("\nTotal Present: " + presentCount);

System.out.println("\n");
System.out.println("Absent : ");
for (int j = start + 1; j < total + 1; j++) {
    if (apre[j] == 1) {
        System.out.println(j + ": ");
        outab += " " +  j;
        absentCount++;
    }
}
System.out.println("\nTotal Absent: " + absentCount);

out2.setText(outab);
}

//Enter the absent Roll no Logic
public void enterab(int[] spre, int[] apre,int[] abr, int total, int start ,String datatext ){

    String data =datatext;
     String numbersString ="0,";
     numbersString += data;
    String[] numbersArray = numbersString.split(",");
    Arrays.sort(numbersArray);
    for (int i = 0; i < numbersArray.length; i++) {
        abr[i] = Integer.parseInt(numbersArray[i]);
    }

     int l = start + 1;
     for (int abb = start + 1; abb < total + 1; abb++) {

         if (abr[l] == abb) {
             apre[abb] = 1;
             l = l + 1;
         } else {
             spre[abb] = 1;
         }
     }


 }
//Enter the present Roll no Logic

public void enterpr(int[] spre, int[] apre,int[] abr, int total, int start ,String datatext ){

    String data =datatext;
     String numbersString ="0,";
     numbersString += data;
    String[] numbersArray = numbersString.split(",");
    Arrays.sort(numbersArray);
    for (int i = 0; i < numbersArray.length; i++) {
        pr[i] = Integer.parseInt(numbersArray[i]);
    }

     int l = start + 1;
     for (int spp = start + 1; spp < total + 1; spp++) {

         if (abr[l] == spp) {
        	 spre[spp] = 1;
             l = l + 1;
         } else {
             apre[spp] = 1;
         }
     }


 }

private void downloadFile(String fileName) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save File");
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try {
            // Here, you should implement your file download logic
            // For demonstration purposes, let's assume we copy a sample file
            File sourceFile = new File(fileName); // Assuming the file exists in the current directory
            Files.copy(sourceFile.toPath(), selectedFile.toPath());
            JOptionPane.showMessageDialog(this, "File downloaded successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error downloading file: " + ex.getMessage());
        }
    }
}


//Create the txt File Logic
public static String txt( int start,int total,int []spre, int[]apre ,String subject) {
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = dateFormat.format(currentDate);
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String formattedTime = timeFormat.format(currentDate);
  
   String  name="Sy-"+formattedDate+" "+subject+".txt";
    
    try {
     
      System.out.println(name);
        FileWriter myWriter = new FileWriter(name);

        int presentCount = 0;
        int absentCount = 0;
        myWriter.write("--------------------"+subject+"---------------------\n");
        myWriter.write(formattedDate+"\n");
        myWriter.write( formattedTime+"\n");

        myWriter.write("present :\n");
        for (int k = start + 1; k < total + 1; k++) {
            if (spre[k] == 1) {
                
                myWriter.write(k + ": " + data(k)+"\n");
                presentCount++;
    
            }
        }
       
        myWriter.write("Absent : \n");
        for (int j = start + 1; j < total + 1; j++) {
            if (apre[j] == 1) {
                
                myWriter.write(j + ": " + data(j)+"\n" );
                absentCount++;
            }
        }
        myWriter.write("\nTotal Present: " + presentCount + "\n");
        myWriter.write("\nTotal Absent: " + absentCount + "\n" );
        myWriter.close();

        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    
    return name ;
    
    
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
					Allclass frame = new Allclass();
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
	public Allclass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".cartoon-illustration-man-holding-stick-hand-giving-presentation_262129-821.jpg"));
		setTitle("Attendance System");
		

		for (int set = 0; set <100; set++) {
			present[set] = 1;
			check[set] = 1;
			spre[set] = 0;
			apre[set] = 0;
			abr[set] = 0;
			pr[set] = 0;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 231, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input = new JTextField();
		input.setBackground(new Color(147, 201, 255));
		input.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		input.setBounds(226, 268, 1030, 102);
		contentPane.add(input);
		input.setColumns(10);
		
		   comboBox = new JComboBox();
		   comboBox.setBackground(new Color(0, 255, 64));
	        comboBox.setModel(new DefaultComboBoxModel(new String[] {"java", "coa", "cn", "am2", "toc", "mds"}));
	        comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
	        comboBox.setBounds(135, 92, 85, 31);
	        contentPane.add(comboBox);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Roll no :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(3, 286, 224, 45);
		contentPane.add(lblNewLabel_1);
		
		
		 
		
		
		JButton ok = new JButton("Submits ");
		ok.setForeground(new Color(0, 0, 0));
		ok.setBackground(new Color(0, 255, 64));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				subject=((String)comboBox.getSelectedItem());
				addData();
				
				if (aa==1) {
					 enterpr(spre, apre, pr, total, start ,input.getText());
	         			display(spre, apre, total, start, subject);
	         			subject=((String)comboBox.getSelectedItem());}
				
				else if(aa==2) {
					enterab(spre, apre, pr, total, start ,input.getText());
         			display(spre, apre, total, start, subject);
         			subject=((String)comboBox.getSelectedItem());}
				
			
				else {
					input.setText("Plase Select The Present & Absent Button ");
				}
	
				
			}
		});
		ok.setFont(new Font("Tahoma", Font.BOLD, 30));
		ok.setBounds(226, 380, 218, 36);
		contentPane.add(ok);
		
		out1 = new JTextField();
		out1.setBackground(new Color(179, 255, 217));
		out1.setFont(new Font("Tahoma", Font.BOLD, 13));
		out1.setBounds(190, 426, 1066, 73);
		contentPane.add(out1);
		out1.setColumns(10);
		
		out2 = new JTextField();
		out2.setBackground(new Color(255, 185, 185));
		out2.setFont(new Font("Tahoma", Font.BOLD, 13));
		out2.setBounds(190, 509, 1066, 73);
		contentPane.add(out2);
		out2.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Date & Time");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(3, 50, 123, 25);
		contentPane.add(lblNewLabel_2);
		
		subj = new JTextField();
		subj.setBackground(new Color(174, 228, 255));
		subj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subj.setBounds(127, 45, 224, 36);
		contentPane.add(subj);
		subj.setColumns(10);
		Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(currentDate);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(currentDate);
        System.out.println("Date: " + formattedDate);
        System.out.println("Time: " + formattedTime);
        String datenew ="";
        datenew=formattedDate +" & "+formattedTime;
        subj.setText(datenew);
        
        btnNewButton = new JButton("TextFile");
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.setForeground(new Color(64, 0, 128));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String n =txt(start ,total,spre ,apre,subject);
        		 JOptionPane.showMessageDialog(Allclass.this, "File are Created name as : "+ n);
        		
        		

        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(1108, 581, 123, 31);
        contentPane.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Home");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Home h=new Home();
        		h.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1.setBackground(new Color(0, 128, 255));
        btnNewButton_1.setForeground(new Color(64, 0, 128));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(190, 592, 116, 31);
        contentPane.add(btnNewButton_1);
        
        JRadioButton py = new JRadioButton("Enter Present Roll No");
        py.setBackground(new Color(157, 157, 255));
        py.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aa=1;
        	}
        });
        py.setFont(new Font("Tahoma", Font.PLAIN, 20));
        py.setBounds(205, 205, 218, 25);
        contentPane.add(py);
        
        JRadioButton aby = new JRadioButton("Enter Absent Roll No");
        aby.setBackground(new Color(157, 157, 255));
        aby.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aa=2;
        	}
        });
        
      
        
        
        
        aby.setFont(new Font("Tahoma", Font.PLAIN, 20));
        aby.setBounds(482, 205, 218, 25);
        contentPane.add(aby);
        
        lblNewLabel_4 = new JLabel("Present Roll no");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(36, 444, 144, 31);
        contentPane.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Absent Roll No");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(32, 530, 131, 25);
        contentPane.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("Select :");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6.setBounds(68, 205, 95, 25);
        contentPane.add(lblNewLabel_6);
        
        JButton btnNewButton_2 = new JButton("save file");
        btnNewButton_2.setBackground(new Color(0, 128, 255));
        btnNewButton_2.setForeground(new Color(64, 0, 128));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		subject=((String)comboBox.getSelectedItem());
        		 String fileName =  txt(start ,total,spre ,apre,subject);
	                if (!fileName.isEmpty()) {
	                    downloadFile(fileName);
	                } else {
	                    JOptionPane.showMessageDialog(Allclass.this, "Please enter a file name.");
	                }
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setBounds(1118, 612, 95, 21);
        contentPane.add(btnNewButton_2);
        
        re = new JButton("Reset");
        re.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		out1.setText("");
				out2.setText("");
				input.setText("");
				
				py.setSelected(false);
				aby.setSelected(false);
				for (int set = 0; set <100; set++) {
					present[set] = 1;
					check[set] = 1;
					spre[set] = 0;
					apre[set] = 0;
					abr[set] = 0;
					pr[set] = 0;
				}
				JOptionPane.showMessageDialog(Allclass.this, "reset");
        	}
        });
        re.setForeground(new Color(0, 0, 0));
        re.setFont(new Font("Tahoma", Font.BOLD, 30));
        re.setBackground(new Color(255, 0, 0));
        re.setBounds(1006, 380, 250, 36);
        contentPane.add(re);
        
        JButton database = new JButton("Save in Database");
        database.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		subject=((String)comboBox.getSelectedItem());
        		dataupdate();
        		 database.setVisible(false);
        		 JOptionPane.showMessageDialog(Allclass.this, "Please enter a file name.");
        	}
        });
        database.setForeground(new Color(64, 0, 128));
        database.setFont(new Font("Tahoma", Font.PLAIN, 20));
        database.setBackground(new Color(0, 255, 0));
        database.setBounds(640, 592, 224, 31);
        contentPane.add(database);
        
        lblNewLabel_3 = new JLabel("Subject :");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3.setBounds(36, 94, 99, 27);
        contentPane.add(lblNewLabel_3);
        
       
	}
}
