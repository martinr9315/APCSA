package targetPractice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


public class Cannon extends MovingThing {
	private int speed;
	private int h;
	private int w;
	private double thetaDegrees;
	private double thetaR;
	//private Image image;

	public Cannon()
	{
		super(0,0);
	}

	public Cannon(int x, int y)
	{
		super(x,y);
	}

	public Cannon(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		thetaDegrees = 0;
		thetaR = thetaDegrees*0.0174533;
		h= (int) (75*Math.sin(thetaR));
		w = (int) (75*Math.cos(thetaR));
		/*try
		{
			image = ImageIO.read(new File("src\\targetPractice\\cannon.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Error constructing cannon.");
		}*/
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	public double getThetaR()
	{
		return thetaR;
	}
	
	public void draw( Graphics window)
	{
		//window.setColor(Color.WHITE);
		//window.fillRect(getX()-100, getY()-100, 300, 200);
		window.setColor(Color.BLACK);
		for (int i=0; i<20; i++)
		{
			window.drawLine(getX(), getY()+i, getX()+w, getY()-h+i);
		}
		//window.fillRoundRect(getX()+2, getY(), 75, 20, 10, 10);
		window.setColor(Color.GRAY);
		window.fillOval(getX(), getY(), 25, 25);
   	//window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	public void angleUp()
	{
		thetaDegrees=thetaDegrees+.5;
		thetaR = thetaDegrees*0.0174533;
		h= (int) (75*Math.sin(thetaR));
		w = (int) (75*Math.cos(thetaR));
		//System.out.println("D: "+thetaDegrees+"  R: "+thetaR);
	}
	
	public void angleDown()
	{
		thetaDegrees=thetaDegrees-.5;
		thetaR = thetaDegrees*0.0174533;
		h= (int) (75*Math.sin(thetaR));
		w = (int) (75*Math.cos(thetaR));
		//System.out.println("D: "+thetaDegrees+"  R: "+thetaR);
	}
	
	

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
