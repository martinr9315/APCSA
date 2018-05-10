package unit13;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
	   wordRay = sentence.split(" ");
	}
	
	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		for (int i=0; i<wordRay.length; i++)
		{
		  if (wordRay[i].length()>max)
		    max = wordRay[i].length();
		}
		
		for (int i=0; i<wordRay.length; i++)
		{
		  while (wordRay[i].length()<max) 
		  {
		    wordRay[i] = " "+wordRay[i];
		  }
		}
		
		while (max>0)
		{
		  for (int i=wordRay.length-1; i>=0; i--)
		  {
			  output+= wordRay[i].charAt(max-1);
		  }
		  max--;
		  output+="\n";
	  }
		return output;
	}
}