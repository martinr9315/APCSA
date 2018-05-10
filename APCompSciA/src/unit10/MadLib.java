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
import java.util.Random;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	String story="";
	
	public MadLib()
	{



	}

	public MadLib(String fileName)
	{
		//load stuff
		verbs = new ArrayList<String>();
		loadVerbs();
		
		nouns = new ArrayList<String>();
		loadNouns();
		
		adjectives = new ArrayList<String>();
		loadAdjectives();
		
		try{
			Scanner file = new Scanner(new File(fileName));
			while(file.hasNextLine()) 
			{
			story  = story + (file.nextLine());
			};
			for (int i=0; i<5; i++)
				story = story.replaceFirst("#", getRandomNoun());
			for (int i=0; i<3; i++)
			{
				story = story.replaceFirst("@", getRandomVerb());
				story = story.replaceFirst("&", getRandomAdjective());
			}
			System.out.println(story);

		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\nouns.dat"));
			while(file.hasNextLine()) 
			{
			nouns.add(file.nextLine());
			}	
		}
		catch(Exception e)
		{
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\verbs.dat"));
			while(file.hasNextLine()) 
			{
			verbs.add(file.nextLine());
			}
		}
		catch(Exception e)
		{
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\adjectives.dat"));
			while(file.hasNextLine()) 
			{
			adjectives.add(file.nextLine());
			}
		}
		catch(Exception e)
		{
		}
	}

	public String getRandomVerb()
	{
		Random r = new Random();
		int random = r.nextInt(verbs.size());
		String verb = verbs.get(random);
		return verb;
	}
	
	public String getRandomNoun()
	{
		Random r = new Random();
		int random = r.nextInt(nouns.size());
		String noun = nouns.get(random);
		return noun;
	}
	
	public String getRandomAdjective()
	{
		Random r = new Random();
		int random = r.nextInt(adjectives.size());
		String adj = adjectives.get(random);
		return adj;
	}		

	public String toString()
	{
	   return story;
	}
}