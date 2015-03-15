package chessPieces;

public class Player {
	private Pieces[] myPieces;
	private String playerName;
	private int ID;
	private int isLose;//-1 means not lost yet, 0 mean lost
	
	public Player(int ID)
	{
		this.ID = ID;
		this.isLose = -1;
		this.playerName = "Player"+ID;
	}
	
	public Player(int ID, String name)
	{
		this.ID = ID;
		this.isLose = -1;
		this.playerName = name;
	}
	
	
	/**
	 * 
	 * @return this Player's Pieces list
	 */
	public Pieces[] getPieces()
	{
		return this.myPieces;
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public Pieces getPiece(int i)
	{
		return this.myPieces[i];
	}
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return this.playerName;
	}
	
	/**
	 * 
	 * @return this player lost or not
	 */
	public int getIsLose()
	{
		return this.isLose;
	}
	
	/**
	 * 
	 * @return this Player's ID
	 */
	public int getID()
	{
		return this.ID;
	}
	
	/**
	 * 
	 * @param pieces
	 */
	public void setPieces(Pieces[] pieces)
	{
		this.myPieces = pieces;
	}
	
	/**
	 * 
	 * @param piece
	 * @param i
	 */
	public void setPiece(Pieces piece, int i)
	{
		this.myPieces[i] = piece;
	}
	
	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public void setLose()
	{
		this.isLose = 0;
	}
	
	public void setName(String name)
	{
		this.playerName = name;
	}
}
