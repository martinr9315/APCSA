package unit11assesment;

public class Artist {
	private String name;
	private Album[] albums;
	
	public Artist()
	{
		name="";
		albums=new Album[0];
	}
	
	public Artist(String n, int albumCount)
	{
		name = n;
		albums = new Album[albumCount];
	}
	
	public void addAlbum(int albumNum, Album a)
	{
		albums[albumNum] = a;
	}
	
	public String getArtistName()
	{
	   return name;	
	}
	
	public String getAlbumTitle(int albumNum)
	{
		return albums[albumNum].getAlbumTitle();
	}

	public String getLongestAlbum()
	{
		int longest=0;
		String longestAlbum ="";
		for (int i=0; i<albums.length; i++)
		{
			if (longest<albums[i].getNumTracks())
			{
				longest = albums[i].getNumTracks();
				longestAlbum = getAlbumTitle(i);
			}		
		}
		return longestAlbum;
	}

	public String getShortestAlbum()
	{
		int shortest=0;
		String shortestAlbum ="";
		for (int i=0; i<albums.length; i++)
		{
			if (shortest>albums[i].getNumTracks())
			{
				shortest = albums[i].getNumTracks();
				shortestAlbum = getAlbumTitle(i);
			}		
		}
		return shortestAlbum;
	}
	
	public String toString()
	{
		String output="\t---"+getArtistName()+"---\n";
		for (int i=0; i<albums.length; i++)
		{
			output+=albums[i].toString();
		}
		return output;
	}  	
}
