package unit14;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
		mat = new char[1][1];
	}
	
	
	/*for(int i=0; i&lt;word.length(); i++)
{
mymat[0][i] = word.charAt(i);
//3 more statements
//like the one I gave you
}*/

   public FancyWord(String s)
	{
	   mat = new char[s.length()][s.length()];
	   for (int i=0;i<mat.length;i++)
	   {
		   mat[0][i]=s.charAt(i);
		   mat[i][i]=s.charAt(i);
		   mat[mat.length-(i+1)][i]=s.charAt(i);
		   mat[mat.length-1][i]=s.charAt(i);
	   }


	}

	public String toString()
	{
		String output="";
		for (int i=0; i<mat.length; i++)
		{
			for (int j=0; j<mat.length; j++)
			{
				output+=mat[i][j];
			}
			output+="\n";
		}
		return output;
	}
}