package jdbcimplementation;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connectionpool.ConnectionPool;
import jdbcinterfaces.ICarShopDAO;
import model.CarShop;
import sql.AbstractMySQLDAO;



public class CarShopDAO extends AbstractMySQLDAO implements ICarShopDAO{

	private static final Logger Logger = LogManager.getLogger(CarShopDAO.class);
	
	@Override
	public void create(CarShop object) {
		
		PreparedStatement ps = null;
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO Car_shop (id,name,location) VALUES (?,?,?)");
			ps.setLong(1, object.getId());
			ps.setString(2, object.getName());
			ps.setString(3, object.getLocation());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.error(e);
			}
		}
		
	}

	@Override
	public CarShop getById(Long id) {
	
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT * FROM Car_shop WHERE id=?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			return new CarShop(id, rs.getString("name"), rs.getString("location"));
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.error(e);
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.error(e);
			}
		}
		return null;
	}

	@Override
	public void remove(Long id) {
		
		PreparedStatement ps = null;
		
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM Car_shop WHERE id=?");
			ps.setLong(1, id);
			ps.executeUpdate();
		}catch (Exception e) {
			 e.printStackTrace();
             Logger.error(e);
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
                e.printStackTrace();
                Logger.error(e);
			}
		}
		
	}

	@Override
	public void update(CarShop object) {
        PreparedStatement ps=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("UPDATE Car_shop SET name=?,location=? WHERE id=?");
            ps.setString(1,object.getName());
            ps.setString(2,object.getLocation());
            ps.setLong(3,object.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.warn(e);
        }finally {
            try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                Logger.error(e);
            }
        }
	}

	@Override
	public List<CarShop> getAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT COUNT(*) FROM Car_shop");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<CarShop> carShops = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
            	carShops.add(getById(i));
            }
            return carShops;
        }catch (SQLException e){
            e.printStackTrace();
            Logger.warn(e);
        }finally {
            try{
                rs.close();
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                Logger.warn(e);
            }
        }
		return null;
	}

}
