package unit14;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private int[][] visited;
   private boolean hasExit;

	public Maze()
	{
		maze = new int[1][1];
	}

	public Maze(int size, String line)
	{
		hasExit = false;
		
		Scanner file = new Scanner(line);
		maze = new int[size][size];
		visited = new int[size][size];
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				maze[i][j]=file.nextInt();
				visited[i][j]=0;
			}
		}
	}

	/*if ( r and c are in bounds and current spot is a 1 )
		mark spot as visited
		if we are at the exit
		mark exit found as true
		else
		4 recursive calls up down left right
		*/
	public void hasExitPath(int r, int c)
	{
		if (r>=0&&r<maze.length&&c>=0&&c<maze.length&&maze[r][c]==1&&visited[r][c]==0)
		{
			visited[r][c]=1;
			//maze[r][c]=3;
			if (c==maze.length-1)
				hasExit=true;
			else 
			{
				hasExitPath(r+1,c);
				hasExitPath(r-1,c);
				hasExitPath(r,c+1);
				hasExitPath(r,c-1);
			}
		}
		
	}

	public String toString()
	{
		String output="";
		for (int i=0; i<maze.length; i++)
		{
			for (int j=0; j<maze.length; j++)
			{
				output+=maze[i][j]+" ";
			}
			output+="\n";
		}
		if (hasExit)
			output+="exit found\n";
		else
			output+="exit not found\n";
		return output;
	}
}