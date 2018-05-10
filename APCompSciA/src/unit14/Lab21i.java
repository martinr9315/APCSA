package unit14;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit14\\lab21i.dat"));
		
		while (file.hasNextLine())
		{
			int size = (file.nextInt());
			file.nextLine();
			String line = file.nextLine();
			Maze mazey = new Maze(size,line);
			mazey.hasExitPath(0,0);
			out.println(mazey.toString());
		}		
	}
}