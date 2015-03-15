package tests;

import gameInterface.GameControl;
import gameInterface.GameView;
import chessPieces.Pieces;
import chessPieces.StandardBoard;

public class VisualizedTestCapturePawn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardBoard test = new StandardBoard();
        test.initBoard();
        Pieces pawnWhite = test.getPosition(0,1);
		Pieces pawnBlack = test.getBlackPiece(9);
		test.movePiece(pawnWhite,0,3);
		test.movePiece(pawnBlack,1,4);
		GameControl game = new GameControl();
        game.previous = new StandardBoard();
        game.previous.initBoard();
    	game.gameView = new GameView(test, game);

		
	}

}
