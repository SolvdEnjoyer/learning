package jdbcimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connectionpool.ConnectionPool;
import jdbcinterfaces.IDetailDAO;
import model.Detail;
import sql.AbstractMySQLDAO;

public class DetailDAO extends AbstractMySQLDAO implements IDetailDAO {

	private static final Logger logger = LogManager.getLogger(DetailDAO.class);
	@Override
	public void create(Detail object) {
		
		PreparedStatement ps = null;
		
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO Customer (id,type) VALUES (?,?)");
			ps.setLong(1, object.getId());
			ps.setString(2, object.getType());
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
	public Detail getById(Long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT FROM * FROM Detail WHERE id=?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			return new Detail(id,rs.getString("type"));
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
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("DELETE  FROM Detail WHERE id=?");
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
	public void update(Detail object) {
        PreparedStatement ps=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("UPDATE Detail SET type=? WHERE id=?");
            ps.setString(1,object.getType());
            ps.setLong(2,object.getId());
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
	public List<Detail> getAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("SELECT COUNT(*) FROM Detail");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Detail> details = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
                details.add(getById(i));
            }
            return details;
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
