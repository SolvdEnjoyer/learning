package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mappers.ICarMapper;
import model.Car;
import utils.MyBatisUtil;

public class ServiceCarMapper implements ICarMapper {

	@Override
	public void deleteEntity(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("deleteCar",id);
		session.commit();
		session.close();
	}

	@Override
	public void insertEntity(Car object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.insert("insertCar",object);
		session.commit();
		session.close();
	}

	@Override
	public void updateEntity(Car object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("updateCar",object);
		session.commit();
		session.close();
	}

	@Override
	public List<Car> getALLEntities() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		List<Car> carList =session.selectList("selectAllCar");
		session.commit();
		session.close();
		return carList;
	}



}




