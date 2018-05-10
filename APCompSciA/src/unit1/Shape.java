package unit1;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Shape extends Canvas
{
 public Shape()    //constructor method - sets up the class
 {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
 }

 public void paint( Graphics window )
 {
    window.setColor(Color.BLUE);

    window.drawString("MY SHAPE ", 35, 35 );

    shape(window);
 
    
 }

 public void shape( Graphics window )
 {
	window.setColor(Color.RED);
	window.fillOval(350, 200, 100, 100);
	
	window.setColor(Color.BLUE);
    window.fillOval(350, 200, 75, 75);
	
	window.setColor(Color.GREEN);
    window.fillOval(350, 200, 50, 50);
    			
 }
}
