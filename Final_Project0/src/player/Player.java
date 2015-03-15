package player;

import provision_cards.Provisions;

public class Player {
	private Character character;
	private boolean did_fight;//0 or 1
	private boolean did_row;//0 or 1
	private int current_hp;
	
	private Provisions[] cards_in_hand;
	private Provisions[] cards_shown;
	
	private Character hate;
	private Character love;
	
	public Player(Character character)
	{
		this.character = character;
		this.did_fight = false;
		this.did_row = false;
		this.current_hp = this.character.getSize();
	}
	
	public Character getHate() {
		return hate;
	}

	public void setHate(Character hate) {
		this.hate = hate;
	}

	public Character getLove() {
		return love;
	}

	public void setLove(Character love) {
		this.love = love;
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}

	public Character getCharacter() {
		return character;
	}
	
	public boolean getDid_fight() {
		return did_fight;
	}
	
	public boolean getDid_row() {
		return did_row;
	}
	
	public int getCurrent_hp() {
		return current_hp;
	}
	
	public Provisions[] getCards_in_hand() {
		return cards_in_hand;
	}
	
	
	public Provisions[] getCards_shown() {
		return cards_shown;
	}
	
	//public 
}
