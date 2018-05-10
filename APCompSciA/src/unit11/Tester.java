package unit11;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner str = new Scanner("1 - 2.0 3.5");
		System.out.println(str.nextInt());
		String skip = str.next(" - ");
		System.out.println(str.nextDouble());
		

		
		
	}

}
