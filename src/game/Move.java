package game;

import card.Card;

public class Move 
{
	private Card cardToPlay;
	private int  row;
	private int  col;
	private int  score;
	
	public Move(Card card, int row, int col, int score)
	{
		cardToPlay = card;
		this.row   = row;
		this.col   = col;
		this.score = score;
	}
	
	public Card getCard()
	{
		return cardToPlay;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getScore()
	{
		return score;
	}
}
