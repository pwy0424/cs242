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
	private int color;//0 stands for white, 1 stands for black
	
	public Pieces(int x, int y, int color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	abstract boolean[][] moveable(Board board);
	
	//get functions
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public int getColor()
	{
		return this.color;
	}
	
	//set functions
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void setColor(int color)
	{
		this.color = color;
	}
}	

