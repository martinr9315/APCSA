package unit13;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

public class Lab22f
{
	public static void main(String args[])
	{
		Comparable[] test1 = {9,5,3,2};
		int n = test1.length;
		QuickSort.quickSort(test1);
		QuickSort.printArray(n, test1);
		
		Comparable[] test2 = {19,52,3,2,7,21};
		n = test2.length;
		QuickSort.quickSort(test2);
		QuickSort.printArray(n, test2);

		Comparable[] test3 = {68,66,11,2,42,31};
		n = test3.length;
		QuickSort.quickSort(test3);
		QuickSort.printArray(n, test3);
		
	}
}


