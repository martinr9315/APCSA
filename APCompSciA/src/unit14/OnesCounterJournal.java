package unit14;

public class OnesCounterJournal {
	int[][] mat = new int[6][6];
	
	public OnesCounterJournal() {
		for (int i=0; i<6; i++)
		{
			for (int j=0; j<6; j++)
			{
				mat[i][j] = (int)Math.round(Math.random());
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}
	
	public String checkRowIsEven(int r)
	{
		int ones=0;
		for (int i=0; i<6; i++)
		{
			if (mat[r][i]==1)
				ones++;
		}
		
		if (ones%2==0)
			return "Row " +(r+1)+ " has an even number of ones";
		return "Row " +(r+1)+ " does not have an even number of ones";
	}
	
	public String checkColumnIsEven(int r)
	{
		int ones=0;
		for (int i=0; i<6; i++)
		{
			if (mat[i][r]==1)
				ones++;
		}
		
		if (ones%2==0)
			return "Column " +(r+1)+ " has an even number of ones";
		return "Column " +(r+1)+ " does not have an even number of ones";
	}
	
	public String toString()
	{
		String output = "";
		for (int i=0; i<6; i++)
		{
			output+= checkColumnIsEven(i) + "\n";
		}
		for (int i=0; i<6; i++)
		{
			output+= checkRowIsEven(i) + "\n";
		}
		return output;
	}
	
}
