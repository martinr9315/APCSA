package unit8;

import java.util.Random;
import java.util.Scanner;
public class Hangman {
  
  String[] words = {"orange","palm","beach","monkey","sunblock","fondue"};
  int wrongGuesses=0;
  String targetWord;
  char[] Hidden;
  String guessedLetter;
  
  public Hangman() {
    Random r = new Random();
    targetWord = words[r.nextInt(words.length)];
    Hidden = new char[targetWord.length()];
    for (int i=0; i<targetWord.length(); i++)
    {
    	Hidden[i]='*';
    }
    System.out.println(targetWord);
    
  }
  
  public void playGame() {
	  Scanner keyboard = new Scanner(System.in);
		  boolean done = false;
		  while (done!=true)
		  {
			  System.out.print("Guess a letter in word " + new String(Hidden)+"::");
			  guessedLetter = keyboard.next();
			  int guessedLetterIndex = targetWord.indexOf(guessedLetter);
			  if (guessedLetterIndex!=-1)
			  {
			  	for (int i=0; i<targetWord.length(); i++)
			  	{
			  		if (i==guessedLetterIndex){
			  			Hidden[i]=targetWord.charAt(i);
			  		}
			  	}//end for loop
			  }//end if
			  else
			  {
				  System.out.println(guessedLetter+" is not in the word");
				  wrongGuesses++;
			  }
			  if (!(new String(Hidden).contains("*"))) {
				  	done=true;
			  }//end if
			}//end while
		  System.out.println("The word is "+ targetWord+". You missed "+wrongGuesses+" times.");
		  System.out.println("Do you want to play again? Enter y/n");
		  String response = keyboard.next();
		  
  }//end playGame
  
  public static void main(String[] args) {
    Hangman test = new Hangman();
    test.playGame();
  }
}

