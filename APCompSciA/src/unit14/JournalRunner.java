package unit14;

import java.util.Scanner;
import java.lang.System.*;
public class JournalRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a list of 8 numbers");
		int[] arr = new int[8];
		for (int i=0; i<8; i++)
		{
			System.out.print(i+1+": ");
			arr[i]=keyboard.nextInt();
		}
		
		
		LargestJournal test = new LargestJournal(arr);
		//test the code
		test.findLargest(0);
		System.out.println(test.toString());
		*/
		
		OnesCounterJournal test = new OnesCounterJournal();
		System.out.println(test.toString());
	}

}
