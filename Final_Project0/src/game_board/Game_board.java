package game_board;

import java.util.Random;

import navigation_cards.Navigation;
import player.Player;
import player.Character;
import provision_cards.Provisions;

public class Game_board {
	private int max_Player_num;//4-8
	private int current_Player_num;//able_bodied player number
	private Player[] Players;
	private Navigation[] Navigation_Deck;
	private Provisions[] Provision_Deck;
	
	private int birds;
	private int Days;
	private int turn;//turn in the day, 0 for quatermaster, 1-num for Players' turn, num+1 for 
	
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
	}

	private Navigation[] initial_navigation_deck() {
		Navigation[] result = new Navigation[20];//change this number later
		result = initial_all_navigations();
		//using the Fisher¨CYates shuffle algorithm 
		for(int i = 0; i < result.length-1; i++)
		{
			int j = randInt(i, result.length);
			Navigation temp = result[i];
			result[i] = result[j];
			result[j] = temp;
		}
		
		return result;
	}

	private Navigation[] initial_all_navigations() {
		// TODO:manually set up all the navigation cards
		return null;
	}

	private Provisions[] initial_provision_deck() {
		Provisions[] result = new Provisions[20];//change this number later
		result = initial_all_provisions();
		//using the Fisher¨CYates shuffle algorithm 
		for(int i = 0; i < result.length-1; i++)
		{
			int j = randInt(i, result.length);
			Provisions temp = result[i];
			result[i] = result[j];
			result[j] = temp;
		}
		
		return result;
	}

	private Provisions[] initial_all_provisions() {
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
	
}
