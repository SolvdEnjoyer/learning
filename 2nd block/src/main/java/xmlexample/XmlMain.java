package xmlexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class XmlMain {
    private static final Logger LOGGER = LogManager.getLogger(XmlMain.class);
    public static void main(String[] args){
       ArrayList<String> cars = new ArrayList<>();
        cars.add("BMV");
        cars.add("Audi");
        CarShop carShop = new CarShop("Local Car Shop",cars,123);

        CarShopMarshaller carShopMarshaller = new CarShopMarshaller();
        carShopMarshaller.marshall(carShop,"myCarShop");

        CarShop carShop2=carShopMarshaller.unMarshall("myCarShop");
        LOGGER.info(carShop2);
    }
}