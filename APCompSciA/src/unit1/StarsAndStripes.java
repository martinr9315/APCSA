package unit1;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StarsAndStripes
{
 public StarsAndStripes()
 {
    out.println("StarsAndStripes");
 }

 public void printTwentyStars()
 {
	 out.println("********************");
 }

 public void printTwentyDashes()
 {
	 out.println("--------------------");
 }

 public void printTwoBlankLines()
 {
	 out.println("/n/n");
 }
 
 public void printASmallBox()
 {	
	 printTwentyDashes();
	 printTwentyStars();
	 printTwentyDashes();
	 printTwentyStars();
	 printTwentyDashes();
	 printTwentyStars();
	 printTwentyDashes();
 }

 public void printABigBox()
 { 	
	 printASmallBox();
	 printASmallBox();
 }   
}