import java.sql.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi, its me!");
		
		String url = "jdbc:mysql://localhost:3306/rpg";
		String username = "root";
		String password = "password";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    
		 // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM skills";

		      // create the java statement
		      Statement st = connection.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int tier = rs.getInt("tier");
		        int mod_str = rs.getInt("mod_str");
		        int mod_int = rs.getInt("mod_int");
		        int mod_wis = rs.getInt("mod_wis");
		        String name = rs.getString("name");
		        String descrip = rs.getString("description");
		        
		        // print the results
		        System.out.format("%s %s %s %s %s %s",name,descrip,tier,mod_str,mod_int,mod_wis);
		      }
		      st.close();
		    
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}
