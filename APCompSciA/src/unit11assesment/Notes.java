package unit11assesment;

public class Notes {
private char[] notes;
	
	public Notes()
	{
		setNotes("");
	}
	
	public Notes(String notes)
	{
		setNotes(notes);		
	}
	
	public void setNotes(String n)
	{
		notes = new char[n.length()];
		for (int i=0; i<n.length(); i++)
		{
			notes[i] = n.charAt(i);
		}
		
	}
	
	public void setNote(int spot, char note)
	{
		notes[spot] = note;
	}
	
	public int getNumNotes()
	{
		return notes.length;
	}
	
	public String toString()
	{
		String output="";

		for (int i=0; i<notes.length; i++)
		{
		  output= output + notes[i] + " ";
		}
		return output;

	}	
}