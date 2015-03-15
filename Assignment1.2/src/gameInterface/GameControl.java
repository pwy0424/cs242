package gameInterface;
import javax.swing.JPanel;

import chessPieces.Board;
import chessPieces.Pieces;
import chessPieces.Player;
import chessPieces.StandardBoard;


public class GameControl {
	
	private Pieces selectedPiece;
	public GameView gameView;
	public Board previous;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardBoard test = new StandardBoard();
        test.initBoard();
        GameControl game = new GameControl();
        game.previous = new StandardBoard();
        game.previous.initBoard();
    	game.gameView = new GameView(test, game);
    	//game.gameView.window.setVisible(false);
	}

	public void restart() {
		System.out.print("Restart!");
		StandardBoard test = new StandardBoard();
        test.initBoard();
        this.gameView.window.setVisible(false);
		this.gameView = new GameView(test, this);
	}

	
	
	public Pieces getSelectedPiece()
	{
		return this.selectedPiece;
	}

	public void clickSelect(Pieces piece, Board board) 
	{
		// TODO Auto-generated method stub
		if(this.selectedPiece == piece)//the de-select function
		{
			this.selectedPiece = null;
		}
		else
		{
			if(board.getTurn() == piece.getPlayer().getID()) this.selectedPiece = piece;//only select pieces belong to your side when it's your turn
			else System.out.print("You cannot Select your opponent's piece\n");
		}
	}

	public void clickMove(int i, int j, Board board) 
	{
		// TODO Auto-generated method stub
		int flag;
		this.previous = new StandardBoard(board);
		if(this.selectedPiece == null) return;
		else flag = board.movePiece(this.selectedPiece, i, j);
		this.selectedPiece = null;
		this.gameView.view = new JPanel();
		if(flag == 0)
		{
			this.gameView.window.setVisible(false);
			this.gameView = new GameView(board, this);
		}
		endGame(board);
		
	}

	private void endGame(Board board) {
		Player current = null;
		for(int x = 0; x < 2; x++)
		{
			if(board.getPlayer(x).getID() == board.getTurn())
			{
				current = board.getPlayer(x);
			}
	
		}
		
		board.checkMateCheck(current);
		board.staleMateCheck(current);
		
		if(board.getDraw() == 0) System.out.print("Draw!\n");
		if(board.getWinner() == 0) System.out.print("White wins!\n");
		if(board.getWinner() == 1) System.out.print("Black wins!\n");
	}	
	
	public void undo()
	{
		System.out.print("Undo!");
		this.gameView.window.setVisible(false);
		this.gameView = new GameView(this.previous , this);
	}
	
	public void pressSurrender(Board board)
	{
		Player current = null;
		for(int x = 0; x < 2; x++)
		{
			if(board.getPlayer(x).getID() == board.getTurn())
			{
				current = board.getPlayer(x);
			}
	
		}
		
		board.surrender(current);
		if(board.getWinner() == 0)
		{
			System.out.print("White wins!\n");
			this.restart();
		}
		if(board.getWinner() == 1)
		{
			System.out.print("Black wins!\n");
			this.restart();
		}
	}
}

