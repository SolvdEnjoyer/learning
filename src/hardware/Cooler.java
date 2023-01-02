package hardware;
import java.util.Objects;

import exceptions.NotFuctionalException;

public class Cooler extends Hardware {

	private int fansNumber;
	
	public Cooler() {
	}
	
	public Cooler(String model, String vendor,boolean functional, int fansNumber) throws NotFuctionalException {
		super(model,vendor,functional);
		this.fansNumber = fansNumber;
	}

	public int getFansNumber() {
		return fansNumber;
	}



	public void setFansNumber(int fansNumber) {
		this.fansNumber = fansNumber;
	}
	
	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString + "Cooler [fansNumber=" + fansNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fansNumber);
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
		Cooler other = (Cooler) obj;
		return fansNumber == other.fansNumber;
	}                                                          
}
