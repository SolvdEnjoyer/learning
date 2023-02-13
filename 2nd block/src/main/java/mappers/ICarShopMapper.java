package mappers;

import java.util.List;

import model.CarShop;

public interface ICarShopMapper extends IBaseMapper<CarShop> {
	List<CarShop> getALLEntities();
}
