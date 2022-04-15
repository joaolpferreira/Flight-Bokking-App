package dkeep.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 
 */
public class Wallet {
    public int Code;
    public int points;
    
    User user;
    Flight flight;
 
    /**
     * Default constructor
     */

    public Wallet() {
    	//points=Wallet.Query_wallet_points(username);
    	
	}
    
    public int get_points(String username) {
    	//System.out.println(username+" identifica");
    	int points=Wallet.Query_wallet_points(username);
    	return points;
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
		
		int i=1;
		while(i<n+1) {
			try {
				String query="delete from" + " wallets " + "where wallet_id=" + i;
				statement=connection.createStatement();
				
				statement.executeUpdate(query);
				//System.out.println("Deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
	}
    
    //////////INSERT
    /////1
    public static void Insert_wallet(String Username, int Wallet_points) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		String[] info = User.Query_user_info(Username);
		int Wallet_id = Integer.parseInt(info[0]);
		System.out.println("wallet "+Wallet_id);
		
		try {
			
			String sql = "INSERT INTO wallets (wallet_id, username, wallet_points) "
					+ "		VALUES (?,?,?)";
			
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, Wallet_id);
				statement.setString(2, Username);
				statement.setInt(3, Wallet_points);
				
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
	
	/////2
    public static void Add_points(String Username, int Wallet_points) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
			int aux=Wallet.Query_wallet_points(Username);
			int total_points = aux+Wallet_points;
			String sql = "UPDATE wallets SET wallet_points = ? where username = ?";
			
				PreparedStatement statement = connection.prepareStatement(sql);
				//statement.setInt(1, 1);
				
				statement.setInt(1, total_points);
				statement.setString(2, Username);
				
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
	
	/////3
	public static void Remove_points(String Username, int Wallet_points) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
			int aux=Wallet.Query_wallet_points(Username);
			int total_points = aux-Wallet_points;
			String sql = "UPDATE wallets SET wallet_points = ? where username = ?";
			
				PreparedStatement statement = connection.prepareStatement(sql);
				//statement.setInt(1, 1);
				
				statement.setInt(1, total_points);
				statement.setString(2, Username);
				
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
	public static int Query_wallet_points(String Username) { //also works for sign up if returns 1
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
		//Check if username exists	
			String query="select * from wallets where username='"+Username+"'";
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			boolean checker=rs.next();
			if(!checker) {
				//System.out.println("User doesn't exists");
				return -1;
			}
		//Return wallet points
			else if(checker) {
				//System.out.print(rs.getString("username")+" | ");
				//System.out.println(rs.getInt("wallet_points"));
				return rs.getInt("wallet_points");
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//ERROR
		return -100;
	}
	
	
	
}
