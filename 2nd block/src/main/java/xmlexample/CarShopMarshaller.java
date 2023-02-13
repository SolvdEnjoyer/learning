package xmlexample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;	

public class CarShopMarshaller {
    public void marshall(CarShop school,String fileName){
        try {
            JAXBContext context = JAXBContext.newInstance(CarShop.class);
            Marshaller mar= context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(school, new File(".//src//main//resources//"+fileName+".xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public CarShop unMarshall(String fileName){
        try{
            JAXBContext context = JAXBContext.newInstance(CarShop.class);
            return (CarShop) context.createUnmarshaller()
                    .unmarshal(new FileReader(".//src//main//resources//"+fileName+".xml"));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
