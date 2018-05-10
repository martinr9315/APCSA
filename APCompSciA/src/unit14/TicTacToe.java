package unit14;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[3][3];
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		int spot=0;
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if (Character.isAlphabetic(game.charAt(spot)))
				{
					mat[i][j]=game.charAt(spot);
					spot++;
				}
			}
		}
	}

	/*The determineWinner method goes through the
matrix to find a winner. It checks for a horizontal
winner first. Then, it checks for a vertical winner.
Lastly, it checks for a diagonal winner. It must
also check for a draw. A draw occurs if neither
player wins.*/

	public String getWinner()
	{
		int XThree=0;
		int OThree=0;
		
		//check horizontal
		for (int i=0; i<3; i++)
		{
			XThree=0;
			OThree=0;
			for (int j=0; j<3; j++)
			{
				if (mat[i][j]=='X')
					XThree++;
				if (mat[i][j]=='O')
					OThree++;
			}
			
		if (XThree==3)
			return "X wins horiztonally!";
		if (OThree==3)
			return "O wins horiztonally!";

		}
		
		//check vertical
		for (int i=0; i<3; i++)
		{
			XThree=0;
			OThree=0;
			for (int j=0; j<3; j++)
			{
				if (mat[j][i]=='X')
					XThree++;
				if (mat[j][i]=='O')
					OThree++;
			}	
			
		if (XThree==3)
			return "X wins vertically!";
		if (OThree==3)
			return "O wins vertically!";
		}
		
		
		//check diagonals
		XThree=0;
		OThree=0;
		for (int i=0; i<3; i++)
		{
			if (mat[i][i]=='X')
				XThree++;
			if (mat[i][i]=='O')
				OThree++;
		}
		if (XThree==3)
			return "X wins diagonally!";
		if (OThree==3)
			return "O wins diagonally!";
		
		XThree=0;
		OThree=0;
		int r=0;
		for (int i=2; i>=0; i--)
		{
			if (mat[r][i]=='X')
				XThree++;
			if (mat[r][i]=='O')
				OThree++;
			r++;
		}
		
		if (XThree==3)
			return "X wins diagonally!";
		if (OThree==3)
			return "O wins diagonally!";
		

		return "cat's game - no one wins";
	}

	public String toString()
	{
		String output="";
		for (int i=0; i<mat.length; i++)
		{
			for (int j=0; j<mat.length; j++)
			{
				output+=mat[i][j];
			}
			output+="\n";
		}
		
		output+=getWinner();

		return output;
	}
}