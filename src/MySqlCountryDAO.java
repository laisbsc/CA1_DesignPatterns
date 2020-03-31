import java.util.ArrayList;
import java.sql.*;

public class MySqlCountryDAO implements CountryDAO {

    private static DataSource db;

    /**
     * Thread safe singleton implementation to instantiate the connection from this class to teh MySQL database
     * @return databaseInstance
     */
    public static synchronized DataSource getInstance(){
        if(db == null){
            db = new DataSource(); // stablishing connection to the db
        }
        return db;
    }

    /**
     * Returns an ArrayList of all the Countries in the database
     * @returns arrayList of country Objects 
     */
    @Override
    public ArrayList<Country> getCountries() {

        ArrayList<Country> countries = new ArrayList<Country>(); // arrayList is still empty here
        String query = "SELECT * FROM world"; // MySQL query
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how this works

        // loop over the resultSet to fill ArrayList w results
        int code = 0;
	    String name = "";
	    String continent = "";
	    long surfaceArea = 0;
        String headOfState = "";
        Country c = null; 
        
        try {
            while (rs.next()) {
                code = rs.getInt(1); //flag here cuz the int must be 1 - column(0) is unique ID
                name = rs.getString(2);
                continent = rs.getString(3);
                surfaceArea = rs.getLong(4);
                headOfState = rs.getString(5);

                c = new Country(code, name, continent, surfaceArea, headOfState); //new instance of Country class
                countries.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return countries;
	}

	@Override
	public Country findCountryByCode(int code) {

        String query = "SELECT * FROM world WHERE code = "+ code +";"; // MySQL query
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how this works

        // loop over the resultSet to fill ArrayList w results
	    String name = "";
	    String continent = "";
	    long surfaceArea = 0;
        String headOfState = "";
        Country c = null; 
        
        try {
            if (rs.next()) { //if the result set has some data in it, populate the other parameters
                name = rs.getString(2);
                continent = rs.getString(3);
                surfaceArea = rs.getLong(4);
                headOfState = rs.getString(5);

                c = new Country(code, name, continent, surfaceArea, headOfState); //create a new instance of Country class
                return c; //returns the instance of the country just found
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    /**
     * Method that selects all rows with 
     */
	@Override
	public Country findCountryByname(String name) {

        ArrayList<Country> countriesByName = new ArrayList<Country>(); // arrayList is still empty here
		String query = "SELECT * FROM world WHERE name = "+ name +";"; // MySQL query selecting rows w name typed
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how this works

        // loop over the resultSet to fill ArrayList w results
	    String continent = "";
	    long surfaceArea = 0;
        String headOfState = "";
        Country c = null; 
        
        try {
            if (rs.next()) { //if there is a next number, populate the other parameters
                name = rs.getString(2);
                continent = rs.getString(3);
                surfaceArea = rs.getLong(4);
                headOfState = rs.getString(5);

                c = new Country(name, continent, surfaceArea, headOfState); //new instance of Country class
                countriesByName.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
    /**
    * Unwrap the data from Country Object and dd the new Object to db
    */
	@Override
	public boolean saveCountry(Country countries) {
		String name = countries.getName();
	    String continent = countries.getContinent();
	    long surfaceArea = countries.getSurfaceArea();
        String headOfState = countries.getHeadOfState();

        String query = "INSERT INTO country (name, continent, surfaceArea, headOfState) VALUES('"+name+"', '"+continent+"', "+surfaceArea+",        '"+headOfState+"');";

        return db.save(query);
	}
    
}