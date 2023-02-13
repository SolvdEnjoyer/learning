package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mappers.IDetailsShopMapper;
import model.DetailsShop;
import utils.MyBatisUtil;

public class ServiceDetailsShopMapper implements IDetailsShopMapper {

	@Override
	public void deleteEntity(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("deleteDetailsShop",id);
		session.commit();
		session.close();
	}

	@Override
	public void insertEntity(DetailsShop object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.insert("insertDetailsShop",object);
		session.commit();
		session.close();
	}

	@Override
	public void updateEntity(DetailsShop object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("updateDetailsShop",object);
		session.commit();
		session.close();
	}

	@Override
	public List<DetailsShop> getALLEntities() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		List<DetailsShop> detailsShopList =session.selectList("selectAllDetailsShop");
		session.commit();
		session.close();
		return detailsShopList;
	}



}




