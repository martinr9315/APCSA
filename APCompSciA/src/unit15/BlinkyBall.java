package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

   //constructors
   public BlinkyBall()
   {
		super();
   }
   
   public BlinkyBall(int x, int y)
   {
		setX(x);
		setY(y);
   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);

   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(col);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   }

   public Color randomColor()
   {
   		int r = (int)Math.floor(Math.random() * 256);		//use Math.random()
 		int g = (int)Math.floor(Math.random() * 256);
 		int b = (int)Math.floor(Math.random() * 256);
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {
		  draw(window, Color.WHITE);
		   
	      setX(getX()+super.getXSpeed());
			//setY
	      setY(getY()+super.getYSpeed());

			//draw the ball at its new location
	      draw(window,randomColor());



   }
}