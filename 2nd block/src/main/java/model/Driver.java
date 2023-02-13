package model;

import java.util.Objects;

public class Driver {

	private long id;
	private String firstName;
	private String lastName;
	private boolean isLicense;

	public Driver() {
	}
	public Driver(long id, String firstName, String lastName, boolean isLicense) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isLicense = isLicense;
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, isLicense, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && isLicense == other.isLicense
				&& Objects.equals(lastName, other.lastName);
	}
	@Override
	public String toString() {
		return "Driver [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", isLicense=" + isLicense
				+ "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isLicense() {
		return isLicense;
	}
	public void setLicense(boolean isLicense) {
		this.isLicense = isLicense;
	}


}
