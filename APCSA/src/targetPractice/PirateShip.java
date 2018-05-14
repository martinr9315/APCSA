package targetPractice;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class PirateShip extends MovingThing {
	
	private int speed;
	private Image image;
	private Image explosion;
	private int mover;
	private boolean hit;
	
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
		mover=0;
		hit = false;
		try
		{
			image = ImageIO.read(new File("src//targetPractice//pirateship.png"));
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
	
	public boolean isHit()
	{
		return hit;
	}
	
	public void draw(Graphics window)
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	public void move(String direction)
	{
		mover++;
		if(direction.equals("LEFT")&&mover%2==0)
	      setX(getX()-getSpeed());
		
		if(direction.equals("RIGHT"))
		      setX(getX()+getSpeed());
	}
	
	public void moveAndDraw(Graphics window)
	{
		move("LEFT");
		draw(window);
	}
	
	public void explode(Graphics window)
	{
		try
		{
			image = ImageIO.read(new File("src//targetPractice//explosion.png"));
		}
		catch(Exception e)
		{
			System.out.println("Error constructing explosion");
		}
		window.drawImage(image,getX(),getY(),60,40,null);
		this.setSpeed(0);
		hit=true;
	}
	
	public void disappear() 
	{
		this.setPos(900, -100);
	}
	
	public String toString()
	{
		String output = "X: "+getX()+", Y: "+getY();
		return output;
	}

}