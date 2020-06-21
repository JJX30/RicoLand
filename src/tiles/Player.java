package tiles;

import java.awt.Color;

public class Player {
	private static final Color[] PLAYER_COLORS = new Color[] {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
	private int position;
	private int number;
	
	public Player(int num) {
		number = num;
		Board.getInstance().addPlayer(this);
	}
	
	public Color getColor() {return PLAYER_COLORS[number];}
	public int getPosition() {return position;}
	
	public void move(int i) {position += i;}
	
	public void moveToColor(Color c) {
		if(Board.getInstance().findNextTileOfColor(c, this) != -1) {
			position = Board.getInstance().findNextTileOfColor(c, this);
		}
	}
	
}
