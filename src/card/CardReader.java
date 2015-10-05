package card;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class CardReader 
{
	public static void main(String[] args)
	{
		CardReader.readHand("red");
		CardReader.readHand("blue");
	}
	
	public static Hand readHand(String playerColor)
	{
		Hand hand = new Hand();
		
		ArrayList<Card> possibleCards = new ArrayList<Card>();
		
		try
		{
			Scanner cardReader = new Scanner(new File("src/card/txt/" + playerColor + ".txt"));
			
			String[] cardValues;
			
			while(cardReader.hasNext())
			{
				cardValues = cardReader.nextLine().split(",");
				
				possibleCards.add(new Card(playerColor, cardValues[0], new Integer(cardValues[1]), new Integer(cardValues[2]), 
						new Integer(cardValues[3]), new Integer(cardValues[4])));
			}
			
			cardReader.close();
			
			if(playerColor.equals("red"))
			{
				while(hand.getHandSize() < 5)
				{
					hand.addCard(possibleCards.remove(new Random(System.currentTimeMillis()).nextInt(possibleCards.size())));
				}
			}
			else
			{
				for(Card c : possibleCards)
				{
					hand.addCard(c);
				}
			}

			return hand;
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		
		return hand;
	}
}
