package software;

import java.util.Objects;

public class OperatingSystem extends Software{
	
	private String fileSystem;
	
	public OperatingSystem() {
		
	}

	public OperatingSystem(String name, String build, boolean upToDate, String fileSystem) {
		super(name, build, upToDate);
		this.fileSystem = fileSystem;
	}

	public String getFileSystem() {
		return fileSystem;
	}

	public void setFileSystem(String fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString + "OperatingSystem [fileSystem=" + fileSystem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fileSystem);
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
		OperatingSystem other = (OperatingSystem) obj;
		return Objects.equals(fileSystem, other.fileSystem);
	}

	
	
	
}
