package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mappers.IDriverMapper;
import model.Driver;
import utils.MyBatisUtil;

public class ServiceDriverMapper implements IDriverMapper {

	@Override
	public void deleteEntity(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("deleteDriver",id);
		session.commit();
		session.close();
	}

	@Override
	public void insertEntity(Driver object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.insert("insertDriver",object);
		session.commit();
		session.close();
	}

	@Override
	public void updateEntity(Driver object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("updateDriver",object);
		session.commit();
		session.close();
	}

	@Override
	public List<Driver> getALLEntities() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		List<Driver> driverList =session.selectList("selectAllDriver");
		session.commit();
		session.close();
		return driverList;
	}



}




