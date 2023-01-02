package hardware.perifericaldevices;

import java.util.Objects;

import exceptions.DeviceNotPlugedInException;
import exceptions.NotFuctionalException;
import interfaces.IClick;
import interfaces.IScroll;

public class Mouse extends PerifericalDevices implements IClick, IScroll{
	
	private int buttonsNumber;

	public Mouse(String model, String vendor, boolean functional, boolean pluggedIn, int buttonsNumber) throws DeviceNotPlugedInException, NotFuctionalException {
		super(model, vendor, functional, pluggedIn);
		this.buttonsNumber = buttonsNumber;
	}

	public int getButtonsNumber() {
		return buttonsNumber;
	}

	public void setButtonsNumber(int buttonsNumber) {
		this.buttonsNumber = buttonsNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(buttonsNumber);
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
		Mouse other = (Mouse) obj;
		return buttonsNumber == other.buttonsNumber;
	}

	@Override
	public String toString() {
		
		String superToString = super.toString();
		return superToString + "Mouse [buttonsNumber=" + buttonsNumber + "]";
	}

	@Override
	public void click(int[] positon) {
		System.out.println("Clicked on X =" + positon[0] + "Y =" + positon[1]);
		
	}

	@Override
	public void scroll(int pixels, String direction) {
		System.out.println("Scrolled " + direction + pixels + " pixeles");
		
	}
	
	
	
}
