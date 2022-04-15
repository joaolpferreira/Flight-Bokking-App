package dkeep.logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 
 */
public class User {
	public boolean is_admin;
	 public String Username;
	 public String Email;
	 public String Password;
	 public String Contact;
	 public String Passport;

	
	 Ticket ticket;
	
	/**
     * Default constructor
     */
    public User() {
    	
    	/*String [] info=User.Query_user_info(user);
    	
    	Email=info[1];
    	Password=info[2];
    	Name=info[3];
    	Date_of_birth=info[4];
    	Gender=info[5];
    	Contact_number=info[6];
    	Passport_id=info[7];
    	*/
    	//wallet=new Wallet(user);
    }
    
    
    public String get_username() {
    	//System.out.println(Username + " get");
    	return Username;
    }
    
    public String get_email() {
    	//System.out.println(Username + " get");
    	return Email;
    }
    
    public String get_contact() {
    	//System.out.println(Username + " get");
    	return Contact;
    }
    
    public String get_passport() {
    	//System.out.println(Username + " get");
    	return Passport;
    }
    
    public void set_user_username(String username) {
    	//System.out.println(username+ " set");
    	this.Username=username;
        
    	String[] info = User.Query_user_info(username);
    	this.Email=info[1];
    	this.Contact=info[2];
    	this.Passport=info[3];
    	
    	
    	//this.Username.valueOf(username);
    }
    /**
     * 
     */
    
    
    
    //////////DELETE
    /////1
    public static void Delete(int n) {
		Connection connection=null;
		Statement statement=null;
		
		Database obj_Connect=new Database();
		connection=obj_Connect.get_connection();
		

			try {
				String query="delete from" + " users " + "where user_id=" + n;
				statement=connection.createStatement();
				
				statement.executeUpdate(query);
				//System.out.println("Deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
    
    //////////INSERT
    /////1
    public static void Insert_User(String Username, String Password, String Email, String Security_question, String Answer, String Contact_number, String Passport_id) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		int User_id=User.Query_userid_available();
		try {
			
			String sql = "INSERT INTO users (user_id,username, password, email, security_question, answer, contact_number, passport_id) "
					+ "		VALUES (?,?,?,?,?,?,?,?)";
				
			//System.out.println(Username+" try2");
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, User_id);
				statement.setString(2, Username);
				statement.setString(3, Password);
				statement.setString(4, Email);			
				statement.setString(5, Security_question);
				statement.setString(6, Answer);
				statement.setString(7, Contact_number);
				statement.setString(8, Passport_id);
			
				int rows = statement.executeUpdate();
				if(rows>0) {
					System.out.println("Inserted");
				}		
			//connection.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
    
    //////////QUERY
    /////1
    public static int Query_login(String Username, String Password) { //also works for sign up if returns 1
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
		//Check if username exists	
		//Use for button Sign_up
			String query="select username from users where username='"+Username+"'";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				//System.out.println("User doesn't exists");
				return 1;
			}
		//Password doens't match username
			else if(checker) {
				query="select * from users where username='"+Username+"' and password='"+Password+"'";
				statemnt=connection.createStatement();
				rs=statemnt.executeQuery(query);
				checker=rs.next();
				if(!checker) {
					//System.out.println("Wrong password");
					return 2;
				}
				//Password match username
				else if(checker) {
					if(rs.getString("username").equals("admin")) {
						if(rs.getString("password").equals("admin")){
							return 3;
						}
					}
					
					//System.out.print(rs.getString("username")+" | ");
					//System.out.println(rs.getString("password"));
					return 4;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 5;
	}
	
	/////2
	public static String [] Query_forgot_password_1(String Username) {
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		String [] security_info= new String[2];
		try {
			//Check if username exists	
			String query="select user from users where username='"+Username+"'";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				//System.out.println("User doesn't exists");
				security_info=null;
				return security_info;
			}
		//return user's security information
			else if(checker) {
				query="select * from users where username='"+Username+"'";
				statemnt=connection.createStatement();
				rs=statemnt.executeQuery(query);
				checker=rs.next();
				if(!checker) {
					System.out.println("Error");
					security_info=null;
					return security_info;
				}
				else if(checker) {
					//System.out.print(rs.getString("name")+" | ");
					//System.out.println(rs.getString("security_question"));
					security_info[0]=rs.getString("username");
					security_info[1]=rs.getString("security_question");
					return security_info;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//returns error
		security_info=null;
		return security_info;
	}
	
	/////3
	public static String Query_forgot_password_2(String Username, String Security_question, String Answer) {
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		String passw="undefined";
		try {
			String query="select * from users where username='"+Username+"' and answer='"+Answer+"'";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				//System.out.println("Wrong answer");
				passw=null;
				return passw;
			}
		//return give password
			else if(checker) {
				//System.out.println("Right answer");
				passw=rs.getString("password");
				return passw;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//Error
		passw=null;
		return passw;
	}
	
	/////4
	public static String [] Query_user_info(String Username) {
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		String [] info=new String[8];
		try {
			String query="select * from users where username='"+Username+"'";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				//System.out.println("Wrong answer");
				info=null;
				return info;
			}
		//return give password
			else if(checker) {
				//System.out.println("Right answer");
				info[0]=rs.getString("user_id");
				info[1]=rs.getString("email");
				info[2]=rs.getString("contact_number");
				info[3]=rs.getString("passport_id");
				return info;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//Error
		info=null;
		return info;
	}
	/////5
	public static int Query_userid_available() { //also works for sign up if returns 1
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		int num=0;
		
		try {
		//Check if username exists	
			String query="select * from users";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				
				return 1;
			}
		//Return tickets in array
			int i=1;
			while(checker) {
				//System.out.print(rs.getInt("ticket_id")+" | ");
				num=rs.getInt("user_id");
				i++;
				checker=rs.next();
			}
			return i;	
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//ERROR
		return -1;
	}
}