package targetPractice;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import starfighter.Aliens;
import starfighter.Ammo;
import starfighter.PowerUp;
import starfighter.Ship;

public class IslandDefense extends Canvas implements KeyListener, Runnable {
	
	private Cannon cannon;
	//private PirateShip pirateShip;
	private Cannonball cannonball;
	private ArrayList<Cannonball> shots;
	private Image image;
	private PirateShips ships;
	
	private boolean[] keys;
	private BufferedImage back;

	public IslandDefense()
	{
		setBackground(Color.white);

		keys = new boolean[5];

		//instantiate other stuff
		cannon = new Cannon(150,475,2);
		ships = new PirateShips(4);
		//pirateShip = new PirateShip(550, 439, 1);
		shots = new ArrayList<Cannonball>();
		
		try
		{
			image = ImageIO.read(new File("src\\targetPractice\\island.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Error constructing island.");
		}
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		graphToBack.drawImage(image,0,0,800,600,null);
		
		//graphToBack.setColor(Color.WHITE);
		//graphToBack.fillRect(0, 0, 800, 600);
		
		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Defend your island ", 25, 50 );
		


		cannon.draw(graphToBack);
		ships.draw(graphToBack);
		/*pirateShip.move("LEFT");
		if (pirateShip.getX()<350)
			pirateShip.setX(800);
		pirateShip.draw(graphToBack);*/
		

	
		for (Cannonball ball : shots)
		{
			ball.fly(graphToBack,45);
			if ((ball.getX()>800)||(ball.getY()>600))
			{
				ball.setSpeed(0);
			}
			ships.collide(ball, graphToBack);
		}
		
		
		if(keys[0] == true)
		{
			if (cannon.getX()>=100)
				cannon.move("LEFT");
		}
		if(keys[1] == true)
		{
			if (cannon.getX()<=275)
				cannon.move("RIGHT");
		}
		if(keys[2] == true)
		{
			cannon.angleUp();
		}
		if(keys[3] == true)
		{
			cannon.angleDown();
		}
		if(keys[4] == true)
		{
		    Cannonball shot = new Cannonball(cannon.getX(), cannon.getY(), 4, cannon.getThetaR());
            shots.add(shot);
            keys[4]=false;
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}
