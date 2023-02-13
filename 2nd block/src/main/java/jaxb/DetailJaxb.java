package jaxb;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbcimplementation.DetailDAO;
import model.Detail;

public class DetailJaxb {

	private static final Logger LOGGER = LogManager.getLogger(Detail.class); 
	private String path;
	public DetailJaxb(String path) {
		this.path = path;
		
	}
	
	public void marshall(long id) {
		
		
		DetailDAO DetailDAO = new DetailDAO();
		Detail Detail = DetailDAO.getById(id);
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Detail.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(Detail, System.out);
			marshaller.marshal(Detail, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}
		
	}
	
	public void marshall(Detail Detail) {
		
		JAXBContext jaxbcont;
		try {
			jaxbcont = JAXBContext.newInstance(Detail.class);
			Marshaller marshaller = jaxbcont.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(Detail, System.out);
			marshaller.marshal(Detail, new File(path));

		} catch (JAXBException e) {
			LOGGER.error(e);
			
		}	
	}
	
	public Detail unmarshall() {
		try {
			JAXBContext jaxbcont = JAXBContext.newInstance(Detail.class);
			Unmarshaller unmarshaller = jaxbcont.createUnmarshaller();
			Detail Detail=(Detail)unmarshaller.unmarshal(new File(path));
			return Detail;
			
			
		} catch (JAXBException e) {
			LOGGER.error(e);
		}
		return null;
	}
}