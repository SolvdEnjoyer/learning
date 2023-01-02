package exceptions;

public class DeviceNotPlugedInException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -391915714168734313L;

	public DeviceNotPlugedInException(String errorMessage) {  
	super(errorMessage);   
	}
}
