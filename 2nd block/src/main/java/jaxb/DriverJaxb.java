package jaxb;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbcimplementation.DriverDAO;
import model.Driver;

public class DriverJaxb {

	private static final Logger LOGGER = LogManager.getLogger(Driver.class); 
	private String path;
	public DriverJaxb(String path) {
		this.path = path;
		
	}
	
	public void marshall(long id) {
		
		
		DriverDAO DriverDAO = new DriverDAO();
		Driver Driver = DriverDAO.getById(id);
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Driver.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(Driver, System.out);
			marshaller.marshal(Driver, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}
		
	}
	
	public void marshall(Driver Driver) {
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Driver.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(Driver, System.out);
			marshaller.marshal(Driver, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}	
	}
	
	public Driver unmarshall() {
		try {
			JAXBContext jaxbcont = JAXBContext.newInstance(Driver.class);
			Unmarshaller unmarshaller = jaxbcont.createUnmarshaller();
			Driver Driver=(Driver)unmarshaller.unmarshal(new File(path));
			return Driver;
			
			
		} catch (JAXBException e) {
			LOGGER.error(e);
		}
		return null;
	}
}