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


public class IslandDefense extends Canvas implements KeyListener, Runnable {
	
	private Cannon cannon;
	//private PirateShip pirateShip;
	private Cannonball cannonball;
	private ArrayList<Cannonball> shots;
	private Image image;
	private PirateShips ships;
	private Shark shark;
	private int threats;
	private int cannonballs;
	private boolean playGame;
	
	private boolean[] keys;
	private BufferedImage back;

	public IslandDefense()
	{
		setBackground(Color.white);

		keys = new boolean[6];


		//instantiate other stuff
		cannon = new Cannon(150,475,2);
		ships = new PirateShips(4);
		shark = new Shark();
		shots = new ArrayList<Cannonball>();
		cannonballs = 15;
		playGame = false;
		
		try
		{
			image = ImageIO.read(new File("src//targetPractice//island.jpg"));
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
		cannon.draw(graphToBack);
		
		//FIRST SCREEN
		if (!playGame){
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Island Defense",20, 20);
		graphToBack.drawString("Roxane Martin",20, 45);
		graphToBack.drawString("AP CSA - P. 4",20, 70);
		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Your island is under attack! You must use your cannon to defend it.",325, 350);
		graphToBack.drawString("To angle your cannon upward, press the up arrow.",325, 375);
		graphToBack.drawString("To angle your cannon downward, press the down arrow.",325, 400);
		graphToBack.drawString("To fire, press the space bar.",325, 425);
		graphToBack.drawString("There will be 10 threats and you only have 15 cannonballs, so aim well. ",325, 450);
		graphToBack.drawString("Press ENTER to play.", 325, 475);
		}
		
		
		if (playGame) {
		//graphToBack.setColor(Color.WHITE);
		//graphToBack.fillRect(0, 0, 800, 600);
		
		graphToBack.setColor(Color.WHITE);
		graphToBack.fillRect(70, 100, 135, 45);
		//graphToBack.drawString("Defend your island ", 25, 40 );
		threats= Math.max(0, 10 - ships.shipsHit()  - shark.sharksHit());
		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Threats left: "+threats, 75, 120 );
		graphToBack.drawString("Cannonballs left: "+cannonballs, 75, 135 );
		
		if (threats<=0)
			graphToBack.drawString("Your island is safe! -- YOU WIN ", 300, 300 );
		
		if (cannonballs<=0&&threats>0)
			graphToBack.drawString("You ran out of cannonballs and your island is still under attack... -- YOU LOSE ", 300, 300 );


		ships.draw(graphToBack);
		if (ships.shipsHit()>=4&&threats>0)
		{
			shark.draw(graphToBack);
			
		}
		/*pirateShip.move("LEFT");
		if (pirateShip.getX()<350)
			pirateShip.setX(800);
		pirateShip.draw(graphToBack);*/
		
		
		
		ArrayList<Cannonball> shotsToRemove = new ArrayList<Cannonball>();
		
		for (Cannonball ball : shots)
		{
			ball.fly(graphToBack,45);
			if ((ball.getX()>800)||(ball.getY()>600))
			{
				ball.setSpeed(0);
			}
			;
			if (ships.collide(ball, graphToBack)||shark.collide(ball, graphToBack))
			{
				shotsToRemove.add(ball);
			}
		}
		shots.removeAll(shotsToRemove);
		shotsToRemove.clear();

		if (ships.reachIsland())
		{
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("The pirates have landed on your island! -- YOU LOSE ", 300, 300 );
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
		    if (cannonballs>0)
		    {
			Cannonball shot = new Cannonball(cannon.getX(), cannon.getY(), 4, cannon.getThetaR());
            shots.add(shot);
            cannonballs--;
            keys[4]=false;
		    }
		}
		
		}
		if(keys[5] == true)
		{
			playGame = true;
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			keys[5] = true;
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			keys[5] = false;
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