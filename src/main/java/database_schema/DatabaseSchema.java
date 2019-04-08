package database_schema;

import java.sql.*;
import java.util.ArrayList;



public class DatabaseSchema {
	
	
	
	public static void main(String args[]) {
		Connection myconn=null;
		DatabaseMetaData meta = null;
		try
		{
			//1. Get connection
			myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb","root","root");
			
			//2. Get metadata
			meta = myconn.getMetaData();
			ResultSet catalogs = meta.getCatalogs();
			
			while (catalogs.next()) {
			       String catalog = catalogs.getString(1);  //"TABLE_CATALOG"
			       System.out.println("catalog: "+catalog);
			     }
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
