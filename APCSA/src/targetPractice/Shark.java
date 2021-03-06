package targetPractice;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Shark extends MovingThing {

	private Image image;
	private int sharksHit;
	private int speed;
	

	public Shark() {
		super(0,0);
		setPos(randomX(),452);
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
		int rNum = 350 + (int)(Math.random() * ((700-350) + 1));
		return rNum;
	}
	
	public int sharksHit()
	{
		return sharksHit;
	}
	
	public void draw(Graphics window)
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	public boolean collide(Object obj, Graphics window) {
		
		Cannonball ball = (Cannonball) obj;
		
		if (ball.getX()>=getX()&&ball.getX()<=getX()+70&&ball.getY()>=getY()&&ball.getY()<=getY()+70)
		{
			setPos(randomX(),452);
			sharksHit++;
			return true;
		}
		
		return false;
	}
	
	public void disappear() 
	{
		setPos(-100, -100);
	}
	
	public String toString()
	{
		String output = "X: "+getX()+", Y: "+getY();
		return output;
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

}