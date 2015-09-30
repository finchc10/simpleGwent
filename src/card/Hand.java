package card;

import java.util.ArrayList;

public class Hand 
{
	private ArrayList<Card> cardsInHand;
	
	public Hand()
	{
		cardsInHand = new ArrayList<Card>(10);
	}
	
	public void addCard(Card card)
	{
		cardsInHand.add(card);
	}
	
	public Card playCard(int index)
	{
		return cardsInHand.remove(index);
	}
	
	public Card getCard(int index)
	{
		return cardsInHand.get(index);
	}
}
