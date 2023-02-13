package jdbcinterfaces;

import java.util.List;

import model.CarShop;

public interface ICarShopDAO extends IBaseDAO<CarShop>{
	
	List<CarShop> getAll();
	
}
