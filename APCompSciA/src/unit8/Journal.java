package unit8;

import java.util.Arrays;

public class Journal {
	
	public static void main(String[] args) {
	  
		int[] random = new int[100];
		int[] places = {0,1,2,3,4,5,6,7,8,9};
		int[] counts = new int[10];
	    
	    for (int i=0; i<random.length; i++) 
	    {
	      random[i] = (int )(Math.random() * 9);
	    }
	    System.out.println(Arrays.toString(random)+"\n");
	    
	    for (int i=0; i<random.length; i++)
	    {
	    	for (int n=0; n<=9; n++)
	    	{
	    		if (random[i]==n)
	    		{
	    			counts[n]++;
	    		}
	    	}
	    }
	    System.out.println(Arrays.toString(places));
	    System.out.println(Arrays.toString(counts));
	  }
}
