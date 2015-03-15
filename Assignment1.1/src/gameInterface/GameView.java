package gameInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chessPieces.Bishop;
import chessPieces.Board;
import chessPieces.Cannon;
import chessPieces.HopperQueen;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Pieces;
import chessPieces.Queen;
import chessPieces.Rook;
import chessPieces.StandardBoard;

public class GameView {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardBoard test = new StandardBoard();
        test.initBoard();
    	new GameView(test);
	}
	
	/**
	 * 
	 * @param board
	 */
	public GameView(Board board){
		JPanel view = initPanel();
		JFrame window = new JFrame("Chess Game");	
		//File imageFile = new File("images/StandardBoard.jpg");
		//BufferedImage bufferedImage = null;
		/*
		try {
			bufferedImage = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JLabel boardImage = new JLabel(new ImageIcon(bufferedImage)); //get the chess board image
		
		/**
		 * add pieces to the screen
		 */
		
		view.setLayout(new GridLayout(8,8));
		
		for(int j = 7; j > -1; j--)
		{
			for(int i = 0; i < 8; i++)
			{
				addPiece(board.getPosition(i, j), view, i, j);
			}
		}

		
		/**
		 * TODO: change to grid layout system
		 * instead of absolute positioning
		 */
		//view.add(boardImage);//add chess board to the screen
		
		window.setSize(625, 650);


		window.setContentPane(view);
		//window.setResizable(false);
        window.setVisible(true);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	
	/**
	 * 
	 * @param piece
	 * @param view
	 */
	private void addPiece(Pieces piece, JPanel view, int i, int j) {
		// TODO Auto-generated method stub
		/**
		 * find out what kind is the piece and find the right image
		 */
		String filename = "images/";
		if(piece == null)
		{
			JButton pieceImage = new JButton();
			if((i+j)%2 == 0) pieceImage.setBackground(Color.white);
			else pieceImage.setBackground(Color.black);
			view.add(pieceImage);
			return;
			//if((i+j)%2 == 0) filename += "white";
			//else filename += "black";
		}
		else 
		{
			filename+="chess_piece_";
			if(piece.getPlayer().getID() == 0) filename += "white_";
			else if(piece.getPlayer().getID() == 1) filename += "black_";
		
			if(piece instanceof Bishop) filename += "bishop";
			else if (piece instanceof King) filename += "king";
			else if (piece instanceof Knight) filename += "knight";
			else if (piece instanceof Pawn) filename += "pawn";
			else if (piece instanceof Queen || piece instanceof HopperQueen) filename += "queen";
			else if (piece instanceof Rook || piece instanceof Cannon) filename += "rook";
		}
		
		
		filename += ".png";
		
		File imageFile = new File(filename);
		BufferedImage bufferedImage = null;
		
		try {
			bufferedImage = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton pieceImage = new JButton(new ImageIcon(bufferedImage)); 
		pieceImage.setPreferredSize(new Dimension(75, 75));
		//Dimension size = pieceImage.getPreferredSize();
		/**
		 * Use piece X and Y to calculate the position it need to be on screen
		 */
		//int x = 10 + 75 * piece.getX();
		//int y = 532 - 75 * piece.getY();
    	//pieceImage.setBounds(x,y,size.width, size.height);

		view.add(pieceImage);
		
	}

	private JPanel initPanel() 
	{
		JPanel result = new JPanel();
        result.setPreferredSize(new Dimension(600,600));
        result.setLayout(new BorderLayout());

		return result;
	}
	
}
