package chessPieces;

public class King extends Pieces{

	public King(int x, int y, int color)
	{
		super(x, y, color);
	}
	
	@Override
	public boolean[][] moveable(Board board) {
		boolean[][] result = new boolean[8][8];
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{	
				result[i][j] = false;
			}
		}
		
		int x = this.getX();
		int y = this.getY();
		int color = this.getColor();
		
		int newx = x+1;
		int newy = y;
		moveable_helper_king(result, color, newx, newy, board);
		//helper function, see below
		
		//8 directions
		newx = x-1;
		newy = y;
		moveable_helper_king(result, color, newx, newy, board);
		
		newx = x;
		newy = y+1;
		moveable_helper_king(result, color, newx, newy, board);
		
		newx = x;
		newy = y-1;
		moveable_helper_king(result, color, newx, newy, board);
		
		newx = x+1;
		newy = y+1;
		moveable_helper_king(result, color, newx, newy, board);
		
		newx = x-1;
		newy = y-1;
		moveable_helper_king(result, color, newx, newy, board);
		
		newx = x+1;
		newy = y-1;
		moveable_helper_king(result, color, newx, newy, board);
		
		newx = x-1;
		newy = y+1;
		moveable_helper_king(result, color, newx, newy, board);
		
		return result;
	}
	
	/**
	 * 
	 * @param result
	 * @param color
	 * @param newx
	 * @param newy
	 * @param board
	 * 
	 * helper function to handle different situation for new position
	 */
	private void moveable_helper_king(boolean[][] result, int color, int newx, int newy, Board board) {
		if(newx < 8 && newx >= 0 && newy < 8 && newy >=0)//newx or newy out of bound or not?
		{
			//new position is empty
			if(board.getPosition(newx, newy) == null)
			{
				result[newx][newy] = true;
			}
			//new position with an enemy piece
			else if(board.getPosition(newx, newy).getColor() != color)
			{
				result[newx][newy] = true;
			}
		}
	}
}
