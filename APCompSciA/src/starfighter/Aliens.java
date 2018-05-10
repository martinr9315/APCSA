package starfighter;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

import pong.Ball;

public class Aliens {
	private Alien[][] aliens;
	public ArrayList<Ammo> ammo;
	
	public Aliens() {
		aliens = new Alien[2][2];
		ammo = new ArrayList<Ammo>();
	}
	
	public Aliens(int rows, int cols) {
		aliens = new Alien[rows][cols];
		ArrayList<Integer> xValues = new ArrayList<Integer>();
		int x;
		for (int i=0; i<aliens.length; i++)
		{
			for (int j=0; j<aliens[0].length; j++)
			{
				x = chooseX();
				if (xValues.contains(x))
					x = chooseX();
				aliens[i][j] = new Alien(x,chooseRandomY(),2);

			}
		}
		ammo = new ArrayList<Ammo>();
	}
	
	public int chooseRandomY()
	{
		int rNum = 20 + (int)(Math.random() * ((400 - 20) + 1));
		return rNum;
	}
	
	public int chooseX()
	{
		int rNum = 20 + (int)(Math.random() * ((780 - 20) + 1));
		return rNum;
	}
	
	public void draw(Graphics window)
	{
		for (Alien[] r: aliens)
		{
			for (Alien a: r)
			{
				a.moveAndDraw(window);
		            if(a.getX() <= 1000)
		            {
		                if(a.getX()>900||a.getX()<-200)
		                {
		                    a.setSpeed(-a.getSpeed());
		                    a.setY(chooseRandomY());
		                }
		            }
			}
		}
	}
	
	public int getsShot(Object obj, int score)
	{
		MovingThing s = (MovingThing)obj;
		for (Alien[] r: aliens)
		{
			for (Alien a: r)
			{
                if(s.getX()>=a.getX() && s.getX()<=a.getX()+100 && s.getY()>=a.getY() && s.getY() <= a.getY()+80)
                {
                	a.setPos(-100, -100);
                	a.setSpeed(0);
                	score=score+2;
                }               
			}
		}
		return score;
	}
	
	public boolean collidesWShip(Object obj)
	{
		MovingThing s = (MovingThing)obj;
		for (Alien[] r: aliens)
		{
			for (Alien a: r)
			{
                if((a.getX()+10>=s.getX()+10 && a.getX()+10<=s.getX()+50)||(a.getX()+50>=s.getX()+10 && a.getX()+50<=s.getX()+50))
                	if ((a.getY()+10>=s.getY()+10 && a.getY()+10 <=s.getY()+50)|| (a.getY()+75>=s.getY()+10 && a.getY()+75 <= s.getY()+50))
                	{
                		s.setSpeed(0);
                		return true;
                	}               
			}
		}
		return false;
	}
	
	public void stopAll()
	{
		for (Alien[] r: aliens)
		{
			for (Alien a: r)
			{
				a.setSpeed(0);
			}
		}
		ammo.clear();
	}
	
	public ArrayList<Ammo> shoot()
	{
		for (Alien[] r: aliens)
		{
			for (Alien a: r)
			{
				if (a.getX()==chooseX())
				{
					Ammo shot = new Ammo(a.getX()+35, a.getY()+50, 2);
		            ammo.add(shot);
				}
			}
		}
		return ammo;
	}

}
