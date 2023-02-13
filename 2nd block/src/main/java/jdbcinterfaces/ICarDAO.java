package jdbcinterfaces;

import java.util.List;

import model.Car;

public interface ICarDAO extends IBaseDAO<Car> {
	
	List<Car> getAll();
	
}
