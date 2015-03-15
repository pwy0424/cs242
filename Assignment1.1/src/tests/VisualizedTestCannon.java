package tests;

import gameInterface.GameView;
import chessPieces.Cannon;
import chessPieces.StandardBoard;

public class VisualizedTestCannon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardBoard test = new StandardBoard();
        test.initBoard();
        
        Cannon piece = new Cannon(0,1,test.getPlayer(0));
        test.setPosition(piece, 0, 1);
        test.getPlayer(0).setPiece(piece, 8);
		
        
        test.movePiece(piece, 5, 6);
		new GameView(test);
	}

}
