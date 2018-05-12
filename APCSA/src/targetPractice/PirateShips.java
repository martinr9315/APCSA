package targetPractice;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class PirateShips {
	private ArrayList<PirateShip> ships;
	
	
	public PirateShips() {
		ships = new ArrayList<PirateShip>(5);
		for (int i=0; i<5; i++)
		{
			ships.add(new PirateShip(600+100*i,439,1));
		}
	}
	
	public PirateShips(int x) {
		ships = new ArrayList<PirateShip>(5);
		for (int i=0; i<x; i++)
		{
			ships.add(new PirateShip(600+100*i,439,1));
		}
	}
	
	public void draw(Graphics window)
	{
		for (PirateShip s : ships)
		{
			s.moveAndDraw(window);
		}
	}
	
	public boolean collide(Object obj, Graphics window) {
		
		Cannonball ball = (Cannonball) obj;
		
		for (PirateShip s: ships)
			
		if (ball.getX()>=s.getX()&&ball.getX()<=s.getX()+70&&ball.getY()>=s.getY()&&ball.getY()<=s.getY()+70)
		{
			s.explode(window);
			return true;
		}
		
		return false;
	}
	
	public boolean allHit()
	{
		int hits=0;
		 for (PirateShip s : ships)
		 {
			 if (s.isHit()==true)
				 hits++;
		 }
		 if (hits>=4)
		 {
			 for (PirateShip s : ships)
			 {
				 s.disappear();
			 }
			 return true;
		 }
		 return false;
	}
	
	
	public String toString()
	{
		String output = "total attacking ships: "+ships.size();
		return output;
	}
	

}