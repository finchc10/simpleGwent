/**
 * Donald Aufiero
 */
package card;

import java.util.ArrayList;

/**
 * A collection of Cards that a Player has not yet played.
 */
public class Hand 
{
	private ArrayList<Card> cardsInHand;
	
	public Hand()
	{
		cardsInHand = new ArrayList<Card>(5);
	}
	
	public void addCard(Card card)
	{
		cardsInHand.add(card);
	}
	
	public Card playCard(int index)
	{
		Card cardToPlay = cardsInHand.get(index);
		
		cardsInHand.set(index, null);
		
		return cardToPlay;
	}
	
	public Card getCard(int index)
	{
		return cardsInHand.get(index);
	}
	
	public Integer getHandSize()
	{
		return cardsInHand.size();
	}
	
	public String toString()
	{
		return cardsInHand.toString();
	}
	
	public Hand copy()
	{
		Hand handCopy = new Hand();
		
		for(Card c : cardsInHand)
		{
			if(c != null)
			{
				handCopy.addCard(c.copy());
			}
		}
		
		return handCopy;
	}
}
