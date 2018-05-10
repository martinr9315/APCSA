package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class TheGameWSpecialBalls extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public TheGameWSpecialBalls()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);
		
		SpecialPong game = new SpecialPong();
		
		((Component)game).setFocusable(true);			
		getContentPane().add(game);
						
		setVisible(true);
	
	}
	
	public static void main( String args[] )
	{
		TheGameWSpecialBalls run = new TheGameWSpecialBalls();
	}
}