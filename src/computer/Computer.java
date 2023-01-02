package computer;

import java.util.ArrayList;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.NoProcessorException;
import hardware.Cooler;
import hardware.Motherboard;
import hardware.Processore;
import hardware.VideoCard;
import hardware.perifericaldevices.Keyboard;
import hardware.perifericaldevices.Monitor;
import hardware.perifericaldevices.Mouse;
import software.OperatingSystem;
import software.mailingsystem.Email;
import software.mailingsystem.MailingApplication;

public class Computer {
	
	private static Logger logger = LogManager.getLogger(Computer.class);
	
	private User user;
	
	private Keyboard keyboard;
	private Monitor monitor;
	private Mouse mouse;
	
	private Cooler cooler;
	private Motherboard motherboard;
	private Processore processore;
	private VideoCard videoCard;
	
	private OperatingSystem operatingSystem;
	private MailingApplication mailingApplication;
	


	
	public Computer(User user, Keyboard keyboard, Monitor monitor, Mouse mouse, Cooler cooler, Motherboard motherboard,
			Processore processore, VideoCard videoCard, OperatingSystem operatingSystem,
			MailingApplication mailingApplication) throws NoProcessorException{
		this.user = user;
		this.keyboard = keyboard;
		this.monitor = monitor;
		this.mouse = mouse;
		this.cooler = cooler;
		this.motherboard = motherboard;
		if(processore != null) this.processore = processore;
		else {
			logger.info("Computer without processor does not exist!");
			throw new NoProcessorException("Computer without processor does not exist!");
		}
		this.videoCard = videoCard;
		this.operatingSystem = operatingSystem;
		this.mailingApplication = mailingApplication;
	}




	public Computer() {
	}

	
	public void sendEmail(Email email,ArrayList<Email> emailBox) {
		
		this.mailingApplication.sendEmail(email, emailBox);
		
	}
	
	public void updateEmailBox(ArrayList<Email> emailBox) {
		
		this.mailingApplication.setMailBox(emailBox);
		
	}


	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}
	
	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public Cooler getCooler() {
		return cooler;
	}

	public void setCooler(Cooler cooler) {
		this.cooler = cooler;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	public Processore getProcessore() {
		return processore;
	}

	public void setProcessore(Processore processore) {
		this.processore = processore;
	}

	public VideoCard getVideoCard() {
		return videoCard;
	}

	public void setVideoCard(VideoCard videoCard) {
		this.videoCard = videoCard;
	}

	public MailingApplication getMailingApplication() {
		return mailingApplication;
	}

	public void setMailingApplication(MailingApplication mailingApplication) {
		this.mailingApplication = mailingApplication;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cooler, keyboard, mailingApplication, monitor, motherboard, mouse, operatingSystem,
				processore, user, videoCard);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		return Objects.equals(cooler, other.cooler) && Objects.equals(keyboard, other.keyboard)
				&& Objects.equals(mailingApplication, other.mailingApplication)
				&& Objects.equals(monitor, other.monitor) && Objects.equals(motherboard, other.motherboard)
				&& Objects.equals(mouse, other.mouse) && Objects.equals(operatingSystem, other.operatingSystem)
				&& Objects.equals(processore, other.processore) && Objects.equals(user, other.user)
				&& Objects.equals(videoCard, other.videoCard);
	}



	
	
}
