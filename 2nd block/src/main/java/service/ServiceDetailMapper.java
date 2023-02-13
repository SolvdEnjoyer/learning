package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mappers.IDetailMapper;
import model.Detail;
import utils.MyBatisUtil;

public class ServiceDetailMapper implements IDetailMapper {

	@Override
	public void deleteEntity(Long id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("deleteDetail",id);
		session.commit();
		session.close();
	}

	@Override
	public void insertEntity(Detail object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.insert("insertDetail",object);
		session.commit();
		session.close();
	}

	@Override
	public void updateEntity(Detail object) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		session.update("updateDetail",object);
		session.commit();
		session.close();
	}

	@Override
	public List<Detail> getALLEntities() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		List<Detail> detailList =session.selectList("selectAllDetail");
		session.commit();
		session.close();
		return detailList;
	}



}




