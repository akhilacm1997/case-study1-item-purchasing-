package casestudy1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Agent
{
	public void age()
	{  
	  ConnectionManager obj2=  new ConnectionManager();//calling database connection through connection manager class 
	 JFrame f = new JFrame("login");
	 f.setSize(500, 500);
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JTextField tf1 = new JTextField();
    final JTextField tf2 = new JTextField();
    JLabel name,password;
    name = new JLabel("Username  :");
    password= new JLabel("Enter your password:");
    name.setBounds(50, 100, 100, 40);
    password.setBounds(50, 150, 200, 40);
    tf1.setBounds(200, 100, 100, 30);
    tf2.setBounds(200, 150, 100, 30);
    f.add(name);
    f.add(password);
    f.add(tf1);
    f.add(tf2);
    JLabel t = new  JLabel();
    ProductDetails s = new ProductDetails();
    JButton b = new   JButton("Submit");
    b.setBounds(200, 200, 100, 30);
    f.add(b);
    b.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		 String nam=tf1.getText();
	    	     String passwor=tf2.getText();
	    	     int count =0;
				try {
					
					
					Statement smt =obj2.main1().createStatement();
					ResultSet rs= smt.executeQuery("select name,password from agent") ;
					while(rs.next())
					{
						if(rs.getString(1).equals(nam)&&(rs.getString(2).equals(passwor)))
						{
						System.out.println("Login sucess");
						 t.setBounds(200, 530, 200, 30);
					     t.setText("****login sucessfully****"); 
					     f.add(t);
					     Agentproduct ag = new  Agentproduct();
					     ag.addpdt();
					     
						 count++;
						 break;
					    }
					}
					if(count==0)
					{
						System.out.println("invalid username or password");
						t.setText("invalid username or password");
					}
				} catch (SQLException | ClassNotFoundException e2) {
					e2.printStackTrace();
				}
				
	    	}
    });
	}
	 }