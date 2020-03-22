import java.util.ArrayList;

public interface CountryDAO {

	public ArrayList<Country> getCustomers();
	public Country findCustomerByCode(int code);
	public Country findCustomerByname(String name);
	public boolean saveCustomer(Country customer);
	
}
