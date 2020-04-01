import java.util.ArrayList;
import java.sql.*;

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
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how
                                         // this works
        String code = "";
        String name = "";
        Continent continent = null;
        long surfaceArea = 0;
        String headOfState = "";
        Country c = null;

        // loop over the resultSet to fill ArrayList w results
        try {
            while (rs.next()) {
                code = rs.getString(1); // don't quite get it why starts at 1
                name = rs.getString(2);
                continent = Continent.valueOf(rs.getString(3));
                surfaceArea = rs.getLong(4);
                headOfState = rs.getString(5);

                //builder pattern here > sinlge class not subclass that has multiple attributes
                c = new Country(code, name, continent, surfaceArea, headOfState); //new instance of Country class
                countries.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return countries;
	}

	@Override
	public Country findCountryByCode(String code) {

        String query = "SELECT * FROM country WHERE code = "+ code +";"; // MySQL query
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how this works

        // loop over the resultSet to fill ArrayList w results
	    String name = "";
	    Continent continent = null;
	    long surfaceArea = 0;
        String headOfState = "";
        Country c = null; 
        
        try {
            if (rs.next()) { //if the result set has some data in it, populate the other parameters
                name = rs.getString(1);
                continent = Continent.valueOf(rs.getString(3));
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
     * Method that selects all rows with the string searched in its name
     * not fully implemented > should return an arrayList of countries 
     */
	@Override
	public Country findCountryByname(String name) {

        ArrayList<Country> countriesByName = new ArrayList<Country>(); // arrayList is still empty here
		String query = "SELECT * FROM country WHERE name = "+ name +";"; // MySQL query selecting rows w name typed
        ResultSet rs = db.select(query); // catch the ResultSet and place the result of the query there - not sure how this works

        // loop over the resultSet to fill ArrayList w results
	    Continent continent = null;
	    long surfaceArea = 0;
        String headOfState = "";
        Country c = null; 
        
        try {
            if (rs.next()) { //if there is a next number, populate the other parameters
                name = rs.getString(2);
                continent = (Continent) rs.getObject(3);
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
	    Continent continent = countries.getContinent();
	    long surfaceArea = countries.getSurfaceArea();
        String headOfState = countries.getHeadOfState();

        String query = "INSERT INTO country (name, continent, surfaceArea, headOfState) VALUES('"+name+"', '"+continent+"', '"+surfaceArea+"','"+headOfState+"');";

        return db.save(query);
	}
    
}