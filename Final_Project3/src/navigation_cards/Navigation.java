package navigation_cards;

import game_board.Game_board;

public class Navigation {
	private int ID;
	private int birds;//0 or 1 or -1
	private boolean boxer;//true or false
    private boolean oars;//true or false
    private String[] overboard;
    private String[] thirsty;
    
    public Navigation(int ID, String[] overboard, int bird, String[] thirsty, boolean boxer, boolean oars)
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
    
    public String[] getOverboard()
    {
    	return this.overboard;
    }
    
    public String[] getThirsty()
    {
    	return this.thirsty;
    }

	public void resolve(Game_board game_board) {
		// TODO Auto-generated method stub
		
	}
    
}
