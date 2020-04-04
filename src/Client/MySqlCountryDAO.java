package Client;
import java.util.ArrayList;
import Country.Continent;
import Country.Country;
import Country.CountryDAO;
import Database.DataSource;
import java.sql.*;

/**
 * Client class. Allows different classes to instantiate the
 * database without connecting directly to the database.  
 */

public class MySqlCountryDAO implements CountryDAO {

    DataSource db = SingletonInstance.getInstance();

    /**
     * Returns an ArrayList of all the Countries in the database
     * @returns arrayList of country Objects
     */
    @Override
    public ArrayList<Country> getCountries() {

        ArrayList<Country> countries = new ArrayList<Country>();
        String query = "SELECT * FROM country"; // MySQL query
        DataSource db = SingletonInstance.getInstance();
        ResultSet rs = db.select(query); //catch the ResultSet and place the query result there
        
        String code = "";
        String name = "";
        Continent continent = null;
        long surfaceArea = 0;
        String headOfState = "";
        Country c;

        // loop over the resultSet to fill ArrayList w results
        try {
            while (rs.next()) {
                code = rs.getString(1); // don't quite get it why starts at 1
                name = rs.getString(2);
                continent = Continent.getEnum(rs.getString(3));
                surfaceArea = rs.getLong(4);
                headOfState = rs.getString(5);

                //builder pattern here > single class not subclass that has multiple attributes
                c = new Country.CountryBuilder(code, name, continent, surfaceArea, headOfState).build(); //new instance of Country class
                countries.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return countries;
	}

	@Override
	public Country findCountryByCode(String queryKey) {
		
        String query = "SELECT * FROM country WHERE code = '"+ queryKey+"';"; // MySQL query
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how this works

        String code = "";
        String name = "";
	    Continent continent;
	    long surfaceArea = 0;
        String headOfState = "";
        Country c; 

        //if resultSet is not empty, point to the next variable and fill with search result
        try {
            while (rs.next() == true) { //if the result set has some data in it, populate the other parameters
            	code = rs.getString(1);
            	name = rs.getString(2);
                continent = Continent.getEnum(rs.getString(3));
                surfaceArea = rs.getLong(4);
                headOfState = rs.getString(5);

                c = new Country.CountryBuilder(code, name, continent, surfaceArea, headOfState).build(); //create a new instance of Country class
                return c; //returns the instance of the country just searched
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }db.closing();
		return null;
    }

	/**
     * Method that selects all rows with the string searched in its name
     * not fully implemented > should return an arrayList of countries 
     * @param String name
     * @return countries ArrayList
     */
	@Override
	public ArrayList<Country> findCountryByName(String queryKey) {
		ArrayList<Country> countries = new ArrayList<Country>();
		
		String query = "SELECT * FROM country WHERE name LIKE '%"+ queryKey+"%';"; // MySQL query selecting rows w name typed
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how this works

        // loop over the resultSet to fill ArrayList w results
        String code = "";
        String name = "";
	    Continent continent = null;
	    long surfaceArea = 0;
        String headOfState = "";
        Country c;
        
        try {
            while (rs.next() == true) { //if there is a next number, populate the other parameters
            	code = rs.getString(1);
            	name = rs.getString(2);
                continent =  Continent.getEnum(rs.getString(3));
                surfaceArea = rs.getLong(4);
                headOfState = rs.getString(5);

                c = new Country.CountryBuilder(code, name, continent, surfaceArea, headOfState).build(); //new instance of Country class
                countries.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return countries;
	}
	
    /**
    * Unwrap the data from Country Object and add the new Object to db
    */
	@Override
	public boolean saveCountry(Country countries) {
		String code = countries.getCode();
		String name = countries.getName();
	    Continent continent = countries.getContinent();
	    long surfaceArea = countries.getSurfaceArea();
        String headOfState = countries.getHeadOfState();

        String query = "INSERT INTO country (code, name, continent, surfaceArea, headOfState) VALUES('"+code+"','"+name+"', '"+continent+"', "+surfaceArea+",'"+headOfState+"');";
        return db.save(query);
	}
}

