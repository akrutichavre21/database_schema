package database_schema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class DatabaseSchema {
	
	static ArrayList<String> DatabaseNames = new ArrayList<String>();
	
	public static void main(String args[]) {
		Connection myconn=null;
		DatabaseMetaData meta = null;
		//final String data = "";
		try
		{
			//1. Get connection
			myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb","root","root");
			
			//2. Get metadata
			meta = myconn.getMetaData();
			ResultSet catalogs = meta.getCatalogs();
			
			
			
			while(catalogs.next())
			{
				String catalog = catalogs.getString(1);
			//	System.out.println(catalog);
				DatabaseNames.add(catalog);
			}
			
			System.out.println(DatabaseNames);
			
			JFrame f;    
			
			
			f=new JFrame("Databases - ");   
			final JLabel label = new JLabel();          
			label.setHorizontalAlignment(JLabel.CENTER);  
		    label.setSize(400,100);  
		    JButton b=new JButton("Show");  
		    b.setBounds(200,100,75,20);  	            
		    final JComboBox cb=new JComboBox(DatabaseNames.toArray());    
			cb.setBounds(50, 100,90,20);    
			f.add(cb); f.add(label); f.add(b);    
			f.setLayout(null);    
			f.setSize(350,350);    
			f.setVisible(true);   
			
			b.addActionListener(new ActionListener() {  
				public void actionPerformed(ActionEvent e) {   
				String data = ""+cb.getItemAt(cb.getSelectedIndex());  
				String localData = "Database selected: " + data;
				label.setText(localData); 
				
				System.out.println(data);
			
				}
			});
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		//	close(myconn);
		}

		
		
	}

}
