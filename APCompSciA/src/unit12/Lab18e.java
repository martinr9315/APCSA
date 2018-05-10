package unit12;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit12\\lab18d.dat"));

		int size = file.nextInt();
		file.nextLine();

		ArrayList<Word> words = new ArrayList<Word>();
		
		for (int i=0; i<size; i++)
		{
			Word w = new Word(file.nextLine());
			words.add(w);
		}
		
		Collections.sort(words);
		
		for (int i=0; i<size; i++)
		{
			System.out.println(words.get(i));
		}
		
		
	}
}