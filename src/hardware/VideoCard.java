package hardware;
import java.util.Objects;

import exceptions.NotFuctionalException;

public class VideoCard extends Hardware{
	private int memory;
	
	public VideoCard() {

	}
	
	public VideoCard(String model, String vendor, boolean functional, int memory) throws NotFuctionalException {
		super(model,vendor,functional);
		this.memory = memory;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(memory);
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
		VideoCard other = (VideoCard) obj;
		return memory == other.memory;
	}

	@Override
	public String toString() {
		String superToString = super.toString();
		return superToString + "VideoCard [memory=" + memory + "]";
	}

	
	
}
