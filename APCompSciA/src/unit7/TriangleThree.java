package unit7;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		setTriangle("x",3);
	}

	public TriangleThree(String let, int count)
	{
		setTriangle(let, count);
	}

	public void setTriangle( String let, int sz )
	{
		letter=let;
		size=sz;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		int letters = 1;
		int spaces = size- letters;
		String output="";
		for (int s=1;s<=size;s++) {
			for (int blank=1; blank<=spaces; blank++){
				output = output + " ";
			}
			for (int l=1; l<=letters; l++){
				output = output + letter;
			}
			output = output + "\n";	
			letters++;
			spaces = size- letters;
		}
		return output+"\n";
	}
}