package Test;

import java.util.LinkedList;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import FourRowSolitaire.*;



/**
 * This test is to test the Ace Pile
 * @author Team 7 SER216
 *
 */
public class TestingAcePile {
  @Test
  public void acePileTest() {
		  //identify and initialize variables that will be used.
	Deck testDeck = new Deck(1);
	Card topCard;
	LinkedList<Integer> aceList = new LinkedList<Integer>();
	LinkedList<Card> aceCards;
	AcePile ace_deck = new AcePile("Spades");
	String suit = "Spades";
	  
	  
	  //add integers to the aceList LinkedList
	for (int i=1; i<14;i++){
	  aceList.add(i);
	}
	  
	  //for testing purposes this allows the tester to see the items 
	  //in aceList
//	  for(Integer i: aceList){
//		  System.out.println(i);
//	  }
	  
	  //call to add specific cards through the getDeck Method
	  //and add them to the LinkedList<Cards>
	aceCards = testDeck.getDeck(aceList);
	  
	  //Print line to show that ace_deck is empty and assertion
	AssertJUnit.assertTrue(ace_deck.isEmpty());
	System.out.println("Ace deck is empty: "+ace_deck.isEmpty());
	  
	  //for testing purposes this allows us to print out the cards
//	  for (Card card: aceCards){
//		  System.out.println(card.getSuit()+" "+card.getFullNumber());
//	  }
	  
	  
	  //Use a for each loop to push each card onto the ace_deck pile
	for (Card card: aceCards){
		ace_deck.push(card);
	 }
	  
	  
	//assertion and printline that ace_deck is no longer empty  
	AssertJUnit.assertFalse(ace_deck.isEmpty());
	System.out.println("Ace deck is empty: "+ace_deck.isEmpty());
	
	//check to see if ace_deck is full by checking the last card in the deck
	//and making sure it is the highest card that can be in the deck.
	
	int aceSize = 13;
	topCard= ace_deck.peek();

	
	//Assertion and printline that ace_deck is filled and top card is the same suit
	AssertJUnit.assertEquals(aceSize, topCard.getFullNumber());
	AssertJUnit.assertEquals(suit, topCard.getSuit());
	System.out.println("Passed, ace deck pile filled and top card is a Spade.");
	
	//for loop to empty ace_deck using pop()
	for (int i=1; i<14;i++){
		ace_deck.pop();
	}
	
	//assertion and printline showing that ace_deck is empty again
	AssertJUnit.assertTrue(ace_deck.isEmpty());
	System.out.println("Ace deck is empty: "+ace_deck.isEmpty());  
	
  }
 
}
