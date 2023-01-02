package hardware;
import java.util.Objects;




import interfaces.Cleanable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.NotFuctionalException;



public abstract class Hardware implements Cleanable {
	
	
	private static Logger logger = LogManager.getLogger(Hardware.class);
	
	private String model;
	private String vendor;
	private boolean isFunctional;

	
	
	
	public Hardware() {
		logger.info("Unkown hardware");
	}


	public Hardware(String model, String vendor, boolean isFunctional) throws NotFuctionalException{
		this.model = model;
		this.vendor = vendor;
		if(isFunctional) this.isFunctional = isFunctional;
		else {
			logger.info("Hardware is not functional");
			throw new NotFuctionalException("Your Hardware is not functional");
		}
		
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public boolean isFunctional() {
		return isFunctional;
	}


	public void setFunctional(boolean isFunctional) {
		this.isFunctional = isFunctional;
	}


	@Override
	public int hashCode() {
		return Objects.hash(isFunctional, model, vendor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hardware other = (Hardware) obj;
		return isFunctional == other.isFunctional && Objects.equals(model, other.model)
				&& Objects.equals(vendor, other.vendor);
	}


	@Override
	public String toString() {
		return "Hardware [model=" + model + ", vendor=" + vendor + ", isFunctional=" + isFunctional + "]";
	}

	
	
}