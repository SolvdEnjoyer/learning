package software.mailingsystem;

import java.util.ArrayList;

import software.Software;

public class MailingApplication extends Software {
	
	private ArrayList<Email> mailBox;

	public MailingApplication(String name, String build, boolean upToDate, ArrayList<Email> mailBox) {
		super(name, build, upToDate);
		this.mailBox = mailBox;
	}

	public ArrayList<Email> getMailBox() {
		return mailBox;
	}

	public void setMailBox(ArrayList<Email> mailBox) {
		this.mailBox = mailBox;
	}

	public void sendEmail(Email email, ArrayList<Email> mailBox) {
		
		mailBox.add(email);
		
	}
	
	public void readMailBox(){
		for (Email email : mailBox) {
			System.out.println(email.toString());
		}
	}

	
	

}
