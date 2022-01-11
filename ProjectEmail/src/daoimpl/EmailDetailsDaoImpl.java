package daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import config.MyConnection;

import dao.EmailDetailsDao;
import model.EmailDetails;
import model.UserDetails;
import repository.EmailDetailsDaoRes;


public class EmailDetailsDaoImpl implements EmailDetailsDao{
	Connection con;
	 Statement statement;
	
	public EmailDetailsDaoImpl() throws SQLException
	{
		con=MyConnection.getConnection();
		statement=con.createStatement();
	}
	

	
	//compose method
	@Override
	public boolean compose(EmailDetails details) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			res = statement.executeUpdate("insert into emaildetails values('"+details.getEmailid()+"','"+details.getTo()+" ','"+details.getFrom()+"','"+details.getSubject()+"','"+details.getEmailbody()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res==1)
		{
		return  true;
		}else
		return false;
		}
		

		
	public static void showAllEmailInbox(){
		// TODO Auto-generated method stub
		
		try {
			Connection con=MyConnection.getConnection();
			String query = "select * from emaildetails";
			Statement st=con.createStatement();
			ResultSet resultSet=st.executeQuery(query);
			while(resultSet.next())
			{
				EmailDetails emaildetails=new EmailDetails();
				String eid=resultSet.getString("email_id");
				String eto=resultSet.getString("email_to");
				String efrom=resultSet.getString("email_from");
				String esub=resultSet.getString("email_sub");
				String ebody=resultSet.getString("email_body");
                 
				System.out.println("Email_id:"+eid);
                System.out.println("Email_to:"+eto);
                System.out.println("Email_from:"+efrom);
                System.out.println("Email_sub:"+esub);
                System.out.println("Email_body:"+ebody);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void showAllEmailRecord() {
		// TODO Auto-generated method stub
		
	}
	}
	
	
	
	
			