package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;
	private Wall leftWall;
	private Wall rightWall;
	private Wall topWall;
	private Wall bottomWall;


	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(200,200,20,20,Color.RED,2,2);

		leftPaddle = new Paddle(50, 100, 20, 100, Color.BLUE, 5);

		rightPaddle = new Paddle(700, 100, 20, 100, Color.BLUE, 5);

		keys = new boolean[5];
		
		leftScore=0;
		rightScore=0;

		leftWall = new Wall(0,0,5,600);
		rightWall = new Wall(790,0,5,600);
		topWall = new Wall(0,0,800,10);
		bottomWall = new Wall(0,550,800,5);
		
    	setBackground(Color.WHITE);
		setVisible(true);
	
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();



		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		
		
		rightWall.draw(graphToBack);
		leftWall.draw(graphToBack);
		topWall.draw(graphToBack);
		bottomWall.draw(graphToBack);
		
		graphToBack.drawString("Left score: "+leftScore, 50, 550);
		graphToBack.drawString("Right score: "+rightScore, 600, 550);

		//see if ball hits left wall or right wall
		if(ball.didCollideLeft(leftWall)||ball.didCollideRight(rightWall))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.didCollideLeft(leftWall))
		{
			rightScore++;
			graphToBack.setColor(Color.white);
			graphToBack.fillRect(600, 530, 100, 20);
		}
		if (ball.didCollideRight(rightWall))
		{
			leftScore++;
			graphToBack.setColor(Color.white);
			graphToBack.fillRect(50, 530, 100, 20);
		}
		
		//see if the ball hits the top or bottom wall 
		if (ball.didCollideTop(topWall))
			ball.setYSpeed(-ball.getYSpeed());
		if (ball.didCollideBottom(bottomWall))
			ball.setYSpeed(-ball.getYSpeed());


		//see if the ball hits the left paddle
		if (ball.didCollideLeft(leftPaddle)||ball.didCollideRight(leftPaddle))
			ball.setXSpeed(-ball.getXSpeed());
		
		if (ball.didCollideTop(leftPaddle)||ball.didCollideBottom(leftPaddle))
			ball.setYSpeed(-ball.getYSpeed());
		
		//see if the ball hits the right paddle
		if (ball.didCollideLeft(rightPaddle)||ball.didCollideRight(rightPaddle))
			ball.setXSpeed(-ball.getXSpeed());
		
		if (ball.didCollideTop(rightPaddle)||ball.didCollideBottom(rightPaddle))
			ball.setYSpeed(-ball.getYSpeed());
	
		//see if the paddles need to be moved
		
		
		//move paddles
		if(keys[0] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			//move right paddle down and draw it on the window
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			//move right paddle up and draw it on the window
			rightPaddle.moveUpAndDraw(graphToBack);
		}


		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}

