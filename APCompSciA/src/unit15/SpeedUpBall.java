package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();
   }

   public SpeedUpBall(int x, int y)
   {
		setX(x);
		setY(y);
   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
		setX(x);
		setY(y);
		setXSpeed(x);
		setYSpeed(y);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(col);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   }

   public void setXSpeed( int xSpd )
   {
	   if (xSpd>0)
		   xSpd = xSpd+1;
	   if (xSpd<0)
		   xSpd=xSpd-1;
	   super.setXSpeed(xSpd);
   }

   public void setYSpeed( int ySpd )
   {
	   if (ySpd>0)
		   ySpd = ySpd+1;
	   if (ySpd<0)
		   ySpd=ySpd-1;
	   super.setYSpeed(ySpd);
   }

  
}

