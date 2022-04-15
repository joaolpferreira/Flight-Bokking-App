package dkeep.logic;
import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
	
		public Connection get_connection() {
		Connection connection = null;
		String jdbcURL = "jdbc:postgresql://db.fe.up.pt/up201604177";
		String username="up201604177";
		String password="aFqYB6u2g";
		try
		{
			Class.forName("org.postgresql.Driver");
			connection= DriverManager.getConnection(jdbcURL,username,password);
			//System.out.println("Connection: OK");
			
		//	connection.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
		return connection;
	}
}

//Flight.Insert_Flight(1, "Lisbon", "London", LocalTime.of(10, 0), LocalTime.of(13, 0), Date.valueOf(LocalDate.of(2022, 1, 9)), 100);
//Flight.CreateValues(50002, 90000);
//Flight.Delete(1);
//Flight.Delete_single_flight(1);


//Insert_users.Insert_User(1, "TOOL_TIP_TEXT_KEY", "TOOL_TIP_TEXT_KEY", "TOOL_TIP_TEXT_KEY", "TOOL_TIP_TEXT_KEY", "TOOL_TIP_TEXT_KEY", "TOOL_TIP_TEXT_KEY", null, "TOOL_TIP_TEXT_KEY", "TOOL_TIP_TEXT_KEY", "TOOL_TIP_TEXT_KEY");
