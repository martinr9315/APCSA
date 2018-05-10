package unit5;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class Lab05c
{
	public static void main ( String[] args )
	{
		Scanner input = new Scanner(System.in);
		out.print("Enter a word: ");
		String w = input.next();
		StringOddOrEven test = new StringOddOrEven(w);
		System.out.println(test);
	}
}