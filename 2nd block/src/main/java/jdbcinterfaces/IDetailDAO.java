package jdbcinterfaces;

import java.util.List;

import model.Detail;

public interface IDetailDAO extends IBaseDAO<Detail> {
	
	List<Detail> getAll();
}
