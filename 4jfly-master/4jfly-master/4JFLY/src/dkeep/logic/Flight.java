package dkeep.logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * 
 */
public class Flight {
	public int Number;
    public String Arrival;
    public String Departure;
    public LocalTime DepartureTime;
    public LocalTime ArrivalTime;

    Ticket ticket;
    Wallet wallet;
    
    /**
     * Default constructor
     */
    public Flight(Ticket ticket, Wallet wallet) {
    	this.ticket=ticket;
    	this.wallet=wallet;
    }

    /**
     * 
     */
    //CREATE
    //////////////1
    public static void CreateValues(int i, int n_lines) {
    	
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
					
		try {
			//42 capitals
			String [] cities = {"Oporto", "Lisbon", "Amsterdam", "Athens", "Belgrade", "Berlin", "Bern", "Bratislava", "Brussels", "Bucharest", "Budapest", "Chisinau", "Copenhagen", "Dublin", "Helsinki", "Kiev", "Ljubljana", "London", "Luxembourg", "Madrid", "Minsk", "Monaco", "Moscow", "Nicosia",  "Oslo", "Paris", "Podgorica", "Prague", "Reykjavik", "Riga", "Rome", "Saravejo", "Skopje", "Sofia", "Stockholm", "Tallinn", "Vaduz", "Valletta", "Vienna", "Vilnius", "Warsaw", "Zagreb" }; 
			String [] classes= {"Economy", "Business", "First" };
			//10companies
			String [] companies= {"Ryanair", "Lufthansa", "Air France", "International Airlines", "Turkish Airlines", "Aeroflot", "Easyjet", "SAS", "Wizz Air", "TAP Air"};
			
			Random r =new Random();
			//Loop
			while(i<n_lines+1) {
				//different cities
				int city1 = r.nextInt(42);
				int city2 = r.nextInt(42);
				while(city1==city2) {
					city2 = r.nextInt(42);
					System.out.println("stuck here?");
				}
				//price
				int price = r.nextInt(1200)+50;
				
				//company
				int company=r.nextInt(10);
				//gate
				int gate = r.nextInt(41);
				//date     
				LocalDate startDate = LocalDate.now(); //start date
				long start = startDate.toEpochDay();
			    
			    LocalDate endDate = LocalDate.of(2022, 1, 15); //end date
			    long end = endDate.toEpochDay();

			    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
				   
				//Time
			    int hours_start = r.nextInt(22);
			    int hours_end = r.nextInt(24);
			    int auxiauxi=0;
			    while(hours_start>=hours_end-2 || hours_end==24) {	//minimum 2h Duration and start<end time
					hours_end = r.nextInt(24);
					hours_start = r.nextInt(22);
					System.out.println("or maybe stuck here?  "+ auxiauxi);
					auxiauxi++;
				}
			    int d_start =  r.nextInt(1);
			    int d_end =  r.nextInt(2);
			    LocalTime startTime=LocalTime.of(hours_start,d_start*30);
			    LocalTime endTime=LocalTime.of(hours_end,d_end*30);
				    		
				String sql = "INSERT INTO flights (Flight_id, Source, Destination, departure_time, arrival_time, Date, Class, Price, Company, Gate) "
					+ "		VALUES (?,?,?,?,?,?,?,?,?,?)";
			//Insert one flight for each class
				int j=0;
				while(j<3) {
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, i);
					statement.setString(2, cities[city1]);
					statement.setString(3, cities[city2]);
					statement.setTime(4, Time.valueOf(startTime));
					statement.setTime(5, Time.valueOf(endTime));
					statement.setDate(6, Date.valueOf(LocalDate.ofEpochDay(randomEpochDay)));
					statement.setString(7, classes[j]);
					statement.setInt(8, price+j*100);
					statement.setString(9, companies[company]);
					statement.setInt(10, gate);
				
					int rows = statement.executeUpdate();
					if(rows>0) {
						//System.out.println("Inserted");
					}
					j++;
					i++;
				}						
			}
			//connection.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
    
    //DELETE
    //////////////1
    public static void Delete(int n) {
		Connection connection=null;
		Statement statement=null;
		
		Database obj_Connect=new Database();
		connection=obj_Connect.get_connection();
		
		int i=1;
		while(i<n+1) {
			try {
				String query="delete from" + " flights " + "where flight_id=" + i;
				statement=connection.createStatement();
				
				statement.executeUpdate(query);
				//System.out.println("Deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}	
	}
	
    //////////////2
	public static void Delete_single_flight(int flight_id) {
		Connection connection=null;
		Statement statement=null;
		
		Database obj_Connect=new Database();
		connection=obj_Connect.get_connection();
		
		try {
				String query="delete from" + " flights " + "where flight_id=" + flight_id;
				statement=connection.createStatement();
				
				statement.executeUpdate(query);
				//System.out.println("Deleted");
				
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
    
    //INSERT
    //////////////1
    public static void Insert_Flight(int id, String Source, String Destination, LocalTime departure_time, LocalTime arrival_time, Date Date, int Price) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
			Random r =new Random();
			
			String [] classes= {"Economy", "Business", "First" };
			//10companies
			String [] companies= {"Ryanair", "Lufthansa", "Air France", "International Airlines", "Turkish Airlines", "Aeroflot", "Easyjet", "SAS", "Wizz Air", "TAP Air"};
			
			
			//company
			int company=r.nextInt(10);
			//gate
			int gate = r.nextInt(41);
			
			String sql = "INSERT INTO flights (Flight_id, Source, Destination, departure_time, arrival_time, Date, Class, Price, Company, Gate) "
					+ "		VALUES (?,?,?,?,?,?,?,?,?,?)";
			int j=0;
			while(j<3) {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.setString(2, Source);
				statement.setString(3, Destination);
				statement.setTime(4, Time.valueOf(departure_time));
				statement.setTime(5, Time.valueOf(arrival_time));
				//statement.setDate(6, Date.valueOf("2021-02-27"));
				statement.setDate(6, Date);
				statement.setString(7, classes[j]);
				statement.setInt(8, Price+j*100);
				statement.setString(9, companies[company]);
				statement.setInt(10, gate);
			
			//'2', @cities[5], 'Oporto', '08:30:00', '10:00:00', '2020/11/27', 'classes[3]', '220', 'companies[7]', '12')";
			
				int rows = statement.executeUpdate();
				if(rows>0) {
					//System.out.println("Inserted");
				}
				j++;
				id++;
			}
			//connection.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
    
    //////////////2
    public static void Update_Flight(int id, String Source, String Destination, LocalTime departure_time, LocalTime arrival_time, Date Date, int Price, String Company) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
			Random r =new Random();
			
			
			String sql = "UPDATE flights SET source = ?, destination = ?, departure_time = ?, arrival_time = ?, Date = ?, Price = ?, Company = ? "
					+ " WHERE flight_id = ?";
			
			
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, Source);
				statement.setString(2, Destination);
				statement.setTime(3, Time.valueOf(departure_time));
				statement.setTime(4, Time.valueOf(arrival_time));
				//statement.setDate(6, Date.valueOf("2021-02-27"));
				statement.setDate(5, Date);
				statement.setInt(6, Price);
				statement.setString(7, Company);
				statement.setInt(8, id);
			
			//'2', @cities[5], 'Oporto', '08:30:00', '10:00:00', '2020/11/27', 'classes[3]', '220', 'companies[7]', '12')";
			
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
    
    //////////////3
    public static void Insert_Flight_single(int id, String Source, String Destination, LocalTime departure_time, LocalTime arrival_time, Date Date, int Price, String Company) {
		Connection connection=null;
		Database conec = new Database();
		connection=conec.get_connection();
		
		try {
			Random r =new Random();
			
			String [] classes= {"Economy", "Business", "First" };
			
			int clas=r.nextInt(3);
			//gate
			int gate = r.nextInt(41);
			
			String sql = "INSERT INTO flights (Flight_id, Source, Destination, departure_time, arrival_time, Date, Class, Price, Company, Gate) "
					+ "		VALUES (?,?,?,?,?,?,?,?,?,?)";
			
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.setString(2, Source);
				statement.setString(3, Destination);
				statement.setTime(4, Time.valueOf(departure_time));
				statement.setTime(5, Time.valueOf(arrival_time));
				//statement.setDate(6, Date.valueOf("2021-02-27"));
				statement.setDate(6, Date);
				statement.setString(7, classes[clas]);
				statement.setInt(8, Price);
				statement.setString(9, Company);
				statement.setInt(10, gate);
			
			//'2', @cities[5], 'Oporto', '08:30:00', '10:00:00', '2020/11/27', 'classes[3]', '220', 'companies[7]', '12')";
			
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
    
    
	//QUERY
	//////////////1
	public static String[][] Query_one_way(String Source, String Destination, Date Date1, String Class) {
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		String [][] list = new String[10][10];
		
		try {
			String query="select * from flights where source='"+Source+"' and destination='"+Destination+"' and date='"+Date1+"' and class='"+Class+"'"; //where source=" + Source + "and destination=" + Destination
			//System.out.println(query);
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			
			//System.out.println("flight_id |   Source   |  Destination  |  departure_time  |  arrival_time  |   Date   |   Class   |  Price  |  Company  | Gate ");
			//Check if there are any flights matching the query
			
			boolean checker=rs.next();
			if(!checker) {
				System.out.println("NO FLIGHTS AVAILABLE");
				return list;
			}
			//Prints all matching flights
			else {
				int i=0;
				while(checker) {
					/*System.out.print(rs.getString("flight_id")+" | ");
					System.out.print(rs.getString("source")+" | ");
					System.out.print(rs.getString("destination")+" | ");
					System.out.print(rs.getString("departure_time")+" | ");
					System.out.print(rs.getTime("arrival_time")+" | ");
					System.out.print(rs.getDate("date")+" | ");
					System.out.print(rs.getString("class")+" | ");
					System.out.print(rs.getInt("price")+" | ");
					System.out.print(rs.getString("company")+" | ");
					System.out.println(rs.getInt("gate"));
					*/
					list[i][0]=rs.getString("flight_id");
					list[i][1]=rs.getString("source");
					list[i][2]=rs.getString("destination");
					list[i][3]=rs.getString("departure_time");
					list[i][4]=rs.getString("arrival_time");
					list[i][5]=rs.getString("date");
					list[i][6]=rs.getString("class");
					list[i][7]=rs.getString("price");
					list[i][8]=rs.getString("company");
					list[i][9]=rs.getString("gate");
					
					/*int j=0;
					while(j<=9) {
						System.out.print(list[i][j]+" | ");
						j++;
					}
					System.out.println();
					*/
					i++;
					checker=rs.next();
				}
				return list;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	//////////////2
	public static int Query_way_and_back_check(String Source, String Destination, Date Date1, Date Date2, String Class) {
		//return -1 if no way flight, return -2 if no return flight, return 1 if only way flight, return 2 if both flights
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		int i=0;
		
		try {
			//WAY
			String query="select * from flights where source='"+Source+"' and destination='"+Destination+"' and date='"+Date1+"' and class='"+Class+"'"; 
			//System.out.println(query);
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			
			//Check if there are any flights matching the query
			boolean checker=rs.next();
			if(!checker) {
				i=-1;
				return i;
			}
			if(checker) {
				i++;
			}
		
			//BACK
			query="select * from flights where source='"+Destination+"' and destination='"+Source+"' and date='"+Date2+"' and class='"+Class+"'"; 
			//System.out.println(query);
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			
			//Check if there are any flights matching the query
			checker=rs.next();
			if(!checker) {
				i=-2;
				return i;
			}
			if(checker) {
				i++;
				return i;
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;	
	}
	
	//////////////3
	public static String[][] Query_way_and_back(String Source, String Destination, Date Date1, Date Date2, String Class) {
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		String [][] list = new String[100][10];
		
		try {
			//WAY
			String query="select * from flights where source='"+Source+"' and destination='"+Destination+"' and date='"+Date1+"' and class='"+Class+"'"; 
			//System.out.println(query);
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			
			//System.out.println("flight_id |   Source   |  Destination  |  departure_time  |  arrival_time  |   Date   |   Class   |  Price  |  Company  | Gate ");
			//Check if there are any flights matching the query
			boolean checker=rs.next();
			if(!checker) {
				System.out.println("NO FLIGHTS AVAILABLE");
				return null;
			}
			//Prints all matching flights
			int i=0;
			while(checker) {
				/*System.out.print(rs.getString("flight_id")+" | ");
				System.out.print(rs.getString("source")+" | ");
				System.out.print(rs.getString("destination")+" | ");
				System.out.print(rs.getString("departure_time")+" | ");
				System.out.print(rs.getTime("arrival_time")+" | ");
				System.out.print(rs.getDate("date")+" | ");
				System.out.print(rs.getString("class")+" | ");
				System.out.print(rs.getInt("price")+" | ");
				System.out.print(rs.getString("company")+" | ");
				System.out.println(rs.getInt("gate"));
				*/
				list[i][0]=rs.getString("flight_id");
				list[i][1]=rs.getString("source");
				list[i][2]=rs.getString("destination");
				list[i][3]=rs.getString("departure_time");
				list[i][4]=rs.getString("arrival_time");
				list[i][5]=rs.getString("date");
				list[i][6]=rs.getString("class");
				list[i][7]=rs.getString("price");
				list[i][8]=rs.getString("company");
				list[i][9]=rs.getString("gate");
				
				checker=rs.next();
				i++;
			}
			//BACK
			query="select * from flights where source='"+Destination+"' and destination='"+Source+"' and date='"+Date2+"' and class='"+Class+"'"; 
			//System.out.println(query);
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			
			//Check if there are any flights matching the query
			checker=rs.next();
			if(!checker) {
				System.out.println("NO FLIGHTS AVAILABLE2");
			}
			//Prints all matching flights
			
			while(checker) {
				
				list[i][0]=rs.getString("flight_id");
				list[i][1]=rs.getString("source");
				list[i][2]=rs.getString("destination");
				list[i][3]=rs.getString("departure_time");
				list[i][4]=rs.getString("arrival_time");
				list[i][5]=rs.getString("date");
				list[i][6]=rs.getString("class");
				list[i][7]=rs.getString("price");
				list[i][8]=rs.getString("company");
				list[i][9]=rs.getString("gate");
				
				checker=rs.next();
				i++;
			}
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[][] Query_flight_id(int Flight_id) {
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		String [][] list = new String[100][10];
		
		try {
			String query="select * from flights where flight_id='"+Flight_id+"'"; //where source=" + Source + "and destination=" + Destination
			//System.out.println(query);
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			
			//System.out.println("flight_id |   Source   |  Destination  |  departure_time  |  arrival_time  |   Date   |   Class   |  Price  |  Company  | Gate ");
			//Check if there are any flights matching the query
			
			boolean checker=rs.next();
			if(!checker) {
				System.out.println("NO FLIGHTS AVAILABLE");
				return list;
			}
			//Prints all matching flights
			else {
				int i=0;
				while(checker) {
					/*System.out.print(rs.getString("flight_id")+" | ");
					System.out.print(rs.getString("source")+" | ");
					System.out.print(rs.getString("destination")+" | ");
					System.out.print(rs.getString("departure_time")+" | ");
					System.out.print(rs.getTime("arrival_time")+" | ");
					System.out.print(rs.getDate("date")+" | ");
					System.out.print(rs.getString("class")+" | ");
					System.out.print(rs.getInt("price")+" | ");
					System.out.print(rs.getString("company")+" | ");
					System.out.println(rs.getInt("gate"));
					*/
					list[i][0]=rs.getString("flight_id");
					list[i][1]=rs.getString("source");
					list[i][2]=rs.getString("destination");
					list[i][3]=rs.getString("date");
					list[i][4]=rs.getString("departure_time");
					list[i][5]=rs.getString("arrival_time");			
					list[i][6]=rs.getString("price");
					list[i][7]=rs.getString("company");
					
					
					int j=0;
					//while(j<=9) {
						//System.out.print(list[i][j]+" | ");
						//j++;
					//}
					//System.out.println();
					i++;
					checker=rs.next();
				}
				return list;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public static String[][] Query_flight_admin(String Source, String Destination, String Date) {
		Connection connection=null;
		Statement statemnt=null;
		ResultSet rs=null;
		//query for manage flights
		
		Database conec = new Database();
		connection=conec.get_connection();
		
		String [][] list = new String[100][10];
		
		try {
			String query="select * from flights where source='"+Source+"' and destination='"+Destination+"' and date='"+Date+"'"; //where source=" + Source + "and destination=" + Destination
			//System.out.println(query);
			statemnt=connection.createStatement();
			rs=statemnt.executeQuery(query);
			
			//System.out.println("flight_id |   Source   |  Destination  |  departure_time  |  arrival_time  |   Date   |   Class   |  Price  |  Company  | Gate ");
			//Check if there are any flights matching the query
			
			boolean checker=rs.next();
			if(!checker) {
				System.out.println("NO FLIGHTS AVAILABLE");
				return list;
			}
			//Prints all matching flights
			else {
				int i=0;
				while(checker) {
					System.out.print(rs.getString("flight_id")+" | ");
					System.out.print(rs.getString("source")+" | ");
					System.out.print(rs.getString("destination")+" | ");
					System.out.print(rs.getString("departure_time")+" | ");
					System.out.print(rs.getTime("arrival_time")+" | ");
					System.out.print(rs.getDate("date")+" | ");
					System.out.print(rs.getString("class")+" | ");
					System.out.print(rs.getInt("price")+" | ");
					System.out.print(rs.getString("company")+" | ");
					System.out.println(rs.getInt("gate"));
					
					list[i][0]=rs.getString("flight_id");
					list[i][1]=rs.getString("source");
					list[i][2]=rs.getString("destination");
					list[i][3]=rs.getString("date");
					list[i][4]=rs.getString("departure_time");
					list[i][5]=rs.getString("arrival_time");			
					list[i][6]=rs.getString("price");
					list[i][7]=rs.getString("company");
					
					
					int j=0;
					//while(j<=9) {
						//System.out.print(list[i][j]+" | ");
						//j++;
					//}
					//System.out.println();
					i++;
					checker=rs.next();
				}
				return list;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	
}