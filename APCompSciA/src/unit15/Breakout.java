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
import java.util.Arrays;
import java.util.ArrayList;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private int score;
	private Wall leftWall;
	private Wall rightWall;
	private Wall topWall;
	private Wall bottomWall;
	private Block[][] blocks;
	private ArrayList<Block> hit;


	public Breakout()
	{
		//print my name, period, date, computer #
		System.out.println("Roxane Martin\nPeriod 4\n4/4/2018\nComputer #27");
		System.out.println("To play game: A for up, Z for down");
		//set up all variables related to the game
		ball = new Ball(50,50,20,20,Color.RED,2,2);

		paddle = new Paddle(50, 100, 20, 100, Color.BLUE, 5);

		keys = new boolean[3];
		
		blocks = new Block[5][5];
		hit = new ArrayList<Block>();
		
		int x = 650;
		int y = 0;
		for (int i=0; i<blocks.length; i++)
		{
			for (int j=0; j<blocks .length; j++)
			{
				blocks[i][j] = new Block(x, y, 15, 110, Color.RED);
				x+=20;
			}
			x=650;
			y+=150;
		}
		
		score=0;

		leftWall = new Wall(0,0,5,600);
		rightWall = new Wall(790,0,5,600);
		topWall = new Wall(0,0,800,10);
		bottomWall = new Wall(0,600,800,5);
		
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
		paddle.draw(graphToBack);
		rightWall.draw(graphToBack);
		leftWall.draw(graphToBack);
		topWall.draw(graphToBack);
		bottomWall.draw(graphToBack);
		graphToBack.setColor(Color.black);
		graphToBack.drawString("Score: "+score, 50, 550);
		
		for (int i=0; i<blocks.length; i++)
		{
			for (int j=0; j<blocks.length; j++)
			{
			
				if (!hit.contains(blocks[i][j]))
				{
					blocks[i][j].draw(graphToBack);
				}
			}
		}
		
		for (int i=0; i<blocks.length; i++)
		{
			for (int j=0; j<blocks.length; j++)
			{
				if (ball.didCollideRight(blocks[i][j])||ball.didCollideRight(blocks[i][j]))
				{
					if (!hit.contains(blocks[i][j]))
					{
						hit.add(blocks[i][j]);
						ball.setXSpeed(-ball.getXSpeed());
						blocks[i][j].draw(graphToBack, Color.white);
						//update score
						score++;
						graphToBack.setColor(Color.white);
						graphToBack.fillRect(50, 530, 100, 20);
					}
		
				}

			}
		}

		//see if ball hits left wall or right wall
		if(ball.didCollideRight(rightWall))
			ball.setXSpeed(-ball.getXSpeed());
	
		
		if (ball.didCollideLeft(leftWall))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.draw(graphToBack, Color.WHITE);
			ball.setX(50);
			ball.setY(50);
			score=0;
			graphToBack.setColor(Color.white);
			graphToBack.fillRect(50, 530, 100, 20);
			hit = new ArrayList<Block>();
		}
		
		if (score==20)
		{
			graphToBack.setColor(Color.MAGENTA);
			graphToBack.drawString("YOU WIN!!!", 350, 300);
			ball.setYSpeed(0);
			ball.setXSpeed(0);
		}
		
		//see if the ball hits the top or bottom wall 
		if (ball.didCollideTop(topWall))
			ball.setYSpeed(-ball.getYSpeed());
		if (ball.didCollideBottom(bottomWall))
			ball.setYSpeed(-ball.getYSpeed());


		//see if the ball hits the left paddle
		if (ball.didCollideLeft(paddle)||ball.didCollideRight(paddle))
			ball.setXSpeed(-ball.getXSpeed());
		
		if (ball.didCollideTop(paddle)||ball.didCollideBottom(paddle))
			ball.setYSpeed(-ball.getYSpeed());
	
		//see if the paddles need to be moved
		
		
		//move paddles
		if(keys[0] == true)
		{
			//move left paddle down and draw it on the window
			paddle.moveDownAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle up and draw it on the window
			paddle.moveUpAndDraw(graphToBack);

		}


		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
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

