package unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit13\\lab15d.dat"));
      
		int numData = (file.nextInt());
		
		file.nextLine();
		
		for (int i=0; i<numData; i++)
		{
		  FancyWords test = new FancyWords(file.nextLine());
		  out.println(test.toString());
		  out.println("\n\n");
		}
		
		





	}
}