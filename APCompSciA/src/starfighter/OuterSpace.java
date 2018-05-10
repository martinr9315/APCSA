package starfighter;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import elevens.Card;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;

	//private ArrayList<Alien> aliens;
	private Aliens aliens;
	private PowerUp powerUp;
	private ArrayList<Ammo> shots;
	private ArrayList<Ammo> alienShots;	
	private int score;
	private boolean isShipSuper;
	private boolean running;
	
	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(350,475,2);
		shots = new ArrayList<Ammo>();
		alienShots = new ArrayList<Ammo>();
		aliens = new Aliens(2,5);
		powerUp = new PowerUp();
		
		isShipSuper = false;
		running = true; 
		score = 0;

		/*aliens = new ArrayList<Alien>();
        aliens.add(new Alien(250,50,2));
        aliens.add(new Alien(450,50,2));
        aliens.add(new Alien(650,50,2));
        aliens.add(new Alien(950,50,2));*/

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

	
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(25,75,100,10);
		graphToBack.setColor(Color.YELLOW);
		graphToBack.drawString("Score: " + score, 25, 75 );

		ship.draw(graphToBack);
		powerUp.draw(graphToBack);


		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
		if(keys[4] == true)
		{
		    Ammo shot = new Ammo(ship.getX()+35, ship.getY(), 10);
            shots.add(shot);
            keys[4]=false;
		}
		
		//get rid off shots that go off screen
		ArrayList<Ammo> shotsToRemove = new ArrayList<Ammo>();
	    for(Ammo s : shots){
            s.draw(graphToBack);
            s.move("UP");
            if(s.getY()<=0)
            	shotsToRemove.add(s);
        }
	    shots.removeAll(shotsToRemove);
	    shotsToRemove.clear();
	    
	    //draw and move aliens
	    aliens.draw(graphToBack);
	    if (running)
	    	alienShots = aliens.shoot();
	    
	    for(Ammo s : alienShots){
	    	s.draw(graphToBack);
	    	s.move("DOWN");
	    	if(s.getY()<=0)
	    		shotsToRemove.add(s);
	    }
	    alienShots.removeAll(shotsToRemove);
	    shotsToRemove.clear();
	    
	    //aliens disappear when shot and score goes up
	    for(Ammo s: shots)
        {
	    	score = aliens.getsShot(s,score);
        }
	    
	    if (!isShipSuper)
	    {
	    //score goes down when ship gets shot
	    	for(Ammo s: alienShots)
	    	{
	    		score = ship.getsHit(s,score);
	    	}
	    }
	   
	    //ship changes to ship w shield when it hits powerUp
	    if (powerUp.getsHit(ship))
	    {
	    	ship.powerUp();
	    	isShipSuper = true;
	    }
	    
	    //game over if ship collides w/ aliens
	    if (aliens.collidesWShip(ship))
	    {
	    	aliens.stopAll();
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("You lose", 300, 500 );
	    }
	    
	    //player wins if all aliens are shot
	    if (score>=15)
	    {
	    	aliens.stopAll();
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("YOU WIN!!!", 300, 300 );
	    }
	    //draw and move aliens
		/*ArrayList<Alien> aliensToRemove = new ArrayList<Alien>();
	    for(Alien a : aliens)
        {
            a.draw(graphToBack);
            if(a.getX() <= 1000)
            {
                if(a.getX()>900)
                    a.setX(-20);
            }
            a.move("RIGHT");

            for(Ammo s: shots)
            {
            	//get rid of ammo and aliens that collide
                if(a.getX()>=s.getX() && a.getX()<=s.getX()+100 && a.getY()>=s.getY() && a.getY() <= s.getY()+80)
                {
                    aliensToRemove.add(a);
                    shotsToRemove.add(s);
                }
            }
        }
	    shots.removeAll(shotsToRemove);
	    shotsToRemove.clear();
	    aliens.removeAll(aliensToRemove);
	    aliensToRemove.clear();
	    */

		
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

