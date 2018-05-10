package unit11;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner keyboard = new Scanner(System.in);
		
		out.print("What is the name of this class? ");
		String name = keyboard.nextLine();
		
		out.print("How many students are in this class? ");
		int stuNum = keyboard.nextInt();
		
		Class test = new Class(name, stuNum);
		
		for (int i=0; i<stuNum-1; i++)
		{
			out.print("Enter the name of student " + (i+1)+ ": ");
			name = keyboard.next();
			keyboard.nextLine();
			out.println("Enter the grades for "+ name);
			out.print("Use the format x - grades ex:(2 - 100 100): ");
			String gList = keyboard.nextLine();
			
			out.println(gList);
			
			Student adding = new Student(name, gList);
			
			test.addStudent(i, adding);
		}
		
		out.println(test);
		
		for (int i=0; i<stuNum-1; i++)
		{
			out.println(String.format(test.getStudentName(i) + "\'s average = %.2f",test.getStudentAverage(i)));	
		}

		out.println("Failure List = " + test.getFailureList(70));	
		out.println("Highest Average = " + test.getStudentWithHighestAverage());
		out.println("Lowest Average = " + test.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",test.getClassAverage()));	
	}		
}