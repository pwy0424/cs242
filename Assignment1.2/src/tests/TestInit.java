package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import chessPieces.StandardBoard;

public class TestInit {

	@Test
	public void testInit() 
	{
		StandardBoard testBoard = new StandardBoard();
		testBoard.initBoard();
		assertTrue(testBoard.getWinner() == -1);
		assertTrue(testBoard.getTurn() == 0);
		assertTrue(testBoard.getChecked() == -1);
	}
}
