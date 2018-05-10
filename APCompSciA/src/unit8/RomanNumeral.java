package unit8;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class RomanNumeral
{
	private int number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
	  setRoman(str);
	}

	public RomanNumeral(int orig)
	{
		setNumber(orig);
	}

	public void setNumber(int num)
	{
		number = num;
		roman = "";
		for (int i=0; i<LETTERS.length; i++)
		{
			while (number>0)
			{
				if (number>NUMBERS[i])
				{
					number=number-NUMBERS[i];
					roman = roman+ LETTERS[i];
				}
			}
		}
	}

	public void setRoman(String rom)
	{
		roman = rom;
		number = 0;
	     for (int i=0; i<roman.length(); i++)  
	     {	    	 
	    	 for (int n=0; n<LETTERS.length; n++)
	    	   {
	    		 String current = roman.substring(i,i+1);
	    		   if (LETTERS[n].equals(current))
	    		   {
	    			   number= number+NUMBERS[n];
	    		   }
	    	   }
	       }
	}

	public int getNumber()
	{
		return number;
	}

	public String toString()
	{
		return roman + "\n";
	}
}