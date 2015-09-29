package card;

import java.io.IOException;

public abstract class Card 
{
	private String cardName;
	private String imagePath;
	
	public Card(String cardName, String imagePath) throws IOException
	{
		this.cardName  = cardName;
		this.imagePath = imagePath;
	}
	
	public String getCardName()
	{
		return cardName;
	}
	
	public String getImagePath()
	{
		return imagePath;
	}
}