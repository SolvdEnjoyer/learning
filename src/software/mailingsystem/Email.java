package software.mailingsystem;

import java.util.Objects;

public class Email {
	private String sender;
	private String message;
	private int date;
	
	public Email() {
	}

	public Email(String sender, String message, int date) {
		this.sender = sender;
		this.message = message;
		this.date = date;
	}

	public String getSender() {
		return sender;
	}

	public String getMessage() {
		return message;
	}

	public int getDate() {
		return date;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, message, sender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return date == other.date && Objects.equals(message, other.message) && Objects.equals(sender, other.sender);
	}

	@Override
	public String toString() {
		return "Email [sender=" + sender + ", message=" + message + ", date=" + date + "]";
	}

	
	
}


