package chessPieces;

public class Knight extends Pieces{

	public Knight(int x, int y, int color) {
		super(x, y, color);
	}

	@Override
	boolean[][] moveable(Board board) {
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
		int newy = y+2;
		moveable_helper_knight(result, color, newx, newy, board);
		
		newx = x+1;
		newy = y-2;
		moveable_helper_knight(result, color, newx, newy, board);
		
		newx = x-1;
		newy = y+2;
		moveable_helper_knight(result, color, newx, newy, board);
		
		newx = x-1;
		newy = y-2;
		moveable_helper_knight(result, color, newx, newy, board);
		
		newx = x+2;
		newy = y+1;
		moveable_helper_knight(result, color, newx, newy, board);
		
		newx = x+2;
		newy = y-1;
		moveable_helper_knight(result, color, newx, newy, board);
		
		newx = x-2;
		newy = y+1;
		moveable_helper_knight(result, color, newx, newy, board);
		
		newx = x-2;
		newy = y-1;
		moveable_helper_knight(result, color, newx, newy, board);
		
		return result;
	}

	private void moveable_helper_knight(boolean[][] result, int color, int newx, int newy, Board board) {
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
