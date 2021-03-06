package chessPieces;


/**
 *  
 * @author Weiyang
 * This kind of pieces move just as queen, but when it try to capture an opponent's piece, it won't move itself towards that location.
 * It will remain its current location and just kill that opponent's piece.
 */
public class Cannon extends Pieces{

	public Cannon(int x, int y, Player player) {
		super(x, y, player);
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
		boolean blocked = false;//falg to control the while loop
		while(!blocked)
		{
			newx = newx+1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newy = newy+1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newy = newy-1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx+1;
			newy = newy+1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-1;
			newy = newy+1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx+1;
			newy = newy-1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-1;
			newy = newy-1;//go one step towards a certain direction
			blocked = moveable_helper_cannon(board, result, player, newx, newy,
					blocked);
		}
		
		return result;
	}

	private boolean moveable_helper_cannon(Board board, boolean[][] result,
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
