package casestudy1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) 
	{
				 
		 JFrame f = new JFrame("login");
		 f.setSize(500, 500);
	     f.setLayout(null);
	     f.setVisible(true);
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     JButton b1 = new   JButton("Admin Login");
	     b1.setBounds(200, 100, 110, 30);
	     JButton b2 = new   JButton("Agent Login");
	     b2.setBounds(200, 150, 110, 30);
	     JButton b3 = new   JButton("Exit");
	     b3.setBounds(200, 200, 110, 30);
	      f.add(b1);
	      f.add(b2);
	      f.add(b3);
	      Login l = new Login();
	      Agent a = new Agent();
	      b1.addActionListener(new ActionListener()   //calling admin page
	      { 
		    	public void actionPerformed(ActionEvent e)
		    	{ 
		    		 f.setVisible(false);
		    		l.log();
		    		
		    	}
		   });
	      b2.addActionListener(new ActionListener()     //calling agent page
	      { 
		    	public void actionPerformed(ActionEvent e)
		    	{ 
		    		a.age();
		    		
		    	}
		    	
		   });
	      b3.addActionListener(new ActionListener()   //calling admin page
	    	      { 
	    		    	public void actionPerformed(ActionEvent e)
	    		    	{ 
	    		    		 f.setVisible(false);
	    		    		
	    		    		
	    		    	}
	    		   });


}
}

