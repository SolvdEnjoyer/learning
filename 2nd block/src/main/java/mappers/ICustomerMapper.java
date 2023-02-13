package mappers;

import java.util.List;

import model.Customer;

public interface ICustomerMapper extends IBaseMapper<Customer> {
	List<Customer> getALLEntities();
}
