package unit14;

public class LargestJournal {
	int largest=Integer.MIN_VALUE;
	int[] arr;
	
	public LargestJournal(int[] x) {
		arr = x; 
	}
	
	public int findLargest(int i) {
		if (i>=0&&i<arr.length&&(arr[i]>largest))
		{
			largest = arr[i];
			arr[i]=0;
			findLargest(i+1);
		}
		return largest;
	}
	
	public String toString() {
		String output = "The largest number is "+ largest;
		return output;
	}

}
