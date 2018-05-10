package unit1;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Roxane
//Date - 2/5/18
//Class - APCSA


import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner()
	{
		super("MAKE YOUR OWN SHAPE");

		setSize(WIDTH,HEIGHT);
		

		//getContentPane().add(new SmileyFace());
		
		getContentPane().add(new Shape());		
		
		//getContentPane().add(new Robot());


		setVisible(true);
	}

	public static void main( String args[] )
	{
		GraphicsRunner run = new GraphicsRunner();	

		
	}
}