package card;

public class Card
{
	private final static String  imageRoot = "/src/card/img";
	private String  cardName;
	private Integer topRank;
	private Integer rightRank;
	private Integer bottomRank;
	private Integer leftRank;
	private String  controller;
	
	public Card(String controller, String cardName, int topRank, int rightRank, int bottomRank, int leftRank)
	{
		this.cardName   = cardName;
		this.topRank    = new Integer(topRank);
		this.rightRank  = new Integer(rightRank);
		this.bottomRank = new Integer(bottomRank);
		this.leftRank   = new Integer(leftRank);
		this.controller = controller;
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
	
	public String getImagePath()
	{
		return imageRoot + "/" + controller + "/" + cardName + ".png";
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
	
	public void flip()
	{
		if(controller.equals("red"))
		{
			controller = "blue";
		}
		else
		{
			controller = "red";
		}
	}
}