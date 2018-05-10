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

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0);
	}

	public Ammo(int x, int y)
	{
		setX(x);
		setY(y);
	}

	public Ammo(int x, int y, int s)
	{
		setX(x);
		setY(y);
		setSpeed(s);
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
		window.setColor(Color.RED);
	    window.fillRect(getX(), getY(), 10, 10);
	}
	
	public void moveAndDraw(Graphics window)
	{
		setY(getY()-speed);
	 //draw the ball at its new location
	    draw(window);
	 }
	
	public String toString()
	{
		return "";
	}
}
