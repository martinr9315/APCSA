package targetPractice;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Shark extends MovingThing {

	private Image image;
	private boolean hit;
	

	public Shark() {
		super(0,0);
		setPos(randomX(),452);
		hit = false;
		try
		{
			image = ImageIO.read(new File("src//targetPractice//shark.png"));
		}
		catch(Exception e)
		{
			System.out.println("Error constructing shark.");
		}
	}

	public int randomX()
	{
		int rNum = 300 + (int)(Math.random() * ((780-300) + 1));
		return rNum;
	}
	
	public boolean isHit()
	{
		return hit;
	}
	
	public void draw(Graphics window)
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	
	public void disappear() 
	{
		this.setPos(-100, -100);
	}
	
	public String toString()
	{
		String output = "X: "+getX()+", Y: "+getY();
		return output;
	}

	public void setSpeed(int s) {}

	public int getSpeed() {
		return 0;
	}

}