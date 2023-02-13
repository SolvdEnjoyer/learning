package jdbcimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connectionpool.ConnectionPool;
import jdbcinterfaces.ICustomerDAO;
import model.Customer;
import sql.AbstractMySQLDAO;

public class CustomerDAO extends AbstractMySQLDAO implements ICustomerDAO{
	
	private static final Logger logger = LogManager.getLogger(CustomerDAO.class);
	
	@Override
	public void create(Customer object) {
		
		PreparedStatement ps = null;
		
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO Customer (id,first_name,last_name,is_driver) VALUES (?,?,?,?)");
			ps.setLong(1, object.getId());
			ps.setString(2, object.getFirstName());
			ps.setString(3, object.getLastName());
			ps.setBoolean(4, object.getIsDriver());
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
	public Customer getById(Long id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("SELECT FROM * FROM Customer WHERE id=?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			return new Customer(id,rs.getString("first_name"),rs.getString("last_name"),rs.getBoolean("is_driver"));
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
			ps = ConnectionPool.getInstance().retrieve().prepareStatement("DELETE  FROM Customer WHERE id=?");
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
	public void update(Customer object) {
        PreparedStatement ps=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("UPDATE Customer SET first_name=?,last_name=?,is_driver=? WHERE id=?");
            ps.setString(1,object.getFirstName());
            ps.setString(2,object.getLastName());
            ps.setBoolean(3, object.getIsDriver());
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
	public List<Customer> getAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("SELECT COUNT(*) FROM Customer");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Customer> customers = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
                customers.add(getById(i));
            }
            return customers;
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
