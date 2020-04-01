/**
 * Defines the methods that the implementation must have.
 * Interface class implemented by MySqlCountryDAO.class.
 */
import java.util.ArrayList;

/**
 * @author AmilcarAponte - modified by Lais Carvalho
 * @date 23/03/2020
 */
public interface CountryDAO {

	public ArrayList<Country> getCountries(); //connection between client & DB
	public Country findCountryByCode(String code);
	public Country findCountryByname(String name); //search method > inclusive. should return an arrayList of countries
	public boolean saveCountry(Country customer);
	
}
