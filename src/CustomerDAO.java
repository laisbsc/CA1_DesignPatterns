import java.util.ArrayList;

public interface CustomerDAO {

	public ArrayList<Customer> getCustomers();
	public Customer findCustomerById(int id);
	public boolean saveCustomer(Customer customer);
	
}
