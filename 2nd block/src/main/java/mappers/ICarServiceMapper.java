package mappers;

import java.util.List;

import model.CarService;

public interface ICarServiceMapper extends IBaseMapper<CarService> {
	List<CarService> getALLEntities();
}
