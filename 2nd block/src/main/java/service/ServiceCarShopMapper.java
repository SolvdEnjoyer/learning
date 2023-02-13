package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mappers.ICarShopMapper;
import model.CarShop;
import utils.MyBatisUtil;

public class ServiceCarShopMapper implements ICarShopMapper {

	@Override
	public void deleteEntity(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("deleteCarShop",id);
		session.commit();
		session.close();
	}

	@Override
	public void insertEntity(CarShop object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.insert("insertCarShop",object);
		session.commit();
		session.close();
	}

	@Override
	public void updateEntity(CarShop object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("updateCarShop",object);
		session.commit();
		session.close();
	}

	@Override
	public List<CarShop> getALLEntities() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		List<CarShop> carShopList =session.selectList("selectAllCarShop");
		session.commit();
		session.close();
		return carShopList;
	}



}




