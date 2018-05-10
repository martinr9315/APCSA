package unit9;

import java.util.Scanner;

public class EliminateDuplicate {
	
	static String List = ""; 
	
	public static void inputList()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a list of ten numbers: ");
		for (int i=0; i<10; i++)
		{
			List= keyboard.next();
		}
	}
	public static String eliminateDuplicates(String List)
	{
		String distinct = ""; 
		for(int i=0; i<List.length(); i++)
		{
			char current = List.charAt(i);
			if (distinct.indexOf(current)==-1)
			{
				distinct+=current+" ";
			}
		}
		return distinct; 
	}
	
	public static String toString(int[] input)
	{
		String output="";
		for (int i=0; i<input.length; i++)
		{
			output += input[i] + " ";
		}
		return output;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputList();
		System.out.println(eliminateDuplicates(List));
		

	}

}
