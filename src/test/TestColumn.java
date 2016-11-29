package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import FourRowSolitaire.Card;
import FourRowSolitaire.Column;

/**
 * @author SER 216 Team 7: Morgan Osborne, Julio Jovel, Kenneth Bonilla
 * 
 * This test set tests that the Column class works as expected - A King should be able to be added to an empty
 * column, and any other card should not. A card of opposite color and 1 number less should be able to be added
 * after the current card.
 *
 */
public class TestColumn {
	/**
	 *  Tests that a Column is empty when it is generated
	 */
	@Test
  	public void testGenerateEmptyColumn() {
	  	Column col = new Column(); // Generates a new column
	  
	  	AssertJUnit.assertTrue(col.peek() == null); // checks that the column is empty
  	}
	
	/**
	 *  Tests that a king can be successfully added to an empty column
	 */
	@Test
	public void testAddCardToEmptyColumn() {
		Column col = new Column(); // Generates a new column
		
		Card king_of_hearts = new Card("Hearts", 13, 1, 52); // Generates a new card
		
		if(col.isValidMove(king_of_hearts)) // if placing the king of hearts is valid
			col.push(king_of_hearts); // push king of hearts onto the column
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.peek().getFullNumber() == 52);
	}
	
	/**
	 *  Tests that a card other than king cannot be added to an empty column
	 */
	@Test
	public void testAddInvalidCardToEmptyColumn(){
		Column col = new Column(); // Generates a new column
		
		Card four_of_spades = new Card("Spades", 4, 1, 4); // Generates a new card
		
		if(col.isValidMove(four_of_spades)) // if placing the four of spades is valid
			col.push(four_of_spades); // push five of spades onto column
		
		// Since pushing the five of spades should be invalid,
		// we expect that column is still empty
		AssertJUnit.assertTrue(col.peek() == null);
	}
	
	/**
	 *  Tests that an invalid card is not able to be pushed onto a column
	 */
	@Test
	public void testAddingInvalidCard() {
		Column col = new Column(); // Generates a new column
		
		Card king_of_hearts = new Card("Hearts", 13, 1, 52); // Generates a new card
		
		if(col.isValidMove(king_of_hearts)) // if placing the king of hearts is valid
			col.push(king_of_hearts); // push king of hearts onto the column
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.pop().getFullNumber() == 52);
		
		Card five_of_spades = new Card("Spades", 5, 1, 5); // Generates the 4 of spades
		Card card = new Card("Spades", 5, 1, 5); // Creates a placeholder card
		
		if(col.isValidMove(five_of_spades)) // if placing the 5 of spades is valid
			card = col.push(five_of_spades); // push 5 of spades onto the column
		else
			card = null; // if the five_of_spades is not a valid card to add then we set card = null
		
		//Since the five of spades was not valid, we expect card to equal null
		AssertJUnit.assertTrue(card == null);
	}
	
	
	/**
	 *  Tests that a valid card can be added to a column.
	 *  
	 *  This test will fail because the isValidMove() method in Column.java
	 *  is written incorrectly.
	 */
	@Test
	public void testAddingValidCard(){
		Column col = new Column(); // Generate new column
		
		Card king_of_hearts = new Card("Hearts", 13, 1, 52); // Generates king of hearts card
		
		if(col.isValidMove(king_of_hearts)) // if placing the king of hearts is valid
			col.push(king_of_hearts);
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.peek().getFullNumber() == 52);
		
		Card queen_of_spades = new Card("Spades", 12, 1, 12); // Generates queen of spades
		
		if(col.isValidMove(queen_of_spades)) // if queen of spades is a valid move, it will be pushed onto the column
			col.push(queen_of_spades); // push queen of spades onto the column
		
		// Since queen of spades is not the same color of king of hearts and it is one number lower,
		// we expect it to be pushed onto the column
		AssertJUnit.assertTrue(col.peek().getFullNumber() == 12);
	}
	
	/**
	 *  Tests that a column is able to be cleared
	 */
	@Test
	public void testClearingColumn(){
		Column col = new Column(); // Generate new column
		
		Card king_of_hearts = new Card("Hearts", 13, 1, 52); // Generates king of hearts card
		
		if(col.isValidMove(king_of_hearts)) // if placing the king of hearts is valid
			col.push(king_of_hearts);
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.pop().getFullNumber() == 52);
		
		// Since we popped the king of hearts in the last assert statement, we
		// assume that the column is now empty.
		AssertJUnit.assertTrue(col.peek() == null);
	}
	
	/**
	 *  Test tries to add a valid card without first checking if the move is valid. This is to test the 
	 *  conditional statement in the column class.
	 */
	@Test
	public void testAddValidCardToEmptyColumnBypassingIsValidMove(){
		Column col = new Column(); // Generate new column
		
		Card king_of_hearts = new Card("Hearts", 13, 1, 52); // Generates king of hearts card
		
		col.push(king_of_hearts);
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.peek().getFullNumber() == 52);
	}
	
	/**
	 * Test tries to add an invalid card without first checking if the move is valid. This is to test the 
	 * conditional statement in the column class.
	 * 
	 * This test fails because push() doesn't check for whether or not the column is empty
	 */
	@Test
	public void testAddInvalidCardToEmptyColumnBypassingIsValidMove(){
		Column col = new Column(); // Generates a new column
		
		Card queen_of_hearts = new Card("Hearts", 12, 1, 51); // Generates a new card
		
		col.push(queen_of_hearts); // push king of hearts onto the column
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.peek() == null);
	}
	
	/**
	 * Test tries to add an invalid card without first checking if the move is valid. This is to test the 
	 * conditional statement in the column class.
	 * 
	 */
	@Test
	public void testAddInvalidCardBypassingIsValidMove(){
		Column col = new Column(); // Generates a new column
		
		Card king_of_hearts = new Card("Hearts", 13, 1, 52); // Generates a new card
	
		col.push(king_of_hearts); // push king of hearts onto the column
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.peek().getFullNumber() == 52);
		
		Card five_of_spades = new Card("Spades", 5, 1, 5); // Generates the 4 of spades
		Card card = new Card("Spades", 5, 1, 5); // Creates a placeholder card
		
		card = col.push(five_of_spades); // push 5 of spades onto the column
	
		//Since the five of spades was not valid, we expect card to equal null
		AssertJUnit.assertTrue(card == null);
	}
	
	/**
	 * Test tries to add a valid card without first checking if the move is valid. This is to test the 
	 * conditional statement in the column class.
	 * 
	 */
	@Test
	public void testAddValidCardBypassingIsValidMove(){
		Column col = new Column(); // Generates a new column
		
		Card king_of_hearts = new Card("Hearts", 13, 1, 52); // Generates a new card
	
		col.push(king_of_hearts); // push king of hearts onto the column
		
		// Since pushing the king of hearts should work since the column was empty,
		// we expect that the number of the card will be 52
		AssertJUnit.assertTrue(col.peek().getFullNumber() == 52);
		
		Card queen_of_spades = new Card("Spades", 12, 1, 12); // Generates the 4 of spades
		
		col.push(queen_of_spades); // push 5 of spades onto the column

		// Queen of spades was a valid card, so it should be the last card in the column
		AssertJUnit.assertTrue(col.peek().getFullNumber() == 12);
	}
	
}
