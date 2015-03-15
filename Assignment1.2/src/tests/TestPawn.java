package tests;

import static org.junit.Assert.*;
import gameInterface.GameControl;
import gameInterface.GameView;

import org.junit.Test;

import chessPieces.Pieces;
import chessPieces.StandardBoard;

public class TestPawn {

	/*@Test
	public void testFirstMovePawn()
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		Pieces pawn = testBoard.getPosition(0,1);
		assertTrue(testBoard.movePiece(pawn,0,3) == 0);
	}
	
	@Test
	public void testInvalidMovePawn()
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		Pieces pawn = testBoard.getPosition(0,1);
		assertTrue(testBoard.movePiece(pawn,0,4) == -1);
	}*/
	
	@Test
	public void testPawnCapture()
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		Pieces pawnWhite = testBoard.getPosition(0,1);
		Pieces pawnBlack = testBoard.getBlackPiece(9);
		testBoard.movePiece(pawnWhite,0,3);
		testBoard.movePiece(pawnBlack,1,4);
		assertTrue(testBoard.movePiece(pawnWhite,1,4) == 0);
		assertTrue(testBoard.getBlackPiece(9).getX() == -1);
		GameControl game = null;
		new GameView(testBoard, game);
	}

}
