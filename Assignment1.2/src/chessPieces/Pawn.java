package chessPieces;

public class Pawn extends Pieces{
	public Pawn(int x, int y, Player player)
	{
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
		
		if(player.getID() == 0)//it's a white pawn and starts in lower half, going upwards
		{
			int newx = x;
			int newy = y+1;//moving ahead
			if(newx < 8 && newx >= 0 && newy < 8 && newy >=0)//newx or newy out of bound or not?
			{
				if(board.getPosition(newx, newy) == null)//new position is empty
				{
					result[newx][newy] = true;
					if(y == 1)//not moved yet
					{
						newy = y+2;
						if(board.getPosition(newx, newy) == null)//empty 2 blocks ahead
						{
							result[newx][newy] = true;
						}
					}
				}
			}
			
			//capturing enemy pieces
			newx = x+1;
			newy = y+1;
			moveable_helper_pawn(board, result, player, newx, newy);
			
			newx = x-1;
			newy = y+1;
			
			moveable_helper_pawn(board, result, player, newx, newy);
			
		}
		
		if(player.getID() == 1)//it's a black pawn and starts in upper half, going downwards
		{
			int newx = x;
			int newy = y-1;//moving ahead
			if(newx < 8 && newx >= 0 && newy < 8 && newy >=0)//newx or newy out of bound or not?
			{
				if(board.getPosition(newx, newy) == null)//new position is empty
				{
					result[newx][newy] = true;
					if(y == 6)//not moved yet
					{
						newy = y-2;
						if(board.getPosition(newx, newy) == null)//empty 2 blocks ahead
						{
							result[newx][newy] = true;
						}
					}
				}
			}
			
			//capturing enemy pieces
			newx = x+1;
			newy = y-1;
			moveable_helper_pawn(board, result, player, newx, newy);
			
			newx = x-1;
			newy = y-1;
			
			moveable_helper_pawn(board, result, player, newx, newy);
			
		}
			
		return result;
	}

	private void moveable_helper_pawn(Board board, boolean[][] result,
			Player player, int newx, int newy) {
		if(newx < 8 && newx >= 0 && newy < 8 && newy >=0)
		{
			//new position filled with an enemy piece
			if(board.getPosition(newx, newy) != null && board.getPosition(newx, newy).getPlayer() != player)
			{
				result[newx][newy] = true;
			}
		}
	}
}
