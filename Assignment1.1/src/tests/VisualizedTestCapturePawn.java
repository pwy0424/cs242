package tests;

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
		new GameView(test);
		test.movePiece(pawnWhite,1,4);
		new GameView(test);
		Pieces pawnBlack2 = test.getPosition(0, 6);
		test.movePiece(pawnBlack2,0,5);
		test.movePiece(pawnWhite, 0, 5);
		
    	new GameView(test);
	}

}
