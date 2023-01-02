package hardware.perifericaldevices;
import java.util.Objects;

import exceptions.DeviceNotPlugedInException;
import exceptions.NotFuctionalException;
import interfaces.IType;

public class Keyboard extends PerifericalDevices implements IType{
	
	private int keysNumber;
	private boolean isTypingAtTheMoment = false;

	public Keyboard(String model, String vendor, boolean functional, boolean pluggedIn, int keysNumber) throws DeviceNotPlugedInException, NotFuctionalException {
		super(model, vendor, functional, pluggedIn);
		this.keysNumber = keysNumber;
	}

	public boolean isTypingAtTheMoment() {
		return isTypingAtTheMoment;
	}
	public void setTypingAtTheMoment(boolean isTypingAtTheMoment) {
		this.isTypingAtTheMoment = isTypingAtTheMoment;
	}
	public int getKeysNumber() {
		return keysNumber;
	}

	public void setKeysNumber(int keysNumber) {
		this.keysNumber = keysNumber;
	}

	@Override
	public void startTyping(String[] words) {
		isTypingAtTheMoment = true;
		for (String word : words) System.out.print(word + "");
	}

	@Override
	public void stopTyping() {
		isTypingAtTheMoment = false;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(keysNumber, isTypingAtTheMoment);
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
		Keyboard other = (Keyboard) obj;
		return keysNumber == other.keysNumber && isTypingAtTheMoment == other.isTypingAtTheMoment;
	}
	
	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString +  "Keyboard [keysNumber=" + keysNumber + ", typingAtTheMoment=" + isTypingAtTheMoment + "]";
	}


	
}
