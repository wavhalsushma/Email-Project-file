package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import config.MyConnection;
import dao.LoginDetailsDao;
import model.EmailDetails;
import model.UserDetails;

public class EmailDetailsDaoRes {
	Connection connection=null;
	static Statement statement=null;
	ResultSet resultSet=null;
	public void EmailDetailsDaoRes() throws SQLException
	{
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}
	public boolean compose(EmailDetails details) throws SQLException
	{

	int res = statement.executeUpdate("insert into emaildetails values('"+details.getEmailid()+"','"+details.getTo()+"','"+details.getFrom()+"','"+details.getSubject()+"','"+details.getEmailbody()+"')");
	if(res==1)
	{
	return true;
	}else
	return false;
	}

	
	public static void  showAllEmailRecord()
     {
   	  boolean f= false;
   	  try{ 
   		     Connection con=MyConnection.getConnection();
   		   String query = "select *from emaildetails";
   		 Statement st=con.createStatement();
   			ResultSet resultset = st.executeQuery(query);
   			 while(resultset.next()){
   				 String sid= resultset.getString(1);
   				  String sto = resultset.getString(2);
   				  String sfrom= resultset.getString(3);
   				  String ssub= resultset.getString(4);
   				  String sbody= resultset.getString(5);
   				  System.out.println(" Email Id:"+sid +"\n Email To : "+sto +"\n Email From: "+sfrom+ "\n Email sub: "+ssub+ "\n Email body: "+sbody);
   				 System.out.println("-------------------------------------------------------------------------------------");
   			 }
   		   
   	  }catch(Exception e){
   		  
   	  }
     }
}
     