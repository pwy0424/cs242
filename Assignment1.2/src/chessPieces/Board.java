package chessPieces;

public abstract interface Board {
	
	public abstract int getTurn();
	public abstract void initBoard();
	public abstract int getWinner();
	public abstract int movePiece(Pieces piece, int newx, int newy);
	public abstract void surrender(Player player);
	public abstract Pieces getPosition(int x, int y);
	public abstract Player[] getPlayers();
	public abstract Player getPlayer(int i);
	public abstract void setPosition(Pieces piece, int x, int y);
	public abstract int getChecked();
	public abstract void checkMateCheck(Player current);
	public abstract void staleMateCheck(Player current);
	public abstract int getDraw();
}
