package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.LinkedList;
import FourRowSolitaire.Card;
import FourRowSolitaire.Deck;

/**
 * @author SER 216 Team 7: Morgan Osborne, Julio Jovel, Kenneth Bonilla
 * 
 * Tests that one card from each suit is generated.
 *
 */
public class TestCardGeneration {

	  	/**
		 *  Tests that one card from each suit is generated.
		 */
		@Test
		public void testOneCardFromEachDeckIsGeneratd() {
			Deck test_deck = new Deck(1); //Generates a new deck
			  
			LinkedList<Card> cards = test_deck.getDeck(); // Makes a linked list of cards in the deck
			
			// For each card in the deck of cards check that the cards are numbered in the correct
			// order, meaning that the correct number cards from each suit is generated
			for(Card card : cards)
			{
				if(card.getFullNumber() == 1)
					AssertJUnit.assertTrue(card.getSuit() == "Spades" && card.getNumber() == 1);
				else if(card.getFullNumber() == 14)
					AssertJUnit.assertTrue(card.getSuit() == "Clubs" && card.getNumber() == 1);
				else if(card.getFullNumber() == 27)
					AssertJUnit.assertTrue(card.getSuit() == "Diamonds" && card.getNumber() == 1);
				else if(card.getFullNumber() == 40)
					AssertJUnit.assertTrue(card.getSuit() == "Hearts" && card.getNumber() == 1);
				else if(card.getFullNumber() > 52)
					Assert.fail();
			}
			
		}	
}
