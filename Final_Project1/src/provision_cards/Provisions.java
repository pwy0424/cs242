package provision_cards;

public abstract class Provisions {
	private int ID;//the ID for this card, unique for each card
	
	public Provisions(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}


}
