package unit7;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		setNum(110);
	}

	public Triples(int num)
	{
		setNum(num);
	}

	public void setNum(int num)
	{
		number = num;
	}
	
	public boolean isPythagorean(int a, int b, int c)
	{
		if (Math.pow(a, 2)+Math.pow(b, 2)==Math.pow(c, 2))
		{
			return true;
		}
		return false;
	}
	
	public boolean evenOdd(int a, int b, int c) 
	{
		if (c%2==1) 
		{
			if (a%2==0 && b%2==1)
			{
				return true;
			}
			else if (a%2==1 && b%2==0)
			{
				return true;
			}
		}
		return false;		
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
	    int max = Math.min(a, b);
	    max = Math.min(max, c);
	    for(int n = max; n >1; n--)
	    {
	        if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
	            return n;
	        }
	    }
	    return 1;
	}

	//The b side of a Pythagorean triplet is simply (a2 - 1) / 2.
	//The c side is b + 1.
	
	public String toString()
	{
		String output="";
		for (int n = 1; n<=number; n++)
		{
			int a=n;
			double B=(Math.pow(a, 2)-1)/2;
			int b = (int)B;
			int c = b+1;
			
			if (c<number)
			{
				if (isPythagorean(a,b,c))
				{
					if (evenOdd(a,b,c))
					{
						if (greatestCommonFactor(a,b,c)<=1)
							output = output + a + " " + b + " " + c + "\n";
					}
				}
			}
			
		}
		return output+"\n";
	}
}