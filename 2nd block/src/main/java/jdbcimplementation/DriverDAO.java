package jdbcimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connectionpool.ConnectionPool;
import jdbcinterfaces.IDriverDAO;
import model.Driver;
import sql.AbstractMySQLDAO;

public class DriverDAO extends AbstractMySQLDAO implements IDriverDAO{

	private static final Logger logger = LogManager.getLogger(DriverDAO.class);
	@Override
	public void create(Driver object) {
		PreparedStatement ps = null;
		
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO Driver (id,first_name,last_name,license) VALUES (?,?,?,?)");
			ps.setLong(1, object.getId());
			ps.setString(2, object.getFirstName());
			ps.setString(3, object.getLastName());
			ps.setBoolean(4, object.isLicense());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		
	}

	@Override
	public Driver getById(Long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT FROM * Driver WHERE id=?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			return new Driver(id,rs.getString("first_name"),rs.getString("last_name"),rs.getBoolean("license"));
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
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
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("DELETE  FROM Driver WHERE id=?");
			ps.setLong(1, id);
			ps.executeQuery();
		} catch (SQLException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				logger.warn(e);
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void update(Driver object) {
        PreparedStatement ps=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("UPDATE Driver SET first_name=?,last_name=?,license=? WHERE id=?");
            ps.setString(1,object.getFirstName());
            ps.setString(2,object.getLastName());
            ps.setBoolean(3, object.isLicense());
            ps.setLong(4,object.getId());
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
	public List<Driver> getAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("SELECT COUNT(*) FROM DetailsShop");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Driver> drivers = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
                drivers.add(getById(i));
            }
            return drivers;
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


