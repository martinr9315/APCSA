package unit3;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a :: ");
		a=keyboard.nextInt();
		System.out.print("Enter b :: ");
		b=keyboard.nextInt();
		System.out.print("Enter c :: ");
		c=keyboard.nextInt();	
	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		a=quadA;
		b=quadB;
		c=quadC;
	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		a=quadA;
		b=quadB;
		c=quadC;
	}

	public void calcRoots( )
	{
		
		rootOne= ((-b)+sqrt(pow(b,2)-(4*a*c)))/(2*a);
		rootTwo= ((-b)-sqrt(pow(b,2)-(4*a*c)))/(2*a);
	}

	public void print( )
	{
		System.out.println("rootone :: "+rootOne);
		System.out.println("roottwo :: "+rootTwo);
	}
}