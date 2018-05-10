package unit1;

//UNCOMMENT ROBOT CODE IN GRAPHICS RUNNER

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      head(window);
      upperBody(window);
      lowerBody(window);
      face(window);
      
   }

   public void head( Graphics window )
   {
      window.setColor(Color.YELLOW);

      window.fillOval(300, 100, 200, 100);


		//add more code here
				
   }

   public void upperBody( Graphics window )
   {

		//add more code here
	   window.setColor(Color.BLUE);
	   window.fillRect(300, 200, 200, 100);
   }

   public void lowerBody( Graphics window )
   {

	   window.setColor(Color.RED);
	   window.fillRect(250, 300, 300, 100);

   }
   
   public void face( Graphics window)
   {
	   window.setColor(Color.BLACK);
	   window.fillRect(365, 140, 25, 25);
	   window.fillRect(415, 140, 25, 25);
   }
}
