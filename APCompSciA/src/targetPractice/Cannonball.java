package targetPractice;

import java.awt.Color;
import java.awt.Graphics;

public class Cannonball extends MovingThing {
	
	private int speed;
	private int xSpeed;
	private double ySpeed;
	private double thetaR;
	
	public Cannonball() {
		super(0,500);
		setSpeed(2);
	}
	
	public Cannonball(int x, int y){
		super(x,y);
		setSpeed(2);
	}

	public Cannonball(int x, int y, int s, double theta)
	{
		super(x,y);
		setSpeed(s);
		thetaR = theta;
		xSpeed = (int)(speed*Math.cos(thetaR));
		ySpeed = (speed*Math.sin(thetaR));
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
		window.setColor(Color.BLACK);
		window.fillOval(getX(), getY(), 10, 10);
	}
	
	public void draw(Graphics window, Color col)
	{
		window.setColor(col);
		window.fillOval(getX(), getY(), 10, 10);
	}
	
	public void fly(Graphics window, double theta)
	{
		draw(window, Color.WHITE);
		setX(getX()+xSpeed);
		setY((int)(getY()-ySpeed));
		ySpeed=ySpeed-.025;
		//ySpeed = (int)(Math.sqrt(Math.pow(yOSpeed, 2)+20*(getX()-xO)));
		
		draw(window);
	}
	
	public String toString()
	{
		String output = "X: "+getX()+", Y: "+getY()+", Speed: "+getSpeed();
		return output;
	}
}
