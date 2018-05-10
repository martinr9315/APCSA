package unit13;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import static java.lang.System.*;

public class Lab15e
{
	public static void main(String args[])
	{
		//test case 1
		int[] one = NumberSort.getSortedDigitArray(54879321);
		for(int item : one)
		{
			System.out.print(item + " ");
		}
		System.out.println();
		
		//test case 2	
		int[] two = NumberSort.getSortedDigitArray(564893);
		for(int item : two)
		{
			System.out.print(item + " ");
		}
		System.out.println();

		//test case 3
		int[] three = NumberSort.getSortedDigitArray(1364587);
		for(int item : three)
		{
			System.out.print(item + " ");
		}
		System.out.println();
		
		
		
	
	
	
	
	
	
		
		
		
		
		

	}
}