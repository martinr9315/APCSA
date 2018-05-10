package targetPractice;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class TargetPractice extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public TargetPractice()
	{
		super("Cannon Fight");
		setSize(WIDTH,HEIGHT);

		IslandDefense theGame = new IslandDefense();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		TargetPractice run = new TargetPractice();
	}
}