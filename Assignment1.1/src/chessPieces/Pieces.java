package chessPieces;

/**
 * 
 * @author Weiyang
 * 
 * Pieces class, contains the position and color 
 * information for each pieces. 
 * Different type of pieces have their own class.
 */

public abstract class Pieces 
{
	private int x;
	private int y;//-1,-1 means a dead piece
	private Player player;//which side/player/color this pieces belong to
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param player
	 */
	public Pieces(int x, int y, Player player)
	{
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	/**
	 * 
	 * @param board
	 * @return table of boolean
	 */
	abstract boolean[][] moveable(Board board);
	
	//get functions
	/**
	 * 
	 * @return X
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * 
	 * @return Y
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * 
	 * @return Player
	 */
	public Player getPlayer()
	{
		return this.player;
	}
	
	//set functions
	/**
	 * 
	 * @param x
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param player
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
	}
}	

