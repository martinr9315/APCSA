package unit13;

public class FactorialJournal {
	
	double factorial=1;
	
	public FactorialJournal(int num)
	{
		for (int i=1; i<=num; i++)
		{
			factorial=factorial*i;
		}
	}
	
	public String toString() {
		String output = "" +factorial;
		return output;
	}

}
