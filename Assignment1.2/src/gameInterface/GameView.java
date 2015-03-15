package gameInterface;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GameView {
	
	public JPanel view;
	public JFrame window;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public JPanel getView()
	{
		return this.view;
	}
	
	/**
	 * 
	 * @param board
	 */
	public GameView(Board board, GameControl game){
		JPanel view = initPanel();
		this.view = view;
		JFrame window = new JFrame("Chess Game");	
		this.window = window;
		
		view.setLayout(new GridLayout(8,8));
		
		for(int j = 7; j > -1; j--)
		{
			for(int i = 0; i < 8; i++)
			{
				addPiece(board.getPosition(i, j), view, i, j, game, board);
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
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	
	/**
	 * 
	 * @param piece
	 * @param view
	 */
	public void addPiece(final Pieces piece, JPanel view, final int i, final int j, final GameControl game, final Board board) {
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
			pieceImage.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	                //Execute when button is pressed
	                game.clickMove(i, j, board);
	            }
	        });   
			view.add(pieceImage);
			return;
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
		pieceImage.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                if(game.getSelectedPiece() == null || game.getSelectedPiece() == piece) game.clickSelect(piece, board);
                else game.clickMove(i, j, board);
            }
        });      
		pieceImage.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == 'r') game.restart();
				if(e.getKeyChar() == 'u') game.undo();
				if(e.getKeyChar() == 's') game.pressSurrender(board);
			}
			@Override
			public void keyReleased(KeyEvent e) 
			{
					
			}
			@Override
			public void keyTyped(KeyEvent e) 
			{
					
			}	
		});
		pieceImage.setPreferredSize(new Dimension(75, 75));
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
