package mappers;

import java.util.List;

import model.Car;


public interface ICarMapper extends IBaseMapper<Car> {

	List<Car> getALLEntities();
}
