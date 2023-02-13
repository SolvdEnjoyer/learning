package jdbcimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connectionpool.ConnectionPool;
import jdbcinterfaces.ICarServiceDAO;
import model.CarService;
import sql.AbstractMySQLDAO;

public class CarServiceDAO extends AbstractMySQLDAO implements ICarServiceDAO{

	private static final Logger logger=LogManager.getLogger(CarServiceDAO.class);
	
	@Override
	public void create(CarService object) {
		PreparedStatement ps=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO Car_Service (id,name,location) VALUES(?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getName());
            ps.setString(3,object.getLocation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        } finally{
            try {
                ps.close();
            } catch (SQLException e) {
                logger.error(e);
                e.printStackTrace();
            }
        }
	}

	
	
	@Override
	public CarService getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT * FROM Car_service WHERE id=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new CarService(id,rs.getString("name"),rs.getString("location"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
		return null;
	}

	@Override
	public void remove(Long id) {
        PreparedStatement ps = null;
        try {
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM Car_service WHERE id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            logger.error(e);
        }finally {
            try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.error(e);
            }
        }
	}

	@Override
	public void update(CarService object) {
        PreparedStatement ps=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("UPDATE Car_service SET name=?,location=? WHERE id=?");
            ps.setString(1,object.getName());
            ps.setString(2,object.getLocation());
            ps.setLong(3,object.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn(e);
        }finally {
            try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.error(e);
            }
        }
	}

	@Override
	public List<CarService> getAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT COUNT(*) FROM Car_service");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<CarService> carServices = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
            	carServices.add(getById(i));
            }
            return carServices;
        }catch (SQLException e){
            e.printStackTrace();
            logger.warn(e);
        }finally {
            try{
                rs.close();
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.warn(e);
            }
        }
		return null;
	}

}
