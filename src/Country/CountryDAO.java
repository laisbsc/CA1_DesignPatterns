package Country;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Defines the methods that the implementation must have.
 * Interface class implemented by MySqlCountryDAO.class.
 */
public interface CountryDAO {

	public ArrayList<Country> getCountries(); //connection between client & DB
	public Country findCountryByCode(String queryKey); //searches the db ArraylList to find the result for the searched string code
	public ArrayList<Country> findCountryByName(String queryKey); //searches the db ArraylList to find all countries with searched string on their name
	public boolean saveCountry(Country country); //saves country with unique ID to database
	
}
