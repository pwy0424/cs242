package navigation_cards;

public class Navigation {
	private int ID;
	private int birds;//0 or 1 or -1
	private boolean boxer;//true or false
    private boolean oars;//true or false
    private Character[] overboard;
    private Character[] thirsty;
    
    public Navigation(int ID, Character[] overboard, int bird, Character[] thirsty, boolean boxer, boolean oars)
    {
    	this.ID = ID;
    	this.overboard = overboard;
    	this.birds = bird;
    	this.thirsty = thirsty;
    	this.boxer = boxer;
    	this.oars = oars;
    }
    
    public int getID() {
		return ID;
	}

	public int getBird()
    {
    	return this.birds;
    }
    
    public boolean getBoxer()
    {
    	return this.boxer;
    }
    
    public boolean getOars()
    {
    	return this.oars;
    }
    
    public Character[] getOverboard()
    {
    	return this.overboard;
    }
    
    public Character[] getThirsty()
    {
    	return this.thirsty;
    }

	public void resolve() {
		// TODO Auto-generated method stub
		
	}
    
}
