package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mappers.ICustomerMapper;
import model.Customer;
import utils.MyBatisUtil;

public class ServiceCustomerMapper implements ICustomerMapper {

	@Override
	public void deleteEntity(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("deleteCustomer",id);
		session.commit();
		session.close();
	}

	@Override
	public void insertEntity(Customer object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.insert("insertCustomer",object);
		session.commit();
		session.close();
	}

	@Override
	public void updateEntity(Customer object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("updateCustomer",object);
		session.commit();
		session.close();
	}

	@Override
	public List<Customer> getALLEntities() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		List<Customer> customerList =session.selectList("selectAllCustomer");
		session.commit();
		session.close();
		return customerList;
	}



}




