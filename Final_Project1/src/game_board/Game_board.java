package game_board;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import navigation_cards.Navigation;
import player.Player;
import player.Character;
import provision_cards.Provisions;

public class Game_board {
	private int max_Player_num;//4-8
	private int current_Player_num;//able_bodied player number
	private Player[] Players;

	public Vector<Navigation> Navigation_Deck;
	public Vector<Navigation> Picked_Navigation;
	public Vector<Provisions> Provision_Deck;
	
	
	private int birds;
	private int Days;
	private int turn;//turn in the day, 0 for quatermaster, 1 to num for Players' turn, num+1 for 
	
	private int[] scores;//only for scoring after games ends. 
	
	private boolean end;
	
	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public Game_board(int num)
	{
		this.max_Player_num = num;
		this.current_Player_num = num;
		Character[] character_list = initial_all_character();
		for(int i = 0; i < (8-num); i++)//(8-num) means random out several character that should be removed
		{
			//random out several character that is in the game.
			int rand = randInt(0, 8-i);
			character_list = remove_from_array(character_list, rand);
		}
		Players = new Player[num];
		
		for(int i = 0; i < num; i++)
		{
			Players[i] = new Player(character_list[i]);
		}
		
		Character[] hate_list = character_list;
		Character[] love_list = character_list;
		
		for(int i = 0; i < num; i++)//set up the hate and loves
		{
			int rand = randInt(0, num-i);
			Players[i].setHate(hate_list[rand]);
			hate_list = remove_from_array(hate_list, rand);
			rand = randInt(0, num-i);
			Players[i].setLove(love_list[rand]);
			love_list = remove_from_array(love_list, rand);
		}
		
		//set up card Decks
		this.Provision_Deck = initial_provision_deck();
		this.Navigation_Deck = initial_navigation_deck();
		
		this.birds = 0;
		this.Days = 1;
		this.turn = 0;
		this.end = false;
		this.scores = new int[this.max_Player_num];
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Action()
	{
		if(this.turn == 0)
		{
			//deal provision cards
			Vector<Provisions> temp = new Vector(this.current_Player_num);
			for(int i = 0; i < this.current_Player_num; i ++)
			{
				temp.add(this.Provision_Deck.remove(0));
				for(int j = 0; j < this.max_Player_num; j++)
				{
					if(this.Players[j].getCurrent_hp() > 0)//not fainted or dead
					{
						int index = 0;//use UI to let the player pick one card
						this.Players[j].cards_in_hand.add(temp.remove(index));
					}
				}
			}
		}
		else if(this.turn == this.max_Player_num +1)//resolve navigation cards
		{
			if(this.Picked_Navigation.isEmpty())
			{
				(this.Navigation_Deck.remove(0)).resolve();
			}
			else
			{
				int index = 0;//use UI to let last player pick
				(this.Picked_Navigation.remove(index)).resolve();
				for(int i = 0; i < this.Picked_Navigation.size(); i++)
				{
					this.Navigation_Deck.add(this.Picked_Navigation.remove(0));
					//add the cards of picked navigation deck back to the bottom of navigation deck
				}
			}
		}
		else
		{
			//players' turns
			Player active_player = this.Players[this.turn-1];
			active_player.action(this);
		}
		next_round();
	}

	@SuppressWarnings("rawtypes")
	private Vector initial_navigation_deck() {
		Vector result = new Vector(20);//change this number later
		result = initial_all_navigations();
		//using the Fisher¨CYates shuffle algorithm 
		for(int i = 0; i < result.size()-1; i++)
		{
			int j = randInt(i, result.size());
			Collections.swap(result, i, j);
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	private Vector initial_all_navigations() {
		// TODO:manually set up all the navigation cards
		return null;
	}

	@SuppressWarnings("rawtypes")
	private Vector initial_provision_deck() {
		Vector result = new Vector(20);//change this number later
		result = initial_all_provisions();
		//using the Fisher¨CYates shuffle algorithm 
		for(int i = 0; i < result.size()-1; i++)
		{
			int j = randInt(i, result.size());
			Collections.swap(result, i, j);
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	private Vector initial_all_provisions() {
		// TODO: manually set up all the provision cards
		return null;
	}

	private Character[] initial_all_character() {
		Character[] result = new Character[8];
		
		result[0] = new Character("Lady Lauren", 4);
		result[1] = new Character("Sir Stephen", 5);
		result[2] = new Character("The Captain", 7);
		result[3] = new Character("First Mate", 8);
		result[4] = new Character("Madame Wong", 3);
		result[5] = new Character("Frenchy", 6);
		result[6] = new Character("Dr. Harter", 4);
		result[7] = new Character("The Kid", 3);
		
		return result;
		
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	private Character[] remove_from_array(Character[] array, int index)
	{
		Character[] result = new Character[(array.length-1)];
		int count = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(i != index)
			{
				result[count] = array[i];
				count++;
			}
		}
		return result;
	}
	
	private void next_round()
	{
		this.turn  += 1;
		if(this.turn > this.max_Player_num + 1)
		{
			this.turn = 0;
			this.Days += 1;
			clear_players();//a new day, set every players' did_fight and did_raw to false
		}
	}

	private void clear_players() {
		for (int i = 0; i < this.max_Player_num; i++) {
			this.Players[i].setDid_fight(false);
			this.Players[i].setDid_row(false);
		}
		
	}

	public void swap(Player player, Player other) {
		int player_i = 0;
		int player_j = 0;
		for(int i = 0; i < this.max_Player_num; i++)
		{
			if(this.Players[i] == player) player_i = i;
			if(this.Players[i] == other) player_j = i;
		}
		Player temp;
		temp = this.Players[player_i];
		this.Players[player_i] = this.Players[player_j];
		this.Players[player_j] = temp;
	}

	public void calculate_scores() {
		for(int i = 0; i < this.max_Player_num; i++)
		{
			int score = 0;
			Player curPlayer = this.Players[i];
			Player lover = null;
			Player hater = null;
			for(int j = 0; j < this.max_Player_num; j++)//get the lover and the hater
			{
				if(this.Players[j].getCharacter() == curPlayer.getLove()) lover = this.Players[j];
				if(this.Players[j].getCharacter() == curPlayer.getHate()) hater = this.Players[j];
			}
			if(curPlayer.getCurrent_hp() >= 0)//alive
			{
				if (hater != curPlayer) score += curPlayer.getCharacter().getSurvival_point();//not hate oneself
			}
			if(lover.getCurrent_hp() >= 0)//lover alive
			{
				score += lover.getCharacter().getSurvival_point();
			}
			if(hater == curPlayer)//hate oneself
			{
				
			}
			else
			{
				if(hater.getCurrent_hp() < 0)//hater dead
					score += hater.getCharacter().getSize();
			}
			
			this.scores[i] = score;
		}
	}

	public boolean initial_fight(Player attacker, Player defender) {
		boolean result;//result is attacker wins, true for attacker wins, false for defender wins
		Player[] attackers = new Player[this.max_Player_num];
		Player[] defenders = new Player[this.max_Player_num];
		//initial arrays
		for(int i = 0 ; i < max_Player_num; i++)
		{
			attackers[i] = null;
			defenders[i] = null;
		}
		attacker.setFight_side(1);
		defender.setFight_side(-1);
		int attack_sum = 0;
		int defend_sum = 0;
		//use UI to make every player choose side.
		for(int i = 0 ; i < max_Player_num; i++)
		{
			if(this.Players[i] != null && this.Players[i].getFight_side() == -1)
			{
				defenders[i] = this.Players[i];
				this.Players[i].setDid_fight(true);
				defend_sum += this.Players[i].getCharacter().getSize();
			}
			if(this.Players[i] != null && this.Players[i].getFight_side() == 1)
			{
				attackers[i] = this.Players[i];
				this.Players[i].setDid_fight(true);
				attack_sum += this.Players[i].getCharacter().getSize();
			}
		}
		if(attack_sum > defend_sum)//attackers win
		{
			result = true;
			for(int i = 0 ; i < max_Player_num; i++)
			{
				if(defenders[i] != null)
				{
					defenders[i].loseOneHp();
				}
			}
		}
		else//defenders win
		{
			result = false;
			for(int i = 0 ; i < max_Player_num; i++)
			{
				if(attackers[i] != null)
				{
					attackers[i].loseOneHp();
				}
			}
		}
		
		for(int i = 0 ; i < max_Player_num; i++)
		{
			this.Players[i].setFight_side(0);//this fight ends, everyone's fight end was cleared
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public void mug(Player player, Player other) {
		int flag = 0;//0 for cards_in_hand, 1 for cards shown
		//use UI to get these information
		if(flag == 0)
		{
			int index = 0;//use UI to make player choose one
			player.cards_in_hand.add(other.cards_in_hand.remove(index));
			
		}
		else if(flag == 1)
		{
			int index = 0;//use UI to make player choose one
			player.cards_in_hand.add(other.cards_shown.remove(index));
		}
		
	}

	
}
