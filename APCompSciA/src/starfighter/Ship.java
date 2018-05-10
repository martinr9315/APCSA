package starfighter;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(0,0,0);
	}

	public Ship(int x, int y)
	{
		this(x,y,0);
	}

	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\starfighter\\ship.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Error constructing ship.");
		}
	}
	
	public void powerUp()
	{
		try
		{
			image = ImageIO.read(new File("src\\starfighter\\shipWithShield.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Error constructing ship w shield.");
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	public int getsHit(Object obj, int score)
	{
		MovingThing s = (MovingThing)obj;
        if(s.getX()>=this.getX() && s.getX()<=this.getX()+75 && s.getY()>=this.getY() && s.getY() <= this.getY()+75)
        {
            score--;
            s.setPos(-100, 599);
        }               
		return score;
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
