package provision_cards;

public class Weapon extends Provisions{
	private int size;
	
	public Weapon(int ID, int size)
	{
		super(ID);
		this.size = size;
		
	}
	
	public int getSize()
	{
		return this.size;
	}
	
}
