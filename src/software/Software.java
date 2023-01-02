package software;

import java.util.Objects;

public abstract class Software  {
	
	private String name;
	private String build;
	private boolean upToDate;
	
	public Software(){
		
	}

	public Software(String name, String build, boolean upToDate) {
		this.name = name;
		this.build = build;
		this.upToDate = upToDate;
	}

	public String getName() {
		return name;
	}

	public String getBuild() {
		return build;
	}

	public boolean isUpToDate() {
		return upToDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public void setUpToDate(boolean upToDate) {
		this.upToDate = upToDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(build, name, upToDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Software other = (Software) obj;
		return Objects.equals(build, other.build) && Objects.equals(name, other.name) && upToDate == other.upToDate;
	}

	@Override
	public String toString() {
		return "Software [name=" + name + ", build=" + build + ", upToDate=" + upToDate + "]";
	}
	
	
}
