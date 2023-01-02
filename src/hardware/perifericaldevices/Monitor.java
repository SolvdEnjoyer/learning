package hardware.perifericaldevices;

import java.util.Objects;

import exceptions.DeviceNotPlugedInException;
import exceptions.NotFuctionalException;
import interfaces.IDisplay;

public class Monitor extends PerifericalDevices implements IDisplay{

	private float size;
	private boolean isDiplayngAtTheMoment = false;

	public Monitor(String model, String vendor, boolean functional, boolean pluggedIn, float size) throws DeviceNotPlugedInException, NotFuctionalException {
		super(model, vendor, functional, pluggedIn);
		this.size = size;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public boolean isDiplayngAtTheMoment() {
		return isDiplayngAtTheMoment;
	}

	public void setDiplayngAtTheMoment(boolean diplayngAtTheMoment) {
		this.isDiplayngAtTheMoment = diplayngAtTheMoment;
	}

	@Override
	public void startDisplaying() {
		this.isDiplayngAtTheMoment = true;
		
	}

	@Override
	public void stopDisplaying() {
		this.isDiplayngAtTheMoment = false;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(isDiplayngAtTheMoment, size);
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
		Monitor other = (Monitor) obj;
		return isDiplayngAtTheMoment == other.isDiplayngAtTheMoment
				&& Float.floatToIntBits(size) == Float.floatToIntBits(other.size);
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString +  "Monitor [size=" + size + ", diplayngAtTheMoment=" + isDiplayngAtTheMoment + "]";
	}
	
}
