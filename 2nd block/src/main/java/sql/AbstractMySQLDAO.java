package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractMySQLDAO {
    private static final Logger LOGGER = LogManager.getLogger(AbstractMySQLDAO.class);
    void createClass() {
        try {
            
			Class c = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e){
            LOGGER.error(e.getMessage());
        }
    }
}
