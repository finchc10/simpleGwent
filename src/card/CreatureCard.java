package card;

import java.io.IOException;

public class CreatureCard extends Card 
{
	private Integer value;
	
	public CreatureCard(String cardName, String cardPath, Integer value) throws IOException
	{
		super(cardName, cardPath);
		this.value = value;
	}
	
	public Integer getValue()
	{
		return value;
	}
}