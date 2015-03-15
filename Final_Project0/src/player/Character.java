package player;

public class Character {
	private String Name;
	private int size;
	private int survival_point;
	
	public Character(String name, int size)
	{
		this.Name = name;
		this.size = size;
		this.survival_point = 12 - size;
	}

	public String getName() {
		return Name;
	}

	public int getSize() {
		return size;
	}

	public int getSurvival_point() {
		return survival_point;
	}	
	
}
