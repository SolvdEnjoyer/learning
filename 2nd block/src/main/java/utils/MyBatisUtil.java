package utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisUtil {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisUtil.class);

	
		private static SqlSessionFactory sessionFactory ;
		 
		static {
			Reader reader;
			String resource = "mybatis-config.xml";
				try {
					reader = Resources.getResourceAsReader(resource);
					sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					
				} catch (IOException e) {
					e.printStackTrace();
					LOGGER.error(e);
				}
				
			
		}
		
		public static SqlSessionFactory getSqlSessionFactory() {
			return	sessionFactory;
		}
}