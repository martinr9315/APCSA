package unit11assesment;

import unit11.Grades;

public class Song {
	private String name;
	private Notes melody;
	
	public Song()
	{
		setName("");
		setMelody("");
	}
	
	public Song(String name, String m)
	{
		setName(name);
		setMelody(m);
	}
	
	public void setName(String n)
	{
		name = n;
	}	
	
	public void setMelody(String m)
	{
		melody = new Notes(m); 
	}
	
	public void setNote(int spot, char n)
	{
		melody.setNote(spot, n);
	}

	public String getName()
	{
		return name;
	}
	
	public int getNumNotes()
	{
		return melody.getNumNotes();
	}
	
	public String toString()
	{
		String output = name +"'s notes: " + melody.toString();
		return output;
	}	

}
