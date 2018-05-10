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

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,0);
	}

	public Alien(int x, int y)
	{
		this(x,y,0);
	}

	public Alien(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\starfighter\\alien.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Error constructing alien.");
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
	
	public void move(String direction)
	{
		if(direction.equals("LEFT"))
	      setX(getX()-getSpeed());
		
		if(direction.equals("RIGHT"))
		      setX(getX()+getSpeed());
	}
	
	public void moveAndDraw(Graphics window)
	{
	 //draw a white ball at old ball location
		setX(getX()+speed);
	 //draw the ball at its new location
	    draw(window);
	 }

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
