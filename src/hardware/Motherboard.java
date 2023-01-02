package hardware;
import java.util.Objects;

import exceptions.NotFuctionalException;

public class Motherboard extends Hardware{
	
	private int portsNumber;
	
	public Motherboard (){		
	}

	public Motherboard(String model, String vendor, boolean functional, int portsNumber) throws NotFuctionalException {
		super(model,vendor,functional);
		this.portsNumber = portsNumber;
	}

	public int getPortsNumber() {
		return portsNumber;
	}

	public void setPortsNumber(int portsNumber) {
		this.portsNumber = portsNumber;
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString + "portsNumber=" + portsNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(portsNumber);
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
		Motherboard other = (Motherboard) obj;
		return portsNumber == other.portsNumber;
	}

	

	
}

