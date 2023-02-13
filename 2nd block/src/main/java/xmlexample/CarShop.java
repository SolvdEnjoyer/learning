package xmlexample;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@XmlRootElement(name="carShop")
@XmlType(propOrder = {"name","carNumber","cars"})
public class CarShop {
	private String name;
	private List<String> cars;
	private int carNumber;

	public CarShop(String name,  List<String> cars, int carNumber) {
		this.name = name;
		this.cars = cars;
		this.carNumber = carNumber;
	}
	public CarShop() {
	}
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCars() {
		return cars;
	}
	 @XmlElement
	public void setCars(List<String> cars) {
		this.cars = cars;
	}
	public int getCarNumber() {
		return carNumber;
	}
	 @XmlElement
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	
	 
	public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", cars='" + cars + '\'' +
                ", carNumber=" + carNumber +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CarShop carShop = (CarShop) o;

        return new EqualsBuilder().append(name, carShop.name).append(cars, carShop.cars).append(carNumber, carShop.carNumber).isEquals();
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder(12, 35).append(name).append(cars).append(carNumber).toHashCode();
    }
	
	
}


