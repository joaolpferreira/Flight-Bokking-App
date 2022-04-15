package dkeep.logic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


/**
 * 
 */
public class Ticket {

    public int ID;
    public char Tier;
    public LocalDate Date;
    public int Gate;
    public String Company;
    public int Price;
    
    Flight flight;
    User user;
    /**
     * Default constructor
     */
    public Ticket(Flight flight, User user) {
    	this.flight=flight;
    	this.user=user;
    }

    //////////DELETE
    /////1
    public static void Delete(int n) {
		Connection connection=null;
		Statement statement=null;
		
		Database obj_Connect=new Database();
		connection=obj_Connect.get_connection();
		
		int i=1;
		while(i<n+1) {
			try {
				String query="delete from" + " tickets " + "where ticket_id=" + i;
				statement=connection.createStatement();
				
				statement.executeUpdate(query);
				//System.out.println("Deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}	
	}

    /////2
	public static void Delete_single_ticket(int ticket_id) {
		Connection connection=null;
		Statement statement=null;
		
		Database obj_Connect=new Database();
		connection=obj_Connect.get_connection();
		
		try {
				String query="delete from" + " tickets " + "where ticket_id=" + ticket_id;
				statement=connection.createStatement();
				
				statement.executeUpdate(query);
				//System.out.println("Deleted");
				
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	//////////INSERT
	/////1
	public static void Insert_Ticket(int Ticket_id, int Flight_id, String Username) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
			
			String sql = "INSERT INTO tickets (ticket_id, flight_id, username) "
					+ "		VALUES (?,?,?)";
			

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, Ticket_id);
			statement.setInt(2, Flight_id);
			statement.setString(3, Username);
				
			int rows = statement.executeUpdate();
			if(rows>0) {
				//System.out.println("Inserted");
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
	public static int [] Query_tickets(String Username) { //also works for sign up if returns 1
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		int [] Ids = new int[100];
		
		try {
		//Check if username exists	
			String query="select * from tickets where username='"+Username+"'";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				//System.out.println("User doesn't exists");
				return null;
			}
		//Return tickets in array
			int i=0;
			while(checker) {
				//System.out.print(rs.getInt("ticket_id")+" | ");
				Ids[i]=rs.getInt("ticket_id");
				i++;
				checker=rs.next();
			}
			return Ids;	
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//ERROR
		return null;
	}
	
	/////2
	public static int [][] Query_flights(String Username) { //also works for sign up if returns 1
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		int [][] Ids = new int[100][2];
		
		try {
		//Check if username exists	
			String query="select * from tickets where username='"+Username+"'";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				//System.out.println("User doesn't exists");
				return null;
			}
		//Return tickets in array
			int i=0;
			while(checker) {
				//System.out.print(rs.getInt("ticket_id")+" | ");
				Ids[i][0]=rs.getInt("ticket_id");
				Ids[i][1]=rs.getInt("flight_id");
				i++;
				checker=rs.next();
			}
			return Ids;	
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//ERROR
		return null;
	}
	
	/////3
	public static int Query_ticket_available() { //also works for sign up if returns 1
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		int num=0;
		
		try {
		//Check if username exists	
			String query="select * from tickets";
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
				num=rs.getInt("ticket_id");
				i++;
				checker=rs.next();
			}
			return num+1;	
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//ERROR
		return -1;
	}
	
	


}