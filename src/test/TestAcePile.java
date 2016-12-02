package Test;

package test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import FourRowSolitaire.AcePile;
import FourRowSolitaire.Card;

/**
 * @author SER 216 Team 7: Morgan Osborne, Julio Jovel, Kenneth Bonilla
 * 
 *	This test checks that all methods in acePileTest() function as expected.
 */

public class TestAcePile {
	/**
	 *  Checks that the ace pile is generated with the correct suit.
	 */
	@Test
	public void testAcePileGeneration() {
		AcePile ace_pile = new AcePile("Spades"); // Generates new ace pile for Spades suit
	  
		// The suit of the ace_pile should be stored as spades
		AssertJUnit.assertTrue(ace_pile.getSuit() == "Spades");
  	}
  
	/**
	 *  Tests that the right number of valid cards were added to the acePile
	 */
	@Test
  	public void testAddValidSuitCardsToAcePile() {
		AcePile ace_pile = new AcePile("Spades"); // Generates new ace pile for Spades suit
	  
		// The suit of the ace_pile should be stored as spades
		AssertJUnit.assertTrue(ace_pile.getSuit() == "Spades");
	  
		// Pushes each card of the suit onto the ace pile from ace to king
		for(int i = 1; i <= 13 ; i++)
		{
			Card card = new Card(ace_pile.getSuit(), i, 1, i); // Generates new card
			if(ace_pile.isValidMove(card)) // Checks if the card is valid
				ace_pile.push(card); // Pushes card onto ace pile
	  	}
		
		// Checks that the ace_pile has the right amount of cards in it
		AssertJUnit.assertTrue(ace_pile.length() == 13);
		
		// And checks that the last card is the King
		AssertJUnit.assertTrue(ace_pile.pop().getFullNumber() == 13);
	}
	
	@Test
	public void testAddingInvalidCardsToEmptyAcePile() {
		AcePile ace_pile = new AcePile("Spades"); // Generates new ace pile for Spades suit
		  
		// The suit of the ace_pile should be stored as spades
		AssertJUnit.assertTrue(ace_pile.getSuit() == "Spades");
		 
		Card card = new Card("Spades", 2, 1, 2);
		if(ace_pile.isValidMove(card))
			ace_pile.push(card);
		
		// Expect the ace pile to be empty since the 2 of spades was not a valid card
		AssertJUnit.assertTrue(ace_pile.length() == 0);
	}
	
	/**
	 *  Tests that all of the cards were pushed into the ace pile in order
	 *  and that the ace pile is able to be cleared
	 */
	@Test
	public void testClearingTheAcePile() {
		AcePile ace_pile = new AcePile("Spades"); // Generates new ace pile for Spades suit
		  
		// The suit of the ace_pile should be stored as spades
		AssertJUnit.assertTrue(ace_pile.getSuit() == "Spades");
	  
		// Pushes each card of the suit onto the ace pile from ace to king
		for(int i = 1; i <= 13 ; i++)
		{
			Card card = new Card(ace_pile.getSuit(), i, 1, i); // Generates new card
			if(ace_pile.isValidMove(card)) // Checks if the card is valid
				ace_pile.push(card); // Pushes card onto ace pile
	  	}
		
		// Checks that the ace_pile has the right amount of cards in it
		AssertJUnit.assertTrue(ace_pile.length() == 13);
		
		// Clears the ace_pile and checks that each card removed is the correct
		// card that comes before the last card removed from King to Ace
		for(int j = 13; j >= 1; j--)
		{
			AssertJUnit.assertTrue(ace_pile.pop().getFullNumber() == j);
		}
	}
	
	/**
	 *  Test tries to add a valid card without first checking if the move is valid. This is to test the 
	 *  conditional statement in the push() method of the AcePile class.
	 */
	@Test
	public void testAddValidCardsToEmptyAcePileBypassingIsValidMove(){
		AcePile ace_pile = new AcePile("Spades"); // Generates new ace pile for Spades suit
		  
		// The suit of the ace_pile should be stored as spades
		AssertJUnit.assertTrue(ace_pile.getSuit() == "Spades");
		
		// Pushes each card of the suit onto the ace pile from ace to king
		for(int i = 1; i <= 13 ; i++)
		{
			Card card = new Card(ace_pile.getSuit(), i, 1, i); // Generates new card
			ace_pile.push(card); // Pushes card onto ace pile without checking isValidMove()
		 }
				
		// Checks that the ace_pile has the right amount of cards in it
		AssertJUnit.assertTrue(ace_pile.length() == 13);
				
		// Clears the ace_pile and checks that each card removed is the correct
		// card that comes before the last card removed from King to Ace
		for(int j = 13; j >= 1; j--)
		{
			AssertJUnit.assertTrue(ace_pile.pop().getFullNumber() == j);
		}
	}
	
	/**
	 * Test tries to add an invalid card without first checking if the move is valid. This is to test the 
	 * conditional statement in the push() method of the AcePile class.
	 */
	@Test
	public void testAddInvalidCardToEmptyColumnBypassingIsValidMove(){
		AcePile ace_pile = new AcePile("Spades"); // Generates new ace pile for Spades suit
		  
		// The suit of the ace_pile should be stored as spades
		AssertJUnit.assertTrue(ace_pile.getSuit() == "Spades");
		 
		Card card = new Card("Spades", 2, 1, 2);
		ace_pile.push(card);
		
		// Expect the ace pile to be empty since the 2 of spades was not a valid card
		AssertJUnit.assertTrue(ace_pile.length() == 0);
	}
	
	/**
	 * Test tries to add an invalid card without first checking if the move is valid. This is to test the 
	 * conditional statement in the push() method of the AcePile class.
	 * 
	 */
	@Test
	public void testAddInvalidCardBypassingIsValidMove(){
		AcePile ace_pile = new AcePile("Spades"); // Generates new ace pile for Spades suit
		  
		// The suit of the ace_pile should be stored as spades
		AssertJUnit.assertTrue(ace_pile.getSuit() == "Spades");
		
		Card ace_of_spades = new Card("Spades", 1, 1, 1); // Generates new card
		ace_pile.push(ace_of_spades); // Pushes card onto ace pile without checking isValidMove()
				
		// Checks that the ace_pile has only the ace in it
		AssertJUnit.assertTrue(ace_pile.length() == 1);
		AssertJUnit.assertTrue(ace_pile.getCardAtLocation(0).getFullNumber() == 1);
		
		Card king_of_spades = new Card("Spades", 13, 1, 13); // Generates new card
		ace_pile.push(king_of_spades); // Attempts to push card onto ace pile without checking isValidMove()
	
		// Checks that the ace pile still only has one card on it
		AssertJUnit.assertTrue(ace_pile.length() == 1);
		
		AssertJUnit.assertTrue(ace_pile.peek().getNumber() == Card.ACE);
	}
	
}
