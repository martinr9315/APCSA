package pong;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x, int y)
	{
		setXSpeed(x);
		setYSpeed(y);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball (int x, int y, int w, int h)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball (int x, int y, int w, int h, Color col)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setColor(col);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball (int x, int y, int w, int h, Color col, int xS, int yS)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setColor(col);
		setXSpeed(xS);
		setYSpeed(yS);
	}
	
   //add the set methods
   public void setXSpeed(int x)
   {
	   xSpeed = x;
   }
   
   public void setYSpeed(int y)
   {
	   ySpeed = y;
   }

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  draw(window, Color.WHITE);
	   
      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);

		//draw the ball at its new location
      draw(window);
   }
   
	public boolean equals(Object obj)
	{
		Ball c = (Ball)obj;
		if (this.getX()==c.getX()&&this.getY()==c.getY()&&this.getWidth()==c.getWidth()&&this.getHeight()==c.getHeight()&&this.getColor()==c.getColor()&&this.getXSpeed()==c.getXSpeed()&&this.getYSpeed()==c.getYSpeed())
			return true;
		return false;
	}   

   //add the get methods
	public int getXSpeed()
	{
		return xSpeed;
	}
	
	public int getYSpeed()
	{
		return ySpeed;
	}
	
	
	public boolean didCollideLeft(Object obj)
	{
		Block paddle = (Block)obj;
		if(getX()==paddle.getX()+getWidth())
		{
			if ((getY()>=paddle.getY()&&getY()<=paddle.getY()+paddle.getHeight()) || (getY()+getHeight()>=paddle.getY()&&getY()+getHeight()<=paddle.getY()+paddle.getHeight()))
				return true;
		}
		return false;
	}
	
	public boolean didCollideRight(Object obj)
	{
		Block paddle = (Block)obj;
		if(getX()+getWidth()==paddle.getX())
		{
			if ((getY()>=paddle.getY()&&getY()<=paddle.getY()+paddle.getHeight()) || (getY()+getHeight()>=paddle.getY()&&getY()+getHeight()<=paddle.getY()+paddle.getHeight()) )
		
			return true;
		}
		return false;
	}
	
	public boolean didCollideTop(Object obj)
	{
		Block paddle = (Block)obj;
		if(getY()==paddle.getY()+paddle.getHeight())
		{
			if ((getX()>=paddle.getX()&&getX()<=paddle.getX()+paddle.getWidth()) || getX()+getWidth()>=paddle.getX()&& getX()+getWidth()<=paddle.getX()+paddle.getWidth())
				return true;
		}
		return false;
	}
	public boolean didCollideBottom(Object obj)
	{
		Block paddle = (Block)obj;
		if(getY()+getHeight()==paddle.getY())
		{
			if ((getX()>=paddle.getX()&&getX()<=paddle.getX()+paddle.getWidth()) || getX()+getWidth()>=paddle.getX()&& getX()+getWidth()<=paddle.getX()+paddle.getWidth())
				return true;
		}
		return false;
	}
	

   //add a toString() method
    public String toString()
    {
    	String output= getX() +", "+getY() +", "+getWidth() +", "+getHeight() +", "+getColor()+", "+getXSpeed()+", "+getYSpeed();
    	return output;
    }
}