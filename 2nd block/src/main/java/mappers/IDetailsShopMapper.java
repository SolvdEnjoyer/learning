package mappers;

import java.util.List;

import model.DetailsShop;

public interface IDetailsShopMapper extends IBaseMapper<DetailsShop> {
	List<DetailsShop> getALLEntities();
}
