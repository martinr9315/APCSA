package unit13;
import java.util.Arrays;
import java.util.Random;
import java.lang.System.*;

public class SortJournal {
	Random r = new Random();
	
	int[] arr = new int[100];
	int[] tester = new int[100];
	
	public void fillArrays()
	{
		int random;
		for (int i=0; i<arr.length; i++)
		{
			random = r.nextInt();
			arr[i]=random;
			tester[i]=i+1;
		}
	}
	
	public String linearSearch(int num)
	{
		int result=0;
		for (int i=0; i<arr.length; i++)
		{
			if (arr[i]==num)
				result=i;
		}
		String output = num + " is at index " + result;
		return output;
	}
	
	public String binarySearch(int num)
	{
		int result = Arrays.binarySearch(arr, num);
		String output = num + " is at index " + result;
		return output;	
	}
}
