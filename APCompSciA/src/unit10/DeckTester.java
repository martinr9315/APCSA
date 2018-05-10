package unit10;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] allRanks = {"Ace","King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
		String[] allSuits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		int[] allPointValues = {11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		
		Deck test = new Deck(allRanks, allSuits, allPointValues);
		
		test.shuffle();
		
		for (int i=0; i<52; i++)
		{
			System.out.println(test.deal());
		}
		
		test.shuffle();
		System.out.println("\n");
		
		for (int i=0; i<52; i++)
		{
			System.out.println(test.deal());
		}
	}
}