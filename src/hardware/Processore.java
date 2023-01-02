package hardware;
import java.util.Objects;

import exceptions.NotFuctionalException;

public class Processore extends Hardware {
	private int threadsNumber;
	
	public Processore() {
	}
	
	public Processore(String model, String vendor, boolean functional, int threadsNumber ) throws NotFuctionalException {
		super(model,vendor,functional);
		this.threadsNumber = threadsNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(threadsNumber);
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
		Processore other = (Processore) obj;
		return threadsNumber == other.threadsNumber;
	}

	public int getThreadsNumber() {
		return threadsNumber;
	}

	public void setThreadsNumber(int threadsNumber) {
		this.threadsNumber = threadsNumber;
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString + "Processore [threadsNumber=" + threadsNumber + "]";
	}
	
	
	
}
