package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "JaxbEngine")
public class Car {
	
	private long id;
	private String model;
	private String vendor;
	private long driverId;
	private long carShopId;
	
	public Car(long id, String model, String vendor, long driverId, long carShopId) {
		this.id = id;
		this.model = model;
		this.vendor = vendor;
		this.driverId = driverId;
		this.carShopId = carShopId;
	}

	public Car() {
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", vendor=" + vendor + ", driverId=" + driverId + ", carShopId="
				+ carShopId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (carShopId ^ (carShopId >>> 32));
		result = prime * result + (int) (driverId ^ (driverId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carShopId != other.carShopId)
			return false;
		if (driverId != other.driverId)
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}
	@XmlElement
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	@XmlElement
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	@XmlElement
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	@XmlElement
	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}
	@XmlElement
	public long getCarShopId() {
		return carShopId;
	}

	public void setCarShopId(long carShopId) {
		this.carShopId = carShopId;
	}
	
	
}
