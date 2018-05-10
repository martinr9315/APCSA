package unit15;

import java.awt.Color;

public class Wall extends Block {

	public Wall()
	   {
		   super(10,10);

	   }
		public Wall(int w, int h)
		{
			setWidth(w);
			setHeight(h);
		}
				
		public Wall(int x, int y, int w, int h)
		{
			setX(x);
			setY(y);
			setWidth(w);
			setHeight(h);
			setColor(Color.WHITE);
		}
}
