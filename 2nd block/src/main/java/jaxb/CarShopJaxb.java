package jaxb;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbcimplementation.CarShopDAO;
import model.CarShop;

public class CarShopJaxb {

	private static final Logger LOGGER = LogManager.getLogger(CarShop.class); 
	private String path;
	public CarShopJaxb(String path) {
		this.path = path;
		
	}
	
	public void marshall(long id) {
		
		
		CarShopDAO CarShopDAO = new CarShopDAO();
		CarShop CarShop = CarShopDAO.getById(id);
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(CarShop.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(CarShop, System.out);
			marshaller.marshal(CarShop, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}
		
	}
	
	public void marshall(CarShop CarShop) {
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(CarShop.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(CarShop, System.out);
			marshaller.marshal(CarShop, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}	
	}
	
	public CarShop unmarshall() {
		try {
			JAXBContext jaxbcont = JAXBContext.newInstance(CarShop.class);
			Unmarshaller unmarshaller = jaxbcont.createUnmarshaller();
			CarShop CarShop=(CarShop)unmarshaller.unmarshal(new File(path));
			return CarShop;
			
			
		} catch (JAXBException e) {
			LOGGER.error(e);
		}
		return null;
	}
}