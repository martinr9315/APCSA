package unit9;

public class MyString1 {

	char[] characters;
	public MyString1(char[] chars) 
	{
		characters = new char[chars.length];
		characters = chars;
	}
	
	public char charAt(int index)
	{ 
		char result = characters[index];
		return result;
	}
	
	public int length()
	{
		int length = characters.length;
		return length;
	}
	
	public MyString1 substring(int begin, int end)
	{
		char[] segment = new char[end-begin];
		for (int i=begin; i<end; i++)
		{
			segment[i]=characters[i];
		}
		MyString1 newString = new MyString1(segment);
		return newString;
	}
	public MyString1 toLowerCase()
	{
		char[] lower = new char[characters.length];
		for (int i=0; i<characters.length; i++)
		{
			lower[i]=Character.toLowerCase(characters[i]);
		}
		MyString1 newString = new MyString1(lower);
		return newString;
	}
	
	public char[] getCharacters()
	{
		return characters;
	}
	
	public boolean equals(MyString1 s)
	{
		if (this.getCharacters()==s.getCharacters())
		{
			return true;
		}
		return false;
		
	}


}
