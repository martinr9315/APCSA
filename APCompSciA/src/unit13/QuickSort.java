package unit13;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array


/*quickSort Algorithm
method quicksort(array,low,high)
as long as low is less than high
split = partition(array, low, high)
quicksort(array, low, split)
quicksort(array, split+1, high)
method partition(array,low,high)
pivot is the left most value in array
bot = one less than low
top = one more than high

while bot is less than top
loop as long as bot + 1 is less than pivot
loop as long as top – 1 is more than pivot
check to see if bot and top have crossed
return top
swap bot spot and top spot
*/

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		int high = list.length-1;
		int low = 0;
		quickSort(list, low, high);

	}


	private static void quickSort(Comparable[] list, int low, int high)
	{
		if (low<high)
		{
			int split = partition(list, low, high);
			quickSort(list, low, split-1);
			quickSort(list, split+1, high);
		}
	}


	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable pivot = list[high];
		int i = (low-1);
		for (int j=low; j<high; j++)
		{
			if (pivot.compareTo(list[j])>0)
			{
				i++;
				Comparable temp = list[i];
                list[i] = list[j];
                list[j] = temp;
			}
		}
		
		Comparable temp = list[i+1];
        list[i+1] = list[high];
        list[high] = temp;
		
		return i+1;
	}
	 static void printArray(int n, Comparable[] arr)
	    {
	        for (int i=0; i<n; ++i)
	        {
	            System.out.print(arr[i]+" ");
	        }
	        System.out.println();
	    }
	
}