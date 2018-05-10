package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

	public Block()
	{
		yPos = 10;
		xPos = 10;
		width = 10;
		height = 10;
		color = Color.BLACK;
	}

	//add other Block constructors - x , y , width, height, color
	public Block (int x, int y)
	{
		setX(x);
		setY(y);
		width = 10;
		height = 10;
		color = Color.BLACK;
	}
	public Block (int x, int y, int w, int h)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		color = Color.BLACK;
	}
	
	public Block (int x, int y, int w, int h, Color col)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setColor(col);
	}
	
	
   //add the other set methods
   public void setX(int x)
   {
	   xPos = x;
   }
   
   public void setY(int y)
   {
	   yPos = y;
   }
   
   public void setPos(int x, int y)
   {
	   setX(x);
	   setY(y);
   }
   
   public void setWidth(int w)
   {
	   width = w;
   }
   
   public void setHeight(int h)
   {
	   height = h;
   }
   
   public void setColor(Color col)
   {
	   color = col;
   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Block c = (Block)obj;
		if (this.getX()==c.getX()&&this.getY()==c.getY()&&this.getWidth()==c.getWidth()&&this.getHeight()==c.getHeight()&&this.getColor()==c.getColor())
			return true;
		return false;
	}   

   //add the other get methods
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
    public Color getColor()
    {
    	return color;
    }
    
  

   //add a toString() method  - x , y , width, height, color
    public String toString()
    {
    	String output= getX() +", "+getY() +", "+getWidth() +", "+getHeight() +", "+getColor();
    	return output;
    }
}