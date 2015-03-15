package chessPieces;

/**
 * 
 * @author Weiyang
 *
 * A piece that can move in 8 direcrtions just as queen. But it move 2 blocks a time, and can hop over other piece, it that piece is 
 * not in each of its foothold blocks.
 */
public class HopperQueen extends Pieces{

	public HopperQueen(int x, int y, Player player) {
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
			newx = newx+2;//go one step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newy = newy+2;//go 2 step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-2;//go one step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newy = newy-2;//go one step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx+2;
			newy = newy+2;//go one step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-2;
			newy = newy+2;//go one step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx+2;
			newy = newy-2;//go one step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		newx = x;
		newy = y;
		blocked = false;
		while(!blocked)
		{
			newx = newx-2;
			newy = newy-2;//go one step towards a certain direction
			blocked = moveable_helper_hopperqueen(board, result, player, newx, newy,
					blocked);
		}
		
		return result;
	}

	private boolean moveable_helper_hopperqueen(Board board, boolean[][] result,
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
