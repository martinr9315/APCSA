package unit12;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;
	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (int i=0; i<word.length(); i++)
		{
			if (vowels.indexOf(word.charAt(i))!=-1)
					vowelCount++;
		}
		return vowelCount;
	}

	public int compareTo(Word rhs)
	{
		if (rhs.numVowels()>this.numVowels())
			return -1;
		if (rhs.numVowels()<this.numVowels())
			return 1;
		else
		{
			if (this.word.compareTo(rhs.word)<0)
				return -1;
			if (this.word.compareTo(rhs.word)>0)
				return 1;
		}
		
		return 0;	

	}

	public String toString()
	{
		return word;
	}
}