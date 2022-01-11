package appmain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.LoginDetailsDao;
import daoimpl.EmailDetailsDaoImpl;
import daoimpl.LoginDetailsDaoImpl;
import model.EmailDetails;
import model.UserDetails;
import repository.EmailDetailsDaoRes;

public class UserInterface {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

System.out.println("***********Welcome to Email Application****************");
		System.out.println("1: Sign up");
		System.out.println("2: Sign In");
		System.out.println("3: Exit");
		System.out.println("*************************************************************");
		char ch=' ';
		
		LoginDetailsDao loginDetailsDao=new LoginDetailsDaoImpl();
		 EmailDetailsDaoImpl emailDetailsDao= new EmailDetailsDaoImpl();
         ArrayList<EmailDetails> emaildetails = new ArrayList<EmailDetails>() ;


		 String username=null,username1,firstname,lastname,password, location, mobileno;
		 //String eid,eto,efrom,esub,ebody;
		do {
			System.out.println("What you do wish to check from the above list");
		
		
			Scanner sn=new Scanner(System.in);
			int option=sn.nextInt();
		
			switch(option)
			{
			
				case 1:System.out.println("enter the details to signup");
				System.out.println("enter username");
				       username=sn.next();
				       System.out.println("enter password");
				       password=sn.next();
				       System.out.println("enter firstname");

				       firstname=sn.next();
				       System.out.println("enter lastname");

				       lastname=sn.next();
				       System.out.println("enter location");

				       location=sn.next();
				       System.out.println("enter moboileno");

				       mobileno=sn.next();
						UserDetails user=new UserDetails();
						user.setUsername(username);
						user.setPassword(password);
						user.setFirstName(firstname);
						user.setLastName(lastname);
						user.setLocation(location);
						user.setMobileno(mobileno);
			
						
						loginDetailsDao.signUp(user);
			
					System.out.println("signup completed successfully");
			
					break;
				case 2:
					System.out.println("enter the username and password to login");
					 username1=sn.next();
					String pass=sn.next();
					UserDetails details=new UserDetails();
					details.setUsername(username1);
					details.setPassword(pass);
					boolean res=loginDetailsDao.signIn(details);
					if(res){
						System.out.println("login successful");
					
					while(true){
						System.out.println("enter the details");
						System.out.println("1:compose");
				         System.out.println("2:inbox");
						    System.out.println("3:exit");

					System.out.println("select any options");
					Scanner sc=new Scanner(System.in);
					 int c=sc.nextInt();
					 if(c==1){
						 System.out.println("please Enter email id");
						 String eid=sc.next();
						 
						 System.out.println("please Enter Reciever email id");
						 String eto=sc.next();
						 
						 System.out.println("please Enter Sender email id");
						 String efrom=sc.next();
						 
						 System.out.println("please insert subject");
						 String esub=sc.next();
						 
						 System.out.println("please insert emailbody");
						 String ebody=sc.next();
						 

						 EmailDetails d=new EmailDetails();
							d.setEmailid(eid);
							d.setTo(eto);
				           d.setSubject(esub);
							d.setFrom(efrom);
							d.setEmailbody(ebody);
			
			                boolean ans=emailDetailsDao.compose(d);
			                 if(ans){
			                	 System.out.println("Data inserted Successfully");
			                 }
					 
			                else{
			                 System.out.println("something went wrong");
			                }
					 }
					 
					 else if(c==2){
							EmailDetailsDaoRes.showAllEmailRecord();
					 }
					 System.out.println("Email Recordeed.....");
					}
					}
					  
break;
					 
				case 3:
					System.exit(0);
					
				default:System.out.println("----Enter the valid option----");
			}
			System.out.println("Do You Want to check other options..........");				
		ch=sn.next().charAt(0);
			
	  }while(ch=='y'||ch=='Y');
			
		}
}
	
	
	

			
	

		
	




			
	
		

