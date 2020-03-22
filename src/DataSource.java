import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataSource {
	
	private String db = "jdbc:mysql://apontejaj.com:3306/customer";
	private String un = "cctstudent";
	private String pw = "Pass1234!";
	
	public DataSource() {
		
		try{
			
			// Get a connection to the database
			Connection conn = DriverManager.getConnection( db, un, pw ) ;

			// Get a statement from the connection
			Statement stmt = conn.createStatement() ;

			// Execute the query
			ResultSet rs = stmt.executeQuery( "SELECT * FROM customer" ) ;

			// Loop through the result set
			while( rs.next() )
				System.out.println( rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)) ;

			// Close the result set, statement and the connection
			rs.close() ;
			stmt.close() ;
			conn.close() ;
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
	}

}
