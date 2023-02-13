package jdbcimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connectionpool.ConnectionPool;
import jdbcinterfaces.IDetailsShopDAO;
import model.DetailsShop;
import sql.AbstractMySQLDAO;

public class DetailsShopDAO extends AbstractMySQLDAO implements IDetailsShopDAO{

	private static final Logger logger = LogManager.getLogger(DetailsShopDAO.class);
	
	@Override
	public void create(DetailsShop object) {
		
		PreparedStatement ps = null;
		
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO DetailsShop (id,name,location) VALUES (?,?,?)");
			ps.setLong(1, object.getId());
			ps.setString(2, object.getName());
			ps.setString(3, object.getLocation());
	
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
	public DetailsShop getById(Long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT FROM * FROM DetailsShop WHERE id=?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			return new DetailsShop(id,rs.getString("name"),rs.getString("location"));
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
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("DELETE  FROM DetailsShop WHERE id=?");
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
	public void update(DetailsShop object) {
        PreparedStatement ps=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("UPDATE DetailsShop SET name=?,location=? WHERE id=?");
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
	public List<DetailsShop> getAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("SELECT COUNT(*) FROM DetailsShop");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<DetailsShop> detailsShops = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
                detailsShops.add(getById(i));
            }
            return detailsShops;
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
