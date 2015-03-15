package chessPieces;

public class Bishop extends Pieces{

	public Bishop(int x, int y, Player color) {
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
		Player player = this.getPlayer();
		
		int newx = x;
		int newy = y;
		boolean blocked = false;
		while(!blocked)
		{
			newx = newx+1;
			newy = newy+1;//go one step towards a certain direction
			blocked = moveable_helper_bishop(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-1;
			newy = newy+1;//go one step towards a certain direction
			blocked = moveable_helper_bishop(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx+1;
			newy = newy-1;//go one step towards a certain direction
			blocked = moveable_helper_bishop(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-1;
			newy = newy-1;//go one step towards a certain direction
			blocked = moveable_helper_bishop(board, result, player, newx, newy,
					blocked);
		}
		
		return result;
	}
	
	private boolean moveable_helper_bishop(Board board, boolean[][] result,
			Player player, int newx, int newy, boolean blocked) {
		if(newx < 8 && newx >= 0 && newy < 8 && newy >=0)//not out of bound
		{
			if(board.getPosition(newx, newy) == null)//new position empty
			{
				result[newx][newy] = true;
			}
			else if(board.getPosition(newx, newy).getPlayer() != player)//new position with an enemy piece
			{
				result[newx][newy] = true;
				blocked = true;
			}
			else blocked = true;//not empty, not enemy piece, then new position has an allied piece
		}
		else blocked = true;
		return blocked;
	}
}
