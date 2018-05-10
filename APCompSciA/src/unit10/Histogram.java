package unit10;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -



import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;
	
	String data;

	public Histogram()
	{




	}

	public Histogram(char[] values, String fName)
	{
		letters = new ArrayList<Character>();
		for (int i=0; i<values.length; i++)
		{
			letters.add(values[i]);
		}
		fileName = fName;

		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		count = new ArrayList<Integer>();
		Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\"+fileName));
		while(file.hasNextLine()) 
		{
		data  = data + (file.nextLine());
		};
		
		
		int num=0;
		
		for (int i=0; i<letters.size();i++)
		{
			for (int c=0; c<data.length();c++)
			{
				if (data.charAt(c)==letters.get(i))
				{
					num++;
				}
			}
			count.add(num);
			num = 0;
		}
	}
	

	public char mostFrequent()
	{
		int max = count.get(0);
		int maxIndex=0;
		for (int i=1; i<count.size(); i++)
		{
			if (count.get(i)>max)
			{
				max=count.get(i);
				maxIndex = i;
			}
		}
		
		char mostFrequent = letters.get(maxIndex);
		return mostFrequent;
	}

	public char leastFrequent()
	{
		int min = count.get(0);
		int minIndex=0;
		for (int i=1; i<count.size(); i++)
		{
			if (count.get(i)<min)
			{
				min=count.get(i);
				minIndex = i;
			}
		}
		
		char leastFrequent = letters.get(minIndex);
		return leastFrequent;
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}