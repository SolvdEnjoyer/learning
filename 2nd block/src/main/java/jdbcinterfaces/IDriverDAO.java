package jdbcinterfaces;

import java.util.List;
import model.Driver;

public interface IDriverDAO extends IBaseDAO<Driver>, IGetAll<List<Driver>> {

}
