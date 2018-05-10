package unit4;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StringChecker
{
	private String word;
	private String original;

	public StringChecker()
	{
	}

	public StringChecker(String s)
	{
		word = s;
		original = s;
	}
	public void setString(String s)
	{
		word = s;
		original = s;
	}
	public boolean findLetter(char c)
	{
		int index = word.indexOf(c);
		if (index == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean findSubString(String s)
	{
		int index = word.indexOf(s);
		if (index == -1) {
			return false;
		}
		else {
			return true;
		}
	}

	public String toString()
	{
		return original;
	}
}