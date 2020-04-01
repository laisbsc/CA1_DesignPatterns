import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The code on this class was adapted from the source code uploaded
 * by Amilcar Pontes on Moodle under Week 5.
 * Class responsible for handling the requests and responses from the DB.
 */
public class DataSource {
	
	private String db = "jdbc:mysql://apontejaj.com:3306/world";
	private String un = "cctstudent";
	private String pw = "Pass1234!";

	private Connection conn;
	private Statement stmt;
	private ResultSet rs = null;

	/**
	 * this class should have at least two methods, one to retrieve data from the DB
	 * and another to add data to the DB
	 */
	public DataSource() {
		try{
			// Connect to the database
			conn = DriverManager.getConnection( db, un, pw ) ;

			// Generate a statement from the connection
			stmt = conn.createStatement();

			// Loop through the result set printing the columns of the table
			while (rs.next() ){
				System.out.println( rs.getInt(1) + "\t" + rs.getString(2) +
				"\t" + Continent.valueOf(rs.getString(3)) + "\t" + rs.getLong(4) + "\t" + rs.getString(5));
			}

		} catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( rs != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch(Exception e){
			System.out.println( e ) ;
		}
	}

	/**
	 * Method reponsible for adding statements into the DB
	 * @param query
	 */
	public boolean save(String query){
		try {
			stmt.execute(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method responsible for the SELECT query to the DB
	 * @param query
	 * @return resultSet Object
	 */
	public ResultSet select(String query){
		try{
			// Execute the MySQL fetch query
			rs = stmt.executeQuery(query);
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
		return rs;
	}

	/**
	 * Closes the connection, the statement and the result set when the query is finished.
	 */
	public void closing(){
		//deals w DB so it needs to be inside a try/catch [VSCode doesn't ask for it, though]
		try {
			rs.close() ;
			stmt.close() ;
			conn.close() ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}