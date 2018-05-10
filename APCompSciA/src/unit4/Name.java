package unit4;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Name
{
	private String name;
	private String original;

	public Name()
	{
	}

	public Name(String s)
	{
		name = s;
		original = s;
	}
	public void setName(String s)
	{
		
		name = s;
		original = s;
	}

	public String getFirst()
	{
		int spaceIndex = name.indexOf(' ');
		String first = name.substring(0,spaceIndex);
		return first;
	}

	public String getLast()
	{
		int spaceIndex = name.indexOf(' ');
		String last = name.substring(spaceIndex+1,name.length());
		return last;
	}

	public String toString()
	{
		return original;
	}
}