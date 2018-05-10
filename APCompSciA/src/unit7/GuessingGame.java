package unit7;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;

import java.util.Random;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;

	public GuessingGame()
	{
	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Guessing Game - How many numbers?");
		upperBound=keyboard.nextInt();
		int target = r.nextInt(upperBound)+1;
		int guess = 0;
		int numOfGuesses= 0;
		while (guess != target) {
			System.out.println("Enter a number between 1 and "+upperBound+":");
			guess = keyboard.nextInt();
			numOfGuesses++;
		}
		System.out.println("\nIt took you "+numOfGuesses+" guesses to guess "+ target);
		double percentWrong = ((numOfGuesses-1)/upperBound)*100;
		System.out.println("You guessed wrong "+percentWrong+" percent of the time.");
	}
}
