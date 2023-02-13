package mappers;

import java.util.List;

import model.Detail;

public interface IDetailMapper extends IBaseMapper<Detail> {
	List<Detail> getALLEntities();
}
