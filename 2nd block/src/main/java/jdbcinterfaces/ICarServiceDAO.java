package jdbcinterfaces;

import java.util.List;

import model.CarService;

public interface ICarServiceDAO extends IBaseDAO<CarService>{

	List<CarService> getAll();
}
