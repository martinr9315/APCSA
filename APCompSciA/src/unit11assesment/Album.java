package unit11assesment;

import unit11.Student;

public class Album {
	private String title;
	private Song[] tracks;
	
	public Album()
	{
		title="";
		tracks=new Song[0];
	}
	
	public Album(String t, int trackCount)
	{
		title = t;
		tracks = new Song[trackCount];
	}
	
	public void addSong(int trackNum, Song s)
	{
		tracks[trackNum] = s;
	}
	
	public String getAlbumTitle()
	{
	   return title;	
	}
	
	public String getSongName(int trackNum)
	{
		return tracks[trackNum].getName();
	}
	
	public int getNumTracks()
	{
		int numTracks=tracks.length;
		return numTracks;
	}

	public String getLongestSong()
	{
		int longest=0;
		String longestSong ="";
		for (int i=0; i<tracks.length; i++)
		{
			if (longest<tracks[i].getNumNotes())
			{
				longest = tracks[i].getNumNotes();
				longestSong = getSongName(i);
			}		
		}
		return longestSong;
	}

	public String getShortestSong()
	{
		int shortest=1000;
		String shortestSong ="";
		for (int i=0; i<tracks.length; i++)
		{
			if (shortest>tracks[i].getNumNotes())
			{
				shortest = tracks[i].getNumNotes();
				shortestSong = getSongName(i);
			}		
		}
		return shortestSong;
	}
	
	public String toString()
	{
		String output=""+getAlbumTitle()+"\n";
		for (int i=0; i<tracks.length; i++)
		{
			output+=i+1+" - "+getSongName(i)+"\n";
		}
		return output;
	}  	

}
