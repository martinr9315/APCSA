package starfighter;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class PowerUp implements Locatable {

	private int xPos;
	private int yPos;
	private Image image;

	public PowerUp()
	{
		int x = 100 + (int)(Math.random() * ((600 - 100) + 1));
		int y = 100 + (int)(Math.random() * ((400 - 100) + 1));
		setPos(x,y);
		try
		{
			image = ImageIO.read(new File("src\\starfighter\\pu.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Error constructing power-up.");
		}
	}

	public void setPos( int x, int y)
	{
		setX(x);
		setY(y);
	}


	public void setX(int x)
	{
		xPos = x;
	}


	public void setY(int y)
	{
		yPos = y;
	}

	public int getX()
	{
		return xPos;
	}


	public int getY()
	{
		return yPos;
	}
	

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	public boolean getsHit(Object obj)
	{
		MovingThing s = (MovingThing)obj;
        if((s.getX()>=this.getX() && s.getX()<=this.getX()+75)||(s.getX()+75>=this.getX() && s.getX()+75<=this.getX()+75))
        	if ((s.getY()>=this.getY() && s.getY() <=this.getY()+50)|| (s.getY()+75>=this.getY() && s.getY()+75 <= this.getY()+50))
        	{
        		setPos(-100,-100);
        		return true;
        	}
        		 
        return false;
	}

	public String toString()
	{
		return "X: "+getX()+" Y: "+getY();
	}
}
