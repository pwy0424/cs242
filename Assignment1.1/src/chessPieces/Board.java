package chessPieces;

public abstract class Board {
	
	public abstract int getWinner();
	public abstract int movePiece(Pieces piece, int newx, int newy);
	public abstract void surrender(Player player);
	public abstract Pieces getPosition(int x, int y);
	public abstract Player[] getPlayers();
	public abstract Player getPlayer(int i);
	public abstract void setPosition(Pieces piece, int x, int y);
}
