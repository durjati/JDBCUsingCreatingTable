package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A {
	Connection con= null;
	Statement s= null;
	  public void Creating() {
		    try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
				s=con.createStatement();
				s.executeUpdate("create table emp(eid int primary key auto_increment,ename varchar(30)not null,esal int,email varchar(80) unique)");
						
			}
		    catch (ClassNotFoundException e) {
              e.printStackTrace();
			 }
		   
		    catch (SQLException e) {
				e.printStackTrace();
			}
		    finally
		    {
		       try {                            //if(con!=null){  //if(s!=null)
					con.close();                //try{
				} catch (SQLException e) {       //con.close();   //s.close();
					                            //} 
					e.printStackTrace();        //}catch (SQLException e) {
				}	
				                              	//e.printStackTrace();
				                                //}
		    	try {
					s.close();
				} catch (SQLException e) {
				 	
					e.printStackTrace();
				}
		    }
	  }

}
