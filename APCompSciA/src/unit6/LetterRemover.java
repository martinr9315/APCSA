package unit6;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		setRemover("love",'l');
	}
	public LetterRemover(String s, char rem)
	{
		setRemover(s,rem);
	}

	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned="";
		for (int i=0; i<sentence.length();i++)
		{
			if (sentence.charAt(i)!=lookFor) 
			{
				cleaned+=sentence.charAt(i);
			}
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove: " + lookFor;
	}
	public void print() 
	{
		System.out.println(toString());
		System.out.println(removeLetters());
	}
}