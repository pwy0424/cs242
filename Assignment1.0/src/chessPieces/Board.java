package chessPieces;

public class Board {
	private Pieces[][] chessBoard;
	private Pieces[] whitePieces;
	private Pieces[] blackPieces;
	private int turn;//0 for white player, 1 for black player
	private int checked;//-1 means no one is being checked, 0 white player being checked, 1 black player, 2 means both
	private int winner;//-1 means no winner, 0 white player wins, 1 black
	
	public Board()
	{
		this.chessBoard = new Pieces[8][8];
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{	
				this.chessBoard[i][j] = null;
			}
		}
		this.whitePieces = new Pieces[16];
		this.blackPieces = new Pieces[16];
		for(int i = 0; i < 16; i++)
		{
			whitePieces[i] = null;
			blackPieces[i] = null;
		}
	}
	
	public int getWinner()
	{
		return this.winner;
	}
	
	public int getTurn()
	{
		return this.turn;
	}
	
	public int getChecked()
	{
		return this.checked;
	}
	
	public Pieces[] getWhitePieces()
	{
		return this.whitePieces;
	}
	
	public Pieces[] getBlackPieces()
	{
		return this.blackPieces;
	}
	
	public Pieces getWhitePiece(int i)
	{
		return this.whitePieces[i];
	}

	public Pieces getBlackPiece(int i)
	{
		return this.blackPieces[i];
	}
	
	public Pieces[][] getBoard()
	{
		return this.chessBoard;
	}
	
	public Pieces getPosition(int x, int y)
	{
		return this.chessBoard[x][y];
	}
	
	public void initBoard()
	{
		Rook rook_white_1     = new Rook(0,0,0);
		this.chessBoard[0][0] = rook_white_1;
		Knight knight_white_1 = new Knight(1,0,0);
		this.chessBoard[1][0] = knight_white_1;
		Bishop bishop_white_1 = new Bishop(2,0,0);
		this.chessBoard[2][0] = bishop_white_1;
		Queen queen_white     = new Queen(3,0,0);
		this.chessBoard[3][0] = queen_white;
		King king_white       = new King(4,0,0);
		this.chessBoard[4][0] = king_white;
		Bishop bishop_white_2 = new Bishop(5,0,0);
		this.chessBoard[5][0] = bishop_white_2;
		Knight knight_white_2 = new Knight(6,0,0);
		this.chessBoard[6][0] = knight_white_2;
		Rook rook_white_2     = new Rook(7,0,0);
		this.chessBoard[7][0] = rook_white_2;
		
		Pawn pawn_white_1 = new Pawn(0,1,0);
		this.chessBoard[0][1] = pawn_white_1;
		Pawn pawn_white_2 = new Pawn(1,1,0);
		this.chessBoard[1][1] = pawn_white_2;
		Pawn pawn_white_3 = new Pawn(2,1,0);
		this.chessBoard[2][1] = pawn_white_3;
		Pawn pawn_white_4 = new Pawn(3,1,0);
		this.chessBoard[3][1] = pawn_white_4;
		Pawn pawn_white_5 = new Pawn(4,1,0);
		this.chessBoard[4][1] = pawn_white_5;
		Pawn pawn_white_6 = new Pawn(5,1,0);
		this.chessBoard[5][1] = pawn_white_6;
		Pawn pawn_white_7 = new Pawn(6,1,0);
		this.chessBoard[6][1] = pawn_white_7;
		Pawn pawn_white_8 = new Pawn(7,1,0);
		this.chessBoard[7][1] = pawn_white_8;
		
		Rook rook_black_1     = new Rook(0,7,1);
		this.chessBoard[0][7] = rook_black_1;
		Knight knight_black_1 = new Knight(1,7,1);
		this.chessBoard[1][7] = knight_black_1;
		Bishop bishop_black_1 = new Bishop(2,7,1);
		this.chessBoard[2][7] = bishop_black_1;
		Queen queen_black       = new Queen(3,7,1);
		this.chessBoard[3][7] = queen_black;
		King king_black     = new King(4,7,1);
		this.chessBoard[4][7] = king_black;
		Bishop bishop_black_2 = new Bishop(5,7,1);
		this.chessBoard[5][7] = bishop_black_2;
		Knight knight_black_2 = new Knight(6,7,1);
		this.chessBoard[6][7] = knight_black_2;
		Rook rook_black_2     = new Rook(7,7,1);
		this.chessBoard[7][7] = rook_black_2;
		
		Pawn pawn_black_1 = new Pawn(0,6,1);
		this.chessBoard[0][6] = pawn_black_1;
		Pawn pawn_black_2 = new Pawn(1,6,1);
		this.chessBoard[1][6] = pawn_black_2;
		Pawn pawn_black_3 = new Pawn(2,6,1);
		this.chessBoard[2][6] = pawn_black_3;
		Pawn pawn_black_4 = new Pawn(3,6,1);
		this.chessBoard[3][6] = pawn_black_4;
		Pawn pawn_black_5 = new Pawn(4,6,1);
		this.chessBoard[4][6] = pawn_black_5;
		Pawn pawn_black_6 = new Pawn(5,6,1);
		this.chessBoard[5][6] = pawn_black_6;
		Pawn pawn_black_7 = new Pawn(6,6,1);
		this.chessBoard[6][6] = pawn_black_7;
		Pawn pawn_black_8 = new Pawn(7,6,1);
		this.chessBoard[7][6] = pawn_black_8;
		
		for(int i = 0; i < 16; i++)
		{
			if(i < 8)//pieces other than pawns
			{
				whitePieces[i] = this.chessBoard[i][0];
				blackPieces[i] = this.chessBoard[i][7];
			}
			else//pawns
			{
				whitePieces[i] = this.chessBoard[i-8][1];
				blackPieces[i] = this.chessBoard[i-8][6];
			}
		}
		
		this.turn = 0;
		this.checked = -1;
		this.winner = -1;
	}
	
	public int movePiece(Pieces piece, int newx, int newy)//-1 for invalid move, 0 for valid move
	{
		if(piece.getColor() != this.turn)//in one's turn, he/she can only move his/her pieces
		{
			//todo: show invalid warning in GUI
			return -1;
		}
		int currentX = piece.getX();
		int currentY = piece.getY();
		
		if(newx < 8 && newx >= 0 && newy < 8 && newy >=0)//not out of bound
		{
			boolean[][] moveable_block = piece.moveable(this);
			if(!moveable_block[newx][newy])//new position invalid to move to
			{
				//todo: show invalid warning in GUI
				return -1;
			}
			else
			{
				Pieces[][] currentBoard = this.chessBoard;//temp variable to save the current status
				if(this.chessBoard[newx][newy] == null)//new position empty
				{
					this.chessBoard[currentX][currentY] = null;
					this.chessBoard[newx][newy] = piece;
					piece.setPosition(newx, newy);
				}
				else//new position with an enemy piece
				{
					this.chessBoard[currentX][currentY] = null;
					this.chessBoard[newx][newy].setPosition(-1, -1);//reminder, -1,-1 means dead piece
					this.chessBoard[newx][newy] = piece;
					piece.setPosition(newx, newy);
				}
				/**
				 * check if this move will cause the player himself/herself being checked
				 * if so, this is an invalid move
				 */
				if(isCheck() == this.turn || isCheck() == 2)//this move will cause the player himself being checked
				{
					this.chessBoard = currentBoard;//undo the move
					/**
					 * todo£ºshow invalid move warning in GUI
					 */
					return -1;
				}
				else if(isCheck() == 0)
				{
					turn = (turn+1) % 2;
					return 0;
				}
				else
				{
					turn = (turn+1) % 2;
					
					this.checked = isCheck();
					/**
					 * todo: show "checkmate!" warning in GUI
					 */
					
					return 0;
				}
			}
		}
		else return -1;//out of bound
	}

	/**
	 * function to examine the current status of the board,
	 * is someone be in a checked state?
	 * 
	 * @return
	 * -1 means no one is being checked, 0 white player being checked, 1 black player, 2 means both
	 */
	public int isCheck() {
		int result = -1;
		int white_king_x = whitePieces[4].getX();
		int white_king_y = whitePieces[4].getY();
		int black_king_x = blackPieces[4].getX();
		int black_king_y = blackPieces[4].getY();
		
		for(int i = 0; i < 16; i++)//can white pieces attack black king?
		{
			Pieces currentPiece = whitePieces[i];
			if(currentPiece.getX() != -1 && currentPiece.getY() != -1)
			{
				boolean[][] moveable_block = this.whitePieces[i].moveable(this);
				if(moveable_block[black_king_x][black_king_y])
				{
					result = 1;
					break;
				}
			}
		}
		
		for(int i = 0; i < 16; i++)//can black pieces attack white king?
		{
			boolean[][] moveable_block = this.blackPieces[i].moveable(this);
			if(moveable_block[white_king_x][white_king_y])
			{
				if(result == -1) result = 0;
				else result = 2;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * for now: king being killed
	 * 
	 * 
	 * @return
	 */
	public void endGame()
	{
		if(whitePieces[4].getX() == -1 && whitePieces[4].getY() == -1) this.winner = 1;
		if(blackPieces[4].getX() == -1 && blackPieces[4].getY() == -1) this.winner = 0;
		
		return;
	
	}
	
	/**
	 * 
	 * @param color
	 * means who surrendered,
	 * set winner to the other player
	 */
	public void surrender(int color)
	{
		this.winner = (color+1) % 2;
		
		return;
	}
	

}