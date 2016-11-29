package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import FourRowSolitaire.Card;
import FourRowSolitaire.SingleCell;

/**
 * @author SER 216 Team 7: Morgan Osborne, Julio Jovel, Kenneth Bonilla
 *
 * This set of tests check that all of the methods in the SingleCell class function as expected.
 */
public class TestSingleCell {
	/**
	 *  Tests that a single cell is empty when it is generated
	 */
	@Test
	public void testSingleCellIsEmpty() {
		SingleCell single_cell = new SingleCell(); // Generates a new single cell
		
		boolean valid = single_cell.isEmpty(); // if the cell is empty then it is valid, otherwise it is not
		
		AssertJUnit.assertTrue(valid); // the cell should be empty, therefore valid = true
	}
	
	/**
	 *  Tests that if a cell is empty, a card can be added to it.
	 */
	@Test
	public void testAddCardToEmptySingleCell() {
		SingleCell single_cell = new SingleCell(); // Generates a new single cell
		
		Card ace_of_spades = new Card("Spades", 1, 1, 1); // Generates an Ace of Spades card
		
		single_cell.push(ace_of_spades); // Push the ace of spades onto the single cell
		
		// The card in the single cell should be the ace of spades
		AssertJUnit.assertTrue(single_cell.getCardAtLocation(0).getSuit() == "Spades" && single_cell.getCardAtLocation(0).getNumber() == 1);
	}
	
	/**
	 *  Tests that if a cell already has a card, another cannot be added.
	 */
	@Test
	public void testAddCardToFullSingleCell() {
		SingleCell single_cell = new SingleCell(); // Generates a new single cell
		
		Card ace_of_spades = new Card("Spades", 1, 1, 1); // Generates an Ace of Spades card
		
		Card card = new Card("Spades", 1, 1, 1); // Generates a card to serve as a placeholder
		
		if(single_cell.isValidMove(ace_of_spades))
			single_cell.push(ace_of_spades); // Pushes the ace of spades onto the single cell
		
		// The card in the single cell should be the ace of spades
		AssertJUnit.assertTrue(single_cell.getCardAtLocation(0).getSuit() == "Spades" && single_cell.getCardAtLocation(0).getNumber() == 1);
		
		Card ace_of_diamonds = new Card("Diamonds", 1, 1, 27); // Generates an Ace of Diamonds card
		
		if(single_cell.isValidMove(ace_of_diamonds))
		{
			// Sets card equal to the value returned by single_cell.push()
			// single_cell.push() checks if the single cell is empty. if it's not then it returns null
			card = single_cell.push(ace_of_diamonds);
		}
		
		card = single_cell.getCardAtLocation(0);
		
		// The card should still be the ace of spades since the ace of diamonds could not be added
		AssertJUnit.assertTrue(card.getSuit() == "Spades" && card.getNumber() == 1);	
	}
	
	/**
	 *  Tests that the Single Cell is able to be cleared with pop()
	 */
	@Test
	public void testClearSingleCell() {
		SingleCell single_cell = new SingleCell(); // Generates a new single cell
		
		Card ace_of_spades = new Card("Spades", 1, 1, 1); // Generates an Ace of Spades card
		
		Card card = new Card("Spades", 1, 1, 1); // Generates a card to serve as a placeholder
		
		single_cell.push(ace_of_spades); // Pushes the ace of spades onto the single cell
		
		// The card in the single cell should be the ace of spades
		AssertJUnit.assertTrue(single_cell.getCardAtLocation(0).getSuit() == "Spades" && single_cell.getCardAtLocation(0).getNumber() == 1);
		
		card = single_cell.pop(); // Remove the card in the cell
		
		// Check that the card removed is the ace of spades, since that is what was added
		AssertJUnit.assertTrue(card.getSuit() == "Spades" && card.getNumber() == 1);
		
		// Check that the cell is now empty again
		AssertJUnit.assertTrue(single_cell.isEmpty() == true);
	}
}
