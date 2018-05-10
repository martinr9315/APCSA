package unit12;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

import java.util.Collections;
import java.util.ArrayList;

public class Word1 implements Comparable<Word1>
{
	private String word;

	public Word1( String s )
	{
		word = s;
	}

	public int compareTo( Word1 rhs )
	{
		if (rhs.word.length()>this.word.length())
			return -1;
		if (rhs.word.length()<this.word.length())
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
