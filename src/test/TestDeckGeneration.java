package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.LinkedList;

import FourRowSolitaire.*;


/**
 * @author SER 216 Team 7: Morgan Osborne, Julio Jovel, Kenneth Bonilla
 * 
 * Tests that each deck is generated correctly and that the deck is shuffled.
 * 
 */
public class TestDeckGeneration {
	
 /**
 *  Tests that a deck is generated correctly and shuffled - Should have one
 *  of each card and they should be shuffled
 */
	@Test
  	public void testDeckGeneration() {
		Deck test_deck = new Deck(1); //Generates a new deck
	  
		LinkedList<Card> cards = test_deck.getDeck(); // Makes a linked list of cards in the deck
		int sum = 0; // Sum is a variable to keep track of the sum of number of cards
	  
		for(Card card : cards) // For each card in the list of cards add its number to the sum
		{
			sum += card.getFullNumber();
		}
	  
		// If all cards are in the deck once then the sum will be 1378.
		AssertJUnit.assertEquals("Sum of all card numbers should be 1378", 1378, sum); 
  	}

	/**
	 *  Tests that the cards in the deck are shuffled. If the card number after each card
	 *  is one number higher than the last, the cards are not shuffled.
	 */
	@Test
	public void testDeckIsShuffled() {
		Deck test_deck = new Deck(1); //Generates a new deck
		  
		LinkedList<Card> cards = test_deck.getDeck(); // Makes a linked list of cards in the deck
		int cardNum = cards.getFirst().getFullNumber(); // Initializes the first card number to the first card in the deck
		int count = 0; // initializes the count of consecutive cards to 0
		
		for(Card card : cards) // for each card in the deck of cards
		{
			// If the card number is one higher than the last cards number, the count is incremented by one
			if(card.getFullNumber() == (cardNum + 1))
				count += 1;
			
			cardNum = card.getFullNumber();
		}
		
		
		// Since decks don't necessarily get fully shuffled, there is a margin for error of cards
		// being consecutive. We expect that the count of consecutive cards is less than 8
		AssertJUnit.assertTrue(count <= 8);
	}	
}
