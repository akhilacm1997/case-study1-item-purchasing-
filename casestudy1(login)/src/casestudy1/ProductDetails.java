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

public class ProductDetails {

	public void addpdt() 
	{    ConnectionManager obj2=  new ConnectionManager();
		JFrame f = new JFrame("Registration");
		 f.setSize(1000, 1000);
	     f.setLayout(null);
	     f.setVisible(true);
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     final JTextField tf1 = new JTextField();//creating test filelds
	     final JTextField tf2 = new JTextField();
	     final JTextField tf3 = new JTextField();
	     final JTextField tf4 = new JTextField();
	     final JTextField tf5 = new JTextField();
	     
	     JLabel productname,productid,minsellqty,price,qtyav;//creating labels
	     JLabel productname1 = new JLabel();
	     JLabel productid1 = new JLabel();
	     JLabel minsellqty1= new JLabel();
	     JLabel qtyav1= new JLabel();
	     JLabel price1= new JLabel();
	     JLabel total1= new JLabel();
	     productname = new JLabel("productname:");
	     productid= new JLabel("productid:");
	     minsellqty= new JLabel("min-sell-qty  :");
	     price= new JLabel("price  :");
	     qtyav= new JLabel("qty-available  :");
	     productname.setBounds(50, 100, 100, 40);
	     productid.setBounds(50, 150, 100, 40);
	     minsellqty.setBounds(50, 200, 100, 40);
	     price.setBounds(50, 250, 100, 40);
	     qtyav.setBounds(50, 300, 100, 40);
	     tf1.setBounds(200, 100, 100, 30);
	     tf2.setBounds(200, 150, 100, 30);
	     tf3.setBounds(200, 200, 100, 30);
	     tf4.setBounds(200, 250, 100, 30);
	     tf5.setBounds(200, 300, 100, 30);
	    
	     f.add(productname);
	     f.add( productid);
	     f.add(minsellqty);
	     f.add(price);
	     f.add(qtyav);
	     f.add(productname1);
	     f.add(minsellqty1);
	     f.add( productid1);
	     f.add(price1);
	     f.add(qtyav1);
	     f.add(total1);
	     f.add(tf1);
	     f.add(tf2);
	     f.add(tf3);
	     f.add(tf4);
	     f.add(tf5);
	     JButton b = new   JButton("submit");
	     b.setBounds(200, 50, 100, 30);f.add(b);
	     JButton b1 = new   JButton("Inventory");
	     b1.setBounds(200, 500, 100, 30);f.add(b1);
	     b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){ 
		    		f.add(productname1);f.add(productid1);f.add(minsellqty1);f.add(price1);f.add(qtyav1);
		    		 String nam=tf1.getText();
	    		     int  id=Integer.parseInt(tf2.getText());
	    		     int qty=Integer.parseInt(tf3.getText());
	    		     int pric=Integer.parseInt(tf4.getText());
	    		     int q=Integer.parseInt(tf5.getText());
	    		     int totalcost=0;
	    		     

					try {  

						
						Statement smt = obj2.main1().createStatement();					
						smt.execute("insert into addproduct(productid,productname,minsellqty,quantityavailable,price,totalcost) values("+id+",'"+nam+"',"+qty+","+q+","+pric+","+totalcost+")");
						
					} catch (SQLException | ClassNotFoundException e2) {
				
						e2.printStackTrace();
					} 
					 
				    
				   
		           
				        }  
				    
	     }); 
	     b1.addActionListener(new ActionListener()   //calling admin page
	   	      { 
	   		    	public void actionPerformed(ActionEvent e)
	   		    	{ 
   		    	
	   		    		JFrame f5 = new JFrame ("INVENTORY");
	                    JLabel pid,pne,sqy,ppe,tct;
	                    pid= new JLabel ("Product_ID");
	                    pid.setBounds(10,25,150,30);
	                    f5.add(pid);
	                    pne= new JLabel ("Product_Name");
	                    pne.setBounds(120,25,150,30);
	                    f5.add(pne);
	                    sqy= new JLabel ("Quantity");
	                    sqy.setBounds(240,25,150,30);
	                    f5.add(sqy);
	                    ppe= new JLabel ("Price");
	                    ppe.setBounds(350,25,150,30);
	                    f5.add(ppe);
	                    tct= new JLabel ("Total_Cost");
	                    tct.setBounds(460,25,150,30);
	                    f5.add(tct);
	                    
	                    String sql="SELECT * FROM addproduct";
	                    ResultSet rs1=null;
	                    try {
	                    	Statement smt =obj2.main1().createStatement();
	                    rs1 = smt.executeQuery(sql);
	                    } catch (SQLException | ClassNotFoundException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                    }
	                    try {
	                        int a=0;
	                    while(rs1.next())
	                    {
	                       String id = rs1.getString("productid");
	                       String pn = rs1.getString("productname");
	                       String sq = rs1.getString("quantityavailable");
	                       String pp = rs1.getString("price");
	                      
	                      int isq= Integer.parseInt(sq) ;
	                       int ipp= Integer.parseInt(pp);
	                       int ttc=isq*ipp;
	                       String total=String.valueOf(ttc);
	                    JLabel lid,lpn,lsq,lpp,ltc;
	                    lid= new JLabel (id);
	                    lid.setBounds(10,50+a,150,30);
	                    f5.add(lid);
	                    lpn= new JLabel (pn);
	                    lpn.setBounds(120,50+a,150,30);
	                    f5.add(lpn);
	                    lsq= new JLabel (sq);
	                    lsq.setBounds(240,50+a,150,30);
	                    f5.add(lsq);
	                    lpp= new JLabel (pp);
	                    lpp.setBounds(350,50+a,150,30);
	                    f5.add(lpp);
	                    ltc= new JLabel (total);
	                    ltc.setBounds(460,50+a,150,30);
	                    f5.add(ltc);
	                    a=a+30;
	                    }
	                    } catch (SQLException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                    }
	                    f5.setSize(600,400);
	                    f5.setLayout(null);
	                    f5.setVisible(true);		
							
	   		    	}
	   		    	
	
							
	   	      	
	   		    	
			     });
	  
	     
	    
	   
		    	}
	
}
	  
	     
		
	


