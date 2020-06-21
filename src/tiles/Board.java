package tiles;

import java.awt.Color;
import java.util.ArrayList;

public class Board {
	private ArrayList<Tile> tiles;
	private ArrayList<Player> players;
	private static Board singleton = new Board();
	
	private Board() {
		tiles = new ArrayList<Tile>();
		players = new ArrayList<Player>();
	}
	
	public static Board getInstance() {return singleton;}
	
	public ArrayList<Tile> getTiles(){return tiles;}
	public ArrayList<Player> getPlayers(){return players;}
	public int findNextTileOfColor(Color c, Player p) {
		if(p.getPosition() != tiles.size()-1) {
			for(int i = p.getPosition()+1; i < tiles.size(); i++) {
				if(tiles.get(i).getColor().equals(c)) {
					return i;
				}
			}
		}
		return -1;
			
	}
	
	public void addTile(Tile t) {tiles.add(t);}
	public void addPlayer(Player p) {players.add(p);}
	
}
