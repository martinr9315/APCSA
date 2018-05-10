package unit7;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		String response;
		GuessingGame game = new GuessingGame();
		do {
			game.playGame();
			System.out.println("Would you like to play a Guessing Game? (yes/no)");
			response = keyboard.next();
		} while (response=="yes");
	}
}