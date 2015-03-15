package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import chessPieces.Pieces;
import chessPieces.StandardBoard;

public class TestEndGame {	
	@Test
	public void testSurrender()
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		testBoard.surrender(testBoard.getPlayer(0));
		assertTrue(testBoard.getWinner() == 1);
	}
	
	@Test
	public void testCheck()
	{
		StandardBoard testBoard = new StandardBoard();
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
		StandardBoard testBoard = new StandardBoard();
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
