package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import chessPieces.Pieces;
import chessPieces.StandardBoard;

public class TestQueen {

	@Test
	public void testInvalidMoveQueen()
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		Pieces queen = testBoard.getPosition(3,0);
		assertTrue(testBoard.movePiece(queen,3,1) == -1);
	}
	
	@Test
	public void testMoveOutOfBoard()
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		Pieces queen = testBoard.getPosition(3,0);
		assertTrue(testBoard.movePiece(queen,3,-1) == -1);
	}
	
	@Test
	public void testMoveIntoOwnPiece()
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		Pieces queen = testBoard.getPosition(3,0);
		assertTrue(testBoard.movePiece(queen,3,1) == -1);
	}

}
