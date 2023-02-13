package jdbcinterfaces;

import java.util.List;

import model.Customer;

public interface ICustomerDAO extends IBaseDAO<Customer>{
	
	List<Customer> getAll();
}
