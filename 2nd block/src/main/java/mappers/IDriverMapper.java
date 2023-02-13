package mappers;

import java.util.List;

import model.Driver;

public interface IDriverMapper extends IBaseMapper<Driver> {
	List<Driver> getALLEntities();
}
