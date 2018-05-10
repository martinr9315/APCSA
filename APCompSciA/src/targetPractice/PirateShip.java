package targetPractice;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

import starfighter.MovingThing;

public class PirateShip extends MovingThing {
	
	private int speed;
	private Image image;
	private Image explosion;
	
	public PirateShip() {
		super(0,500);
		setSpeed(2);
	}
	
	public PirateShip(int x, int y){
		super(x,y);
		setSpeed(2);
	}

	public PirateShip(int x, int y, int s) {
		super(x,y);
		setSpeed(s);
		try
		{
			image = ImageIO.read(new File("src\\targetPractice\\pirateship.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Error constructing pirate ship.");
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
	
	public void draw(Graphics window)
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
	
	public void explode(Graphics window)
	{
		try
		{
			explosion = ImageIO.read(new File("src\\targetPractice\\explosion.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Error constructing explosion");
		}
		window.drawImage(explosion,getX()+25,getY()+25,30,30,null);
		this.setSpeed(0);
	}
	
	public String toString()
	{
		String output = "X: "+getX()+", Y: "+getY();
		return output;
	}

}
