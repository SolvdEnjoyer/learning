package computer;
import java.util.Objects;

public class User {
	private String login;
	private String password;
	
	public User() {
		
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + "]";
	}
	
	
	
}
