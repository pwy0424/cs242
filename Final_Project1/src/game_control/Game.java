package game_control;

import game_board.Game_board;

public class Game {

	public static void main(String[] args) {
		int player_number = 5;//use UI to get player number
		
		Game_board game = new Game_board(player_number);
		while(!game.isEnd())
		{
			game.Action();
		}
		game.calculate_scores(); 
		//show the table of scores
	}

}
