package pkg1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TitleScreen extends JFrame{
	
	private static boolean _switch = true;
	private static GameScreen fo = new GameScreen();
	public static int numPlayers = 0;
	private final static SoundPlayer loopmusic = new SoundPlayer("loopmusic.wav");
	
	private JPanel _titlescreen = new JPanel();
	
	private JLabel _l1 = new JLabel("RICOLAND");
	private JButton _b1 = new JButton("                            Play w/ 2Players                         ");
	private JButton _b2 = new JButton("                            Play w/ 3Players                         ");
	private JButton _b3 = new JButton("                            Play w/ 4Players                         ");
	private JButton _b4 = new JButton("                                  Credits                                     ");

	
	
	public TitleScreen() {
		super("RicoLand");
		_titlescreen.setLayout(new BoxLayout(_titlescreen, BoxLayout.Y_AXIS));
		add(_titlescreen);
		_l1.setFont(new Font("Monospaced", Font.BOLD, 60));
		_titlescreen.add(_l1);
		_titlescreen.add(_b1);
		_titlescreen.add(_b2);
		_titlescreen.add(_b3);
		_titlescreen.add(_b4);
		loopmusic.setVolume(0.5);
		_b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				numPlayers = 2;
				
				if(_switch) {
					setVisible(false);
					
					GameScreen fo = new GameScreen();
					fo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    	fo.setSize(900, 500);
			    	fo.setResizable(false);
			    	fo.setLocationRelativeTo(null);
			    	fo.setVisible(true);
			    	loopmusic.loopSound();
				};
			
				
			}
		});
		
		_b2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				numPlayers = 3;
				
				if(_switch) {
					setVisible(false);
					
					GameScreen fo = new GameScreen();
					fo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    	fo.setSize(900, 500);
			    	fo.setResizable(false);
			    	fo.setLocationRelativeTo(null);
			    	fo.setVisible(true);
			    	loopmusic.loopSound();
				};
				
			}
		});
		
		_b3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				numPlayers = 4;
				
				
				
			}
		});
		
		_b4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Created by: Mauricio "+"\n" + "   Music by: DYATHON on youtube");
				
			}
		});
		
		
	}
	
}
