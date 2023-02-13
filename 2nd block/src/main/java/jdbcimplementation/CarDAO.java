package jdbcimplementation;

import java.util.List;

import model.Car;
import sql.AbstractMySQLDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connectionpool.ConnectionPool;
import jdbcinterfaces.ICarDAO;

import java.sql.*;
import java.util.ArrayList;


public class CarDAO extends AbstractMySQLDAO implements ICarDAO {
	
	private static final Logger logger=LogManager.getLogger(CarDAO.class);
	
	@Override
	public void create(Car object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO Car(id,model,vendor,driver_id,car_shop_id) VALUES(?,?,?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getModel());
            ps.setString(3,object.getVendor());
            ps.setLong(4,object.getDriverId());
            ps.setLong(5,object.getCarShopId());
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
	public Car getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT * FROM Car Where id=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Car(id,rs.getString("model"),rs.getString("vendor"),rs.getLong("driver_id"),rs.getLong("car_shop_id"));
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
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM Car where id=?");
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
	public void update(Car object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("UPDATE Car SET model=?,vendor=?,driver_id=?,car_shop_id=? where id=?");
            ps.setString(1,object.getModel());
            ps.setString(2,object.getVendor());
            ps.setLong(3,object.getDriverId());
            ps.setLong(4,object.getCarShopId());
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
	public List<Car> getAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("SELECT COUNT(*) FROM Car");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Car> cars = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
                cars.add(getById(i));
            }
            return cars;
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
