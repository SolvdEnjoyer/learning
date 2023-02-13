package jaxb;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbcimplementation.CarDAO;
import model.Car;

public class CarJaxb {

	private static final Logger LOGGER = LogManager.getLogger(CarJaxb.class); 
	private String path;
	public CarJaxb(String path) {
		this.path = path;
		
	}
	
	public void marshall(long id) {
		
		
		CarDAO cardao = new CarDAO();
		Car car = cardao.getById(id);
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Car.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(car, System.out);
			marshaller.marshal(car, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}
		
	}
	
	public void marshall(Car car) {
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Car.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(car, System.out);
			marshaller.marshal(car, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}	
	}
	
	public Car unmarshall() {
		try {
			JAXBContext jaxbcont = JAXBContext.newInstance(Car.class);
			Unmarshaller unmarshaller = jaxbcont.createUnmarshaller();
			Car car=(Car)unmarshaller.unmarshal(new File(path));
			return car;
			
			
		} catch (JAXBException e) {
			LOGGER.error(e);
		}
		return null;
	}
}