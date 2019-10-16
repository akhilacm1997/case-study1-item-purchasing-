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

public class Agentproduct {

	public void addpdt() {
		JFrame f = new JFrame("agentpdt");
		    f.setSize(500, 500);
		    f.setLayout(null);
		    f.setVisible(true);
	     JButton b2 = new   JButton("Buy");
	     b2.setBounds(200, 250, 100, 30);
	     JButton b3 = new   JButton("sell");
	     b3.setBounds(200, 300, 100, 30);
	     JButton b4 = new   JButton("show");
	     b4.setBounds(200, 200, 100, 30);
	     f.add(b4);
	     f.add(b3);
	     f.add(b2);
	     b2.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){ 
		    		 JFrame f1 = new JFrame("buy");
		    		 final JTextField tf1 = new JTextField();
		       	     final JTextField tf2 = new JTextField();
		       	     final JTextField tf3 = new JTextField();
		       	     JLabel name,password,qty,totalprice;
		       	     name = new JLabel("Productname  :");
		       	     password= new JLabel("Enter productID :");
		       	     totalprice= new JLabel("totalprice :");
		           	 qty = new JLabel("qty  :");
		       	     name.setBounds(50, 100, 100, 40);
		       	     password.setBounds(50, 150, 200, 40);
		       	     qty.setBounds(50, 200, 100, 40);
		       	     totalprice.setBounds(50, 250, 100, 40);
		       	     tf1.setBounds(200, 100, 100, 30);
		       	     tf2.setBounds(200, 150, 100, 30);
		       	     tf3.setBounds(200, 200, 100, 30);
		       	     f1.add(name);
		       	     f1.add(password);
		       	     f1.add(tf1);
		       	     f1.add(tf2);
		       	     f1.add(tf3);
		       	     f1.add(qty);
		       	     f1.setSize(500, 500);
				     f1.setLayout(null);
				     f1.setVisible(true);
				     ConnectionManager obj2 =  new ConnectionManager();
				     	 
						 JButton b3 = new   JButton("BUY-ITEM");
					     b3.setBounds(200, 300, 100, 30);
					     f1.add(b3);
					     b3.addActionListener(new ActionListener(){  
						    	public void actionPerformed(ActionEvent e){ 
						    		 int id=Integer.parseInt(tf2.getText());
								     int q=Integer.parseInt(tf3.getText());
									 System.out.println(id);
						    		Statement smt = null;
									try {
										smt = obj2.main1().createStatement();
									
									
										ResultSet rs= smt.executeQuery("select productname,price,minsellqty,quantityavailable from addproduct where productid='"+id+"'") ;
									     if(rs.next())
									     {     
									    	  
									    	 
									    	  String nam= rs.getString("productname");
									    	  int price= rs.getInt("price");
									    	  int qtyavl= rs.getInt("quantityavailable");
									    	  int minqty= rs.getInt("minsellqty");
									    	  String b="buy";
										      int s=minqty;
										      int s1=qtyavl;
										      int pri=q*price;
									    	  System.out.println(nam);
									    	  System.out.println(price);
									    	  JLabel namee,pricee,qtyy,minqtyy;
									    	  String price1 = Integer.toString(price); 
									    	  String qty1 = Integer.toString(qtyavl); 
									    	  String minqty1 = Integer.toString(minqty); 
									   	      namee = new JLabel(nam);
									   	      pricee= new JLabel(price1);
									   	      qtyy= new JLabel(qty1);
									   	      minqtyy=new JLabel(minqty1);
									   	      f1.add(namee);
									   	      f1.add(pricee);
									   	      f1.add(minqtyy);
									   	      f1.add(qtyy);
									   	      namee.setBounds(200, 600, 100, 30);
									   	      pricee.setBounds(400, 600, 100, 30);
									   	      minqtyy.setBounds(600, 600, 100, 30);
									   	      qtyy.setBounds(800, 600, 100, 30);
									   	      if((q>=s)&&(q<=s1))
									   	      {
									   	    	  int updateQ=s1-q;
									   	    	  System.out.println(updateQ);
									   	    	 smt.executeUpdate("update addproduct set quantityavailable="+updateQ+" where productid='"+id+"'");
									   	    	 smt.execute("insert into showagent values('"+nam+"','"+b+"',"+q+","+pri+","+price1+")");
									   	    	//stn.executeUpdate("update Item set quantAvl="+sellAvl+" where pdctID="+pdID);
									   	      }
									   	     
									     }
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
						    		
								
									 }
									
									
									
						    	
					    });
						 
						 
					
					
		    		
	
				        }  
				    
	     }); 
	     b3.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){ 
		    		 JFrame f1 = new JFrame("buy");
		    		 final JTextField tf1 = new JTextField();
		       	     final JTextField tf2 = new JTextField();
		       	     final JTextField tf3 = new JTextField();
		       	     JLabel name,password,qty,totalprice;
		       	     name = new JLabel("Productname  :");
		       	     password= new JLabel("Enter productID :");
		       	     totalprice= new JLabel("totalprice :");
		           	 qty = new JLabel("qty  :");
		       	     name.setBounds(50, 100, 100, 40);
		       	     password.setBounds(50, 150, 200, 40);
		       	     qty.setBounds(50, 200, 100, 40);
		       	     totalprice.setBounds(50, 250, 100, 40);
		       	     tf1.setBounds(200, 100, 100, 30);
		       	     tf2.setBounds(200, 150, 100, 30);
		       	     tf3.setBounds(200, 200, 100, 30);
		       	     f1.add(name);
		       	     f1.add(password);
		       	     f1.add(tf1);
		       	     f1.add(tf2);
		       	     f1.add(tf3);
		       	     f1.add(qty);
		       	     f1.setSize(500, 500);
				     f1.setLayout(null);
				     f1.setVisible(true);
				     ConnectionManager obj2 =  new ConnectionManager();
				     	 
						 JButton b3 = new   JButton("Sell-ITEM");
					     b3.setBounds(200, 300, 100, 30);
					     f1.add(b3);
					     b3.addActionListener(new ActionListener(){  
						    	public void actionPerformed(ActionEvent e){ 
						    		 int id=Integer.parseInt(tf2.getText());
								     int q=Integer.parseInt(tf3.getText());
									 System.out.println(id);
						    		Statement smt = null;
									try {
										smt = obj2.main1().createStatement();
									
									
										ResultSet rs= smt.executeQuery("select productname,price,minsellqty,quantityavailable from addproduct where productid='"+id+"'") ;
									     if(rs.next())
									     {     
									    	  
									    	 
									    	  String nam= rs.getString("productname");
									    	  int price= rs.getInt("price");
									    	  int qtyavl= rs.getInt("quantityavailable");
									    	  int minqty= rs.getInt("minsellqty");
										      int s=minqty;
										      int s1=qtyavl;
										      int pri=q*price;
										      String b="sell";
									    	  System.out.println(nam);
									    	  System.out.println(price);
									    	  JLabel namee,pricee,qtyy,minqtyy;
									    	  String price1 = Integer.toString(price); 
									    	  String qty1 = Integer.toString(qtyavl); 
									    	  String minqty1 = Integer.toString(minqty); 
									   	      namee = new JLabel(nam);
									   	      pricee= new JLabel(price1);
									   	      qtyy= new JLabel(qty1);
									   	      minqtyy=new JLabel(minqty1);
									   	      f1.add(namee);
									   	      f1.add(pricee);
									   	      f1.add(minqtyy);
									   	      f1.add(qtyy);
									   	      namee.setBounds(200, 600, 100, 30);
									   	      pricee.setBounds(400, 600, 100, 30);
									   	      minqtyy.setBounds(600, 600, 100, 30);
									   	      qtyy.setBounds(800, 600, 100, 30);
									   	     
									   	    	  int updateQ=s1+q;
									   	    	  System.out.println(updateQ);
									   	    	 smt.executeUpdate("update addproduct set quantityavailable="+updateQ+" where productid='"+id+"'");
									   	 	     smt.execute("insert into showagent values('"+nam+"','"+b+"',"+q+","+pri+","+price1+")");
									   	    	//stn.executeUpdate("update Item set quantAvl="+sellAvl+" where pdctID="+pdID);
									   	      
									   	     
									     }
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
						    		
								
									 }
									
									
									
						    	
					    });
					    
					     }
		    	
				    
	     });
	     b4.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){ 
		    		ConnectionManager obj2=  new ConnectionManager();
   		    		JFrame f5 = new JFrame ("SHOW-TRANSATION");
                    JLabel pid,pne,sqy,ppe,tct;
                    pid= new JLabel ("Product_name");
                    pid.setBounds(10,25,150,30);
                    f5.add(pid);
                    pne= new JLabel ("buy/sel");
                    pne.setBounds(120,25,150,30);
                    f5.add(pne);
                    sqy= new JLabel ("Quantity");
                    sqy.setBounds(240,25,150,30);
                    f5.add(sqy);
                    ppe= new JLabel ("Total_Price");
                    ppe.setBounds(350,25,150,30);
                    f5.add(ppe);
                    tct= new JLabel ("Item_Cost");
                    tct.setBounds(460,25,150,30);
                    f5.add(tct);
                    
                    String sql="SELECT * FROM showagent";
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
                       String id = rs1.getString("productname");
                       String pn = rs1.getString("buy/sell");
                       String sq = rs1.getString("qty");
                       String pp = rs1.getString("totalprice");
                      
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
