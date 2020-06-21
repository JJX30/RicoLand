package pkg1;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;


import tiles.Board;
import tiles.Player;
import tiles.Tile;

public class GameScreen extends JFrame{

	private static final int TILE_SIZE = 50;
	private ImageIcon BOARD = new ImageIcon(pics.EmptyClass.class.getResource("newScaledRicoLand.png"));
	private static final ImageIcon TILECOLOR_1 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("tile1.png"))));
	private static ImageIcon TILECOLOR_2 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("tile2.png"))));
	private static ImageIcon TILECOLOR_3 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("tile3.png"))));
	private static ImageIcon WARPCAVE_1 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("ricoWarpCaveTile1.png"))));
	private static ImageIcon WARPDESERT_1 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("ricoDeserttile1.png"))));
	private static ImageIcon WARPLAIR_2 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("ricoLairtile2.png"))));
	private static ImageIcon SKIPTURN_1 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("ricoSpikestile1.png"))));
	private static ImageIcon SKIPTURN_2 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("ricoSpikestile2.png"))));
	private static ImageIcon SKIPTURN_3 = new ImageIcon(scaleImage(new ImageIcon(pics.EmptyClass.class.getResource("ricoSpikestile3.png"))));
	
	private int playerTurn = 0;
	
	private JPanel _masterPanel;
	private JLabel _infoBox = new JLabel("Press the Button To BEGIN!");
	private JButton _pickCard = new JButton();
	
	private final static SoundPlayer warpSound = new SoundPlayer("Enderman Teleport [Minecraft] [Ultimate Sound Effects].wav");
	private final static SoundPlayer stickySound = new SoundPlayer("Roblox Death Sound - OOF  Sound Effect.wav");
	private final static SoundPlayer winSound = new SoundPlayer("Bruh Sound Effect 2.wav");

	
	
	public GameScreen() {
		super("RicoLand");

		
		new Tile(0, 7, TILECOLOR_1, Color.RED);
		new Tile(1, 7, TILECOLOR_2, Color.BLUE);
		new Tile(2, 7, TILECOLOR_3, Color.GREEN);
		new Tile(2, 6, TILECOLOR_1, Color.RED);
		new Tile(2, 5, TILECOLOR_2, Color.BLUE);
		new Tile(2, 4, SKIPTURN_3, Color.GREEN);
		new Tile(2, 3, WARPCAVE_1, Color.RED);
		new Tile(1, 3, TILECOLOR_2, Color.BLUE);
		new Tile(1, 2, TILECOLOR_3, Color.GREEN);
		new Tile(1, 1, TILECOLOR_1, Color.RED);
		new Tile(2, 1, TILECOLOR_2, Color.BLUE);
		new Tile(2, 0, TILECOLOR_3, Color.GREEN);
		new Tile(3, 0, TILECOLOR_1, Color.RED);
		new Tile(4, 0, TILECOLOR_2, Color.BLUE);
		new Tile(4, 1, TILECOLOR_3, Color.GREEN);
		new Tile(4, 2, TILECOLOR_1, Color.RED);
		new Tile(4, 3, SKIPTURN_2, Color.BLUE);
		new Tile(5, 3, TILECOLOR_3, Color.GREEN);
		new Tile(5, 4, TILECOLOR_1, Color.RED);
		new Tile(5, 5, TILECOLOR_2, Color.BLUE);
		new Tile(4, 5, TILECOLOR_3, Color.GREEN);
		new Tile(4, 6, WARPDESERT_1, Color.RED);
		new Tile(4, 7, TILECOLOR_2, Color.BLUE);
		new Tile(5, 7, TILECOLOR_3, Color.GREEN);
		new Tile(6, 7, SKIPTURN_1, Color.RED);
		new Tile(7, 7, TILECOLOR_2, Color.BLUE);
		new Tile(7, 6, TILECOLOR_3, Color.GREEN);
		new Tile(8, 6, TILECOLOR_1, Color.RED);
		new Tile(8, 5, TILECOLOR_2, Color.BLUE);
		new Tile(8, 4, TILECOLOR_3, Color.GREEN);
		new Tile(8, 3, SKIPTURN_1, Color.RED);
		new Tile(7, 3, TILECOLOR_2, Color.BLUE);
		new Tile(7, 2, TILECOLOR_3, Color.GREEN);
		new Tile(7, 1, TILECOLOR_1, Color.RED);
		new Tile(7, 0, TILECOLOR_2, Color.BLUE);
		new Tile(8, 0, TILECOLOR_3, Color.GREEN);
		new Tile(9, 0, TILECOLOR_1, Color.RED);
		new Tile(9, 1, TILECOLOR_2, Color.BLUE);
		new Tile(10, 1, TILECOLOR_3, Color.GREEN);
		new Tile(10, 2, TILECOLOR_1, Color.RED);
		new Tile(10, 3, SKIPTURN_2, Color.BLUE);
		new Tile(10, 4, TILECOLOR_3, Color.GREEN);
		new Tile(10, 5, TILECOLOR_1, Color.RED);
		new Tile(10, 6, WARPLAIR_2, Color.BLUE);
		new Tile(11, 6, TILECOLOR_3, Color.GREEN);
		new Tile(11, 7, TILECOLOR_1, Color.RED);
		new Tile(12, 7, TILECOLOR_2, Color.BLUE);
		new Tile(13, 7, TILECOLOR_3, Color.GREEN);
		new Tile(13, 6, SKIPTURN_1, Color.RED);
		new Tile(13, 5, TILECOLOR_2, Color.BLUE);
		new Tile(13, 4, TILECOLOR_3, Color.GREEN);
		new Tile(12, 4, SKIPTURN_1, Color.RED);
		new Tile(12, 3, TILECOLOR_2, Color.BLUE);
		new Tile(12, 2, SKIPTURN_3, Color.GREEN);
		new Tile(12, 1, TILECOLOR_1, Color.RED);
		new Tile(12, 0, TILECOLOR_2, Color.BLUE);
		new Tile(13, 0, TILECOLOR_3, Color.GREEN);
		new Tile(14, 0, SKIPTURN_1, Color.RED);
		new Tile(15, 0, TILECOLOR_2, Color.BLUE);
		new Tile(15, 1, TILECOLOR_3, Color.GREEN);
		new Tile(15, 2, TILECOLOR_1, Color.RED);
		new Tile(15, 3, TILECOLOR_2, Color.BLUE);
		new Tile(15, 4, SKIPTURN_3, Color.GREEN);
		new Tile(15, 5, TILECOLOR_1, Color.RED);
		new Tile(15, 6, TILECOLOR_2, Color.BLUE);
		new Tile(15, 7, TILECOLOR_3, Color.GREEN);
		new Tile(16, 7, SKIPTURN_1, Color.RED);
		new Tile(17, 7, TILECOLOR_2, Color.BLUE);
		new Tile(17, 6, TILECOLOR_3, Color.GREEN);
		new Tile(17, 5, TILECOLOR_1, Color.RED);
		new Tile(17, 4, TILECOLOR_2, Color.BLUE);
		new Tile(17, 3, TILECOLOR_3, Color.GREEN);
		new Tile(17, 2, TILECOLOR_1, Color.RED);
		new Tile(17, 1, TILECOLOR_2, Color.BLUE);

		if(TitleScreen.numPlayers == 2) {
			new Player(0);
			new Player(1);
		}
		if(TitleScreen.numPlayers == 3) {
			new Player(0);
			new Player(1);
			new Player(2);
		}
		if(TitleScreen.numPlayers == 4) {
			new Player(0);
			new Player(1);
			new Player(2);
			new Player(3);
		}
				

		
		
		_masterPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D)g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.drawImage(BOARD.getImage(), 0, 0, null);
				AlphaComposite ac1 = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER);
			    g2d.setComposite(ac1);
				for(int i = 0; i < Board.getInstance().getTiles().size(); i++) {
					g2d.drawImage(Board.getInstance().getTiles().get(i).getImage().getImage(), Board.getInstance().getTiles().get(i).getX()*TILE_SIZE, 
							Board.getInstance().getTiles().get(i).getY()*TILE_SIZE, null);
				}
				AlphaComposite ac2 = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
			    g2d.setComposite(ac2);
				for(int i = 0; i < Board.getInstance().getPlayers().size(); i++) {
					g2d.setColor(Board.getInstance().getPlayers().get(i).getColor());
					g2d.fillOval(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(i).getPosition()).getX()*TILE_SIZE+TILE_SIZE/4, 
							Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(i).getPosition()).getY()*TILE_SIZE+TILE_SIZE/4, TILE_SIZE/2, TILE_SIZE/2);
				}
			}
		};
		_masterPanel.setLayout(new GridLayout(20,23));
		add(_masterPanel);
		for(int i = 0; i < 18; i++)
			_masterPanel.add(new JLabel());
		
		_masterPanel.add(_infoBox);
		_masterPanel.add(_pickCard);
		
		
		
		_pickCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "KING RICO™ IS DEATHLY ILL, AND HE NEED YOUR HELP!"+"\n" 
														+"THE FIRST ONE TO GET TO HIM WILL HEIR HIS THRONE AND CONTORL ALL OF RICO LAND™!" +"\n"+"BUT WAIT" + "\n"+
															"EVIL RICO™ IS TRYING TO STOP YOU FROM GETTING TO KING RICO™!"+"\n"+ "WILL YOU BE THE HEIR TO THE RICO THRONE™!?!?!?"
															+"\n"+"Journey across RicoLand™ and be the first to get to King Rico™!" + "\n" +
															"p.s. be weary of stepping in Evil Rico's BindingSpikes™, these will slow you down™!");
			
				_infoBox.setText(namePlayers() +"'s Turn(he's " + ColorofPlayer() +" btw) click button to pick a Card!");
				_pickCard.removeActionListener(_pickCard.getActionListeners()[0]);
				_pickCard.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Color c = randomColor();
						
						if(WarpTile()) {
							System.out.println("fsdnakfs");
							warpSound.setVolume(1.0);
							warpSound.playSound();
							JOptionPane.showMessageDialog(null, "YOU LANDED ON A WARP TILE WOW!! YOU ARE TELEPORTED TO "+nameWarp() +"WOW CONGRATS!");
							Warp();
							
							
							if(StickyTile()) {
								stickySound.setVolume(1.0);
								stickySound.playSound();
								JOptionPane.showMessageDialog(null, "Uh oh you landed on a StickyTile™, you will lose a turn!!!!!");
								Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).setImage(WhichImage());
								
							}
							
						}
						else if(StickyTile()) {
							System.out.println("fsdnakfs");
							stickySound.setVolume(1.0);
							stickySound.playSound();
							JOptionPane.showMessageDialog(null, "Uh oh you landed on a StickyTile™, you will lose a turn!!!!!");
							System.out.println(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage());
							Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).setImage(WhichImage());
							System.out.println(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage());
							_masterPanel.repaint();
							
						}else{
							
							Board.getInstance().getPlayers().get(playerTurn).moveToColor(c);
							JOptionPane.showMessageDialog(null, namePlayers()+ " will move to the " +nameRandColor(c)+" tile");
							win();
						}
						
						
						if(playerTurn < Board.getInstance().getPlayers().size()-1) {
							playerTurn++;
						}else {
							playerTurn = 0;
						}
						_masterPanel.repaint();
						_infoBox.setText(namePlayers() +"'s Turn(he's " + ColorofPlayer() +" btw) click button to pick a Card!");
						System.out.println(playerTurn);
						
					}
					
				});
			}
			

		});
		
	}
	
	public Color randomColor() {
		Color[] randColor = {Color.RED, Color.BLUE, Color.GREEN};
		return randColor[(int) (Math.random()*randColor.length)];
	}
	
	public String nameRandColor(Color c) {
		if(c.equals(Color.RED)) {
			return "Purple";
		}
		if(c.equals(Color.BLUE)) {
			return "Light Blue";
		}
		if(c.equals(Color.GREEN)) {
			return "Orange";
		}
		return null;
	}
	
	public String namePlayers() {
		if(playerTurn == 0) {
			return "Player 1";
		}
		if(playerTurn == 1) {
			return "Player 2";
		}
		if(playerTurn == 2){
			return "Player 3";
		}
		if(playerTurn == 3) {
			return "Player 4";
		}
		return null;
	}
	
	public String ColorofPlayer() {
		if(playerTurn == 0) {
			return "Red";
			
		}
		if(playerTurn == 1) {
			return "Blue";
			
		}
		if(playerTurn == 2) {
			return "Green";
			
		}
		if(playerTurn == 3) {
			return "Yellow";
			
		}
		return null;
		
	}
	
	public boolean StickyTile() {
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(SKIPTURN_1)) {
			return true;
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(SKIPTURN_2)) {
			return true;
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(SKIPTURN_3)) {
			return true;
		}
		return false;
		
	}
	
	public boolean WarpTile() {
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPCAVE_1)) {
			return true;
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPDESERT_1)) {
			return true;
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPLAIR_2)) {
			return true;
		}
		
		return false;
		
	}
	public String nameWarp(){
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPCAVE_1)) {
			return "RICO CAVERNS";
		}
		
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPDESERT_1)) {
			return "RICO DESERT";
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPLAIR_2)) {
			return "RICO'S LAIR";
		}
		return null;
	}
	
	public ImageIcon WhichImage() {
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(SKIPTURN_1)) {
			System.out.println("tile 1");
			
			
			return TILECOLOR_1;
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(SKIPTURN_2)) {
			System.out.println("tile 2");
			return TILECOLOR_2;
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(SKIPTURN_3)) {
			System.out.println("tile 3");
			return TILECOLOR_3;
		}
		return null;
		
	}
	
	public void Warp() {
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPCAVE_1)) {
			Board.getInstance().getPlayers().get(playerTurn).move(7); 
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPDESERT_1)) {
			Board.getInstance().getPlayers().get(playerTurn).move(6); 
		}
		if(Board.getInstance().getTiles().get(Board.getInstance().getPlayers().get(playerTurn).getPosition()).getImage().equals(WARPLAIR_2)) {
			Board.getInstance().getPlayers().get(playerTurn).move(7); 
		}
		
	
	}
	
	public static Image scaleImage(ImageIcon i) {
		BufferedImage scaled = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) scaled.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(i.getImage(), 0, 0, TILE_SIZE, TILE_SIZE, null);
		g2d.dispose();
		return scaled;
	}
	
	public void win() {
		if(Board.getInstance().getPlayers().get(playerTurn).getPosition() >= 73) {
			winSound.setVolume(1.0);
			winSound.playSound();
			JOptionPane.showMessageDialog(null, "YOU MADE IT " + namePlayers() + "! KING RICO HAS CROWNED YOU PRINCE/PRINCESS/NON-BINARYINCE OF RICOLAND! YOU WIN CONGRADULATIONS!!!" + "\n" +
													"this program will now close");
			
			dispose();
			//System.exit(0);
		}
	}
}
