package unit8;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	//instance variables
	int size;
	double[] grades;
	//constructor
	public Grades()
	{
		setGrades();
	}

	//set method
	public void setGrades()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many input grades? ");
		size = keyboard.nextInt();
		grades = new double[size];
		for (int i=0; i<size; i++)
		{
			System.out.print("grade "+i+":: ");
			grades[i] = keyboard.nextDouble();
		}
	}


	private double getSum()
	{
		double sum=0.0;
		for (int i=0; i<size; i++)
		{
			sum=sum+grades[i];
		}

		return sum;
	}

	public double getAverage()
	{
		double average=getSum()/size;
		

		return average;
	}


	//toString method
	public String toString()
	{
		String output = "";
		
		output = "average = " + getAverage();
		
		return output;
	}


}