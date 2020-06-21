package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Tile {
	private final static ImageIcon DEFAULT_IMG = new ImageIcon(pics.EmptyClass.class.getResource("lolxd.png"));
	private Color color;
	private ImageIcon img;
	private int x;
	private int y;
	private int order;
	
	public Tile(int x, int y, Color color) {
		this(x, y, DEFAULT_IMG, color);
	}
	
	public Tile(int x, int y, ImageIcon img, Color color) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.color = color;
		Board.getInstance().addTile(this);
	}
	
	public ImageIcon getImage() {return img;}
	public void setImage(ImageIcon imageIcon) {img = imageIcon;};
	public Color getColor() {return color;}
	public int getX() {return x;}
	public int getY() {return y;}

}
