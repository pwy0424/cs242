package tests;

import gameInterface.GameView;

import chessPieces.HopperQueen;
import chessPieces.StandardBoard;

public class VisualizedTestHopperQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardBoard test = new StandardBoard();
        test.initBoard();
        
        HopperQueen piece = new HopperQueen(3,0,test.getPlayer(0));
        test.setPosition(piece, 3, 0);
        test.getPlayer(0).setPiece(piece, 3);
		
        
        test.movePiece(piece, 3, 4);
		new GameView(test);
	}

}
