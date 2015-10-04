package card;

public abstract class Card 
{
	String  cardName;
	Integer topRank;
	Integer rightRank;
	Integer bottomRank;
	Integer leftRank;
	String  imagePath;
	
	public Card(String cardName, String imagePath, int topRank, int rightRank, int bottomRank, int leftRank)
	{
		this.cardName   = cardName;
		this.imagePath  = imagePath;
		this.topRank    = new Integer(topRank);
		this.rightRank  = new Integer(rightRank);
		this.bottomRank = new Integer(bottomRank);
		this.leftRank   = new Integer(leftRank);
	}
	
	public Integer getOpposingRank(Character direction)
	{
		Integer rank = 0;
		
		switch(direction)
		{
		    case 't': rank = this.bottomRank; break;
		    case 'r': rank = this.leftRank  ; break;
		    case 'b': rank = this.topRank   ; break;
		    case 'l': rank = this.rightRank ; break;
		}
		
		return rank;
	}
	
	public String toString()
	{
		StringBuilder stringer = new StringBuilder();
		
		stringer.append(cardName);
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
}