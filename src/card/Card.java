/**
 * @author Donald Aufiero
 */
package card;

/**
 * Represents a card used to play the game Triple Triad.
 * Each cardinal direction (top, right, bottom, left) as a number associated with it, known as it's rank.
 * When a card is played, the ranks of all neighboring opposing cards are compared. If the played card has
 * a higher rank than any of the neighboring cards, they are flipped under that player's control.
 */
public class Card
{
	private final static String  imageRoot = "/src/card/img";
	private String  cardName;
	private Integer topRank;
	private Integer rightRank;
	private Integer bottomRank;
	private Integer leftRank;
	private boolean  controller;
	
	public Card(boolean controller, String cardName, int topRank, int rightRank, int bottomRank, int leftRank)
	{
		this.cardName   = cardName;
		this.topRank    = new Integer(topRank);
		this.rightRank  = new Integer(rightRank);
		this.bottomRank = new Integer(bottomRank);
		this.leftRank   = new Integer(leftRank);
		this.controller = controller;
	}
	
	public Integer getDirectionRank(Character direction)
	{
		Integer rank = 0;
		
		switch(direction)
		{
		    case 'b': rank = this.bottomRank; break;
		    case 'l': rank = this.leftRank  ; break;
		    case 't': rank = this.topRank   ; break;
		    case 'r': rank = this.rightRank ; break;
		}
		
		return rank;
	}
	
	public String getImagePath()
	{
		return imageRoot + "/" + controller + "/" + cardName + ".png";
	}
	
	public String toString()
	{
		StringBuilder stringer = new StringBuilder();
		
		stringer.append(cardName);
		stringer.append(" ");
		
		if(controller)
		{
			stringer.append("[B]");
		}
		else
		{
			stringer.append("[R]");
		}
		
		stringer.append(": ");
		stringer.append("{t: ");
		stringer.append(topRank);
		stringer.append(", r: ");
		stringer.append(rightRank);
		stringer.append(", b: ");
		stringer.append(bottomRank);
		stringer.append(", l: ");
		stringer.append(leftRank);
		stringer.append("}");
		
		return stringer.toString();
	}
	
	public boolean getController()
	{
		return controller;
	}
	
	public void flip()
	{
		if(controller)
		{
			controller = false;
		}
		else
		{
			controller = true;
		}
	}
	
	public Card copy()
	{
		return new Card(controller, cardName, bottomRank, bottomRank, bottomRank, bottomRank);
	}
}