package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	   super(10,10);
	   speed =5;
   }
   //add the other Paddle constructors
	public Paddle (int w, int h)
	{
		setWidth(w);
		setHeight(h);
		speed =5;
	}
	
	public Paddle (int w, int h, int s)
	{
		setWidth(w);
		setHeight(h);
		setSpeed(s);
	}
	
	public Paddle (int x, int y, int w, int h, int s)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setSpeed(s);
	}
	
	public Paddle (int x, int y, int w, int h, Color col, int s)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setColor(col);
		setSpeed(s);
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}





   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()+speed);
	   draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
		draw(window, Color.WHITE);
		setY(getY()-speed);
		draw(window);

   }

   //add get methods
	public int getSpeed()
	{
		return speed;
	}
   
   
   //add a toString() method
	public String toString()
	{
		String output= getX() +", "+getY() +", "+getWidth() +", "+getHeight() +", "+getColor()+", "+getSpeed();
		return output;
	}
}