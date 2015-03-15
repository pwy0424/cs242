package chessPieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void testInit() 
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		assertTrue(testBoard.getWinner() == -1);
		assertTrue(testBoard.getTurn() == 0);
		assertTrue(testBoard.getChecked() == -1);
	}
	
	@Test
	public void testFirstMovePawn()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces pawn = testBoard.getPosition(0,1);
		assertTrue(testBoard.movePiece(pawn,0,3) == 0);
	}
	
	@Test
	public void testInvalidMovePawn()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces pawn = testBoard.getPosition(0,1);
		assertTrue(testBoard.movePiece(pawn,0,4) == -1);
	}

	@Test
	public void testInvalidMoveQueen()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces queen = testBoard.getPosition(3,0);
		assertTrue(testBoard.movePiece(queen,3,1) == -1);
	}
	
	@Test
	public void testPawnCapture()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces pawnWhite = testBoard.getPosition(0,1);
		Pieces pawnBlack = testBoard.getBlackPiece(9);
		testBoard.movePiece(pawnWhite,0,3);
		testBoard.movePiece(pawnBlack,1,4);
		assertTrue(testBoard.movePiece(pawnWhite,1,4) == 0);
		assertTrue(testBoard.getBlackPiece(9).getX() == -1);
	}
	
	@Test
	public void testMoveOutOfBoard()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces queen = testBoard.getPosition(3,0);
		assertTrue(testBoard.movePiece(queen,3,-1) == -1);
	}
	
	@Test
	public void testMoveIntoOwnPiece()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces queen = testBoard.getPosition(3,0);
		assertTrue(testBoard.movePiece(queen,3,1) == -1);
	}
	
	@Test
	public void testSurrender()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		testBoard.surrender(0);
		assertTrue(testBoard.getWinner() == 1);
	}
	
	@Test
	public void testCheck()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces pawnWhite = testBoard.getPosition(4,1);
		Pieces pawnBlack = testBoard.getPosition(5,6);
		Pieces queen = testBoard.getPosition(3,0);
		testBoard.movePiece(pawnWhite, 4, 3);
		testBoard.movePiece(pawnBlack, 5, 4);
		testBoard.movePiece(queen, 7,4);
		assertTrue(testBoard.getChecked() == 1);
	}
	
	@Test
	public void testCannotMove()
	{
		Board testBoard = new Board();
		testBoard.initBoard();
		Pieces pawnWhite = testBoard.getPosition(4,1);
		Pieces pawnBlack = testBoard.getPosition(5,6);
		Pieces queen = testBoard.getPosition(3,0);
		testBoard.movePiece(pawnWhite, 4, 3);
		testBoard.movePiece(pawnBlack, 5, 5);
		testBoard.movePiece(queen, 7,4);
		assertTrue(testBoard.movePiece(pawnBlack, 5, 4) == -1);
	}
}
