package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mappers.ICarServiceMapper;
import model.CarService;
import utils.MyBatisUtil;

public class ServiceCarServiceMapper implements ICarServiceMapper {

	@Override
	public void deleteEntity(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("deleteCarService",id);
		session.commit();
		session.close();
	}

	@Override
	public void insertEntity(CarService object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.insert("insertCarService",object);
		session.commit();
		session.close();
	}

	@Override
	public void updateEntity(CarService object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("updateCarService",object);
		session.commit();
		session.close();
	}

	@Override
	public List<CarService> getALLEntities() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		List<CarService> carServiceList =session.selectList("selectAllCarService");
		session.commit();
		session.close();
		return carServiceList;
	}



}




