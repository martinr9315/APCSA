package unit14;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		//instantiate an AtCounter
		AtCounter test = new AtCounter();
		//test the code
		test.countAts(0,0);
		out.println(test.toString());
		test.countAts(2,5);
		out.println(test.toString());
		test.countAts(5,0);
		out.println(test.toString());
		test.countAts(9,9);
		out.println(test.toString());
		test.countAts(3,9);
		out.println(test.toString());
	}
}