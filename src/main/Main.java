package main;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import computer.Computer;
import computer.User;
import exceptions.DeviceNotPlugedInException;
import exceptions.NoProcessorException;
import exceptions.NotFuctionalException;
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

public class Main {
		
	private static Logger logger = LogManager.getLogger(Main.class);
	
	public static final void main(String[] args) {
		
		
		Email emailFromSolvd = new Email("Solvd","You're hired",2023);
		Email emailFromMe = new Email("Ilia","Wow",2023);
		
		ArrayList<Email> myMailBox = new ArrayList<>();
		ArrayList<Email> solvdMailBox = new ArrayList<>();
		
		MailingApplication mailRu = new MailingApplication("Mail.ru", "202.3.a", true,myMailBox);
		MailingApplication gmail = new MailingApplication("Gmail", "31.05.df", true,solvdMailBox);
		
		OperatingSystem windows = new OperatingSystem("Windows", "Home", false, "Ntfs");
		OperatingSystem linux = new OperatingSystem("Linux", "Fedora", true, "Ext4");
		
		User ilia = new User("clown322", "asdasdasd");
		User solvd = new User("Solvd", "SolvdTest12334321");
		
		try {
			Keyboard keyboard = new Keyboard("G715", "Logitech ", true, true, 101);
			
			Mouse mouse = new Mouse("m90", "Logitech",true, true, 2);
			
			Monitor monitor = new Monitor("VG27AQL1A", "Asus", false, false, 68.58f);
			
			Processore processore = new Processore("3-12100","Intel" ,true, 4);
			
			Motherboard motherboard = new Motherboard("X670E", "Asus", true, 8);
			
			VideoCard videoCard = new VideoCard("3060", "Nvidia", true, 12);
			
			Cooler cooler = new Cooler();
			
			Computer iliaComputer = new Computer(ilia, keyboard, monitor, mouse, cooler, motherboard, processore, videoCard, windows, mailRu);
			Computer reqruiterComputer = new Computer(solvd, keyboard, monitor, mouse, cooler, motherboard, processore, videoCard, linux, gmail);
			
			reqruiterComputer.sendEmail(emailFromSolvd, myMailBox);
			
			iliaComputer.sendEmail(emailFromMe,solvdMailBox);
			reqruiterComputer.updateEmailBox(solvdMailBox);
			
			reqruiterComputer.getMailingApplication().readMailBox();
			
			
		}
		catch (DeviceNotPlugedInException e) {
			logger.info("Some of devices are not plugged in");
		}
		catch (NoProcessorException e) {
			logger.info("Computer without processor...");
		}
		catch (NotFuctionalException e) {
			logger.info("Some of Hardware is not functioning");
		}

		

	


		
	}
}
