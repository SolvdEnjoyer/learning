package jaxb;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbcimplementation.CustomerDAO;
import model.Customer;

public class CustomerJaxb {

	private static final Logger LOGGER = LogManager.getLogger(Customer.class); 
	private String path;
	public CustomerJaxb(String path) {
		this.path = path;
		
	}
	
	public void marshall(long id) {
		
		
		CustomerDAO CustomerDAO = new CustomerDAO();
		Customer Customer = CustomerDAO.getById(id);
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(Customer, System.out);
			marshaller.marshal(Customer, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}
		
	}
	
	public void marshall(Customer Customer) {
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(Customer, System.out);
			marshaller.marshal(Customer, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}	
	}
	
	public Customer unmarshall() {
		try {
			JAXBContext jaxbcont = JAXBContext.newInstance(Customer.class);
			Unmarshaller unmarshaller = jaxbcont.createUnmarshaller();
			Customer Customer=(Customer)unmarshaller.unmarshal(new File(path));
			return Customer;
			
			
		} catch (JAXBException e) {
			LOGGER.error(e);
		}
		return null;
	}
}