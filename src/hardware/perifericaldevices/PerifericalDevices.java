package hardware.perifericaldevices;

import exceptions.DeviceNotPlugedInException;
import exceptions.NotFuctionalException;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hardware.Hardware;


public abstract class PerifericalDevices extends Hardware {
	
	private static Logger logger = LogManager.getLogger(PerifericalDevices.class);
	
	private boolean pluggedIn;

	public PerifericalDevices(String model,  String vendor,boolean functional,boolean pluggedIn) throws DeviceNotPlugedInException, NotFuctionalException {
		super(model,vendor,functional);
		if(pluggedIn) this.pluggedIn = pluggedIn;
		else {
			logger.info("Periferical device is not Plugged In!");
			throw new DeviceNotPlugedInException("PerifericalDevice is not Plugged In!");
		}
	}
	
	public boolean isPluggedIn() {
		return pluggedIn;
	}
	public void setPluggedIn(boolean pluggedIn) {
		this.pluggedIn = pluggedIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pluggedIn);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerifericalDevices other = (PerifericalDevices) obj;
		return pluggedIn == other.pluggedIn;
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString + "PerifericalDevices [pluggedIn=" + pluggedIn + "]";
	}

	
	
	 
	
}
