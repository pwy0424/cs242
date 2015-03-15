package player;

import java.util.Vector;

import navigation_cards.Navigation;
import game_board.Game_board;
import provision_cards.Provisions;
import provision_cards.Weapon;

public class Player {
	private Character character;
	private boolean did_fight;//0 or 1
	private boolean did_row;//0 or 1
	private int current_hp;

	public Vector<Provisions> cards_in_hand;
	public Vector<Provisions> cards_shown;
	
	private Character hate;
	private Character love;
	
	private int fight_side;//0 for not join fight, -1 for defenders, 1 for attackers
	
	public int getFight_side() {
		return fight_side;
	}

	public void setFight_side(int fight_side) {
		this.fight_side = fight_side;
	}

	public Player(Character character)
	{
		this.character = character;
		this.did_fight = false;
		this.did_row = false;
		this.current_hp = character.getSize();
		this.cards_in_hand = new Vector<Provisions>(100);
		this.cards_shown = new Vector<Provisions>(100);
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
	
	public void setDid_fight(boolean did_fight) {
		this.did_fight = did_fight;
	}

	public void setDid_row(boolean did_row) {
		this.did_row = did_row;
	}

	public int getCurrent_hp() {
		return current_hp;
	}

	public void action(Game_board game_board) {
		int action_type = 0;//use UI to get action type
		//0 for swap place, 1 for mug, 2 for raw, 3 for do nothing, 4 for special action cards
		if(action_type == 0)
		{
			swap_place(game_board);
		}
		else if(action_type == 1)
		{
			mug_someone(game_board);
		}
		else if(action_type == 2)
		{
			raw(game_board);
		}
		else if(action_type == 3)
		{
			//literally do nothing
		}
		else if(action_type == 4)
		{
			
		}
	}

	private void raw(Game_board game_board) {
		int number = 2;
		for(int i = 0; i < this.cards_shown.size(); i++)
		{
			if(this.cards_shown.get(i) instanceof Weapon && ((Weapon)this.cards_in_hand.get(i)).getSize() == 1)
			{
				number += 1;
			}
		}
		for(int i = 0; i < number; i++)
		{
			Navigation card = (Navigation) game_board.Navigation_Deck.remove(0);
			boolean flag = false;//use UI to get this, false means go to bottom,
			if(!flag) game_board.Navigation_Deck.add(card);//add back to the bottom of the deck;
			else game_board.Picked_Navigation.add(card);
		}
	}

	private void mug_someone(Game_board game_board) {
		Player other = null;//use UI to get player to swap with
		//if(other == this) ;//get again
		//else
		//{
			int fight = 0;//use UI to get fight or not, 0 for no fight, 1 for fight
			if(fight == 0)
			{
				game_board.mug(this,other);
			}
			else
			{
				boolean win = game_board.initial_fight(this, other);
				if(!win)
				{
					//nothing happens?
				}
				else
				{
					game_board.mug(this,other);
				}
			}
		//}
	}

	private void swap_place(Game_board game_board) {
		Player other = null;//use UI to get player to swap with
		//if(other == this) ;//get again
		//else
		//{
			int fight = 0;//use UI to get fight or not, 0 for no fight, 1 for fight
			if(fight == 0)
			{
				game_board.swap(this, other);
			}
			else
			{
				boolean win = game_board.initial_fight(this, other);
				if(!win)
				{
					//nothing happens?
				}
				else
				{
					game_board.swap(this, other);
				}
			}
		//}
	}

	public void loseOneHp() {
		this.current_hp -= 1;
	}
	
	//public 
}
