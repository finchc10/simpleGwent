package game;

import card.Card;

public class GameBoard
{
	Card[][] board;
	
	public GameBoard()
	{
		board = new Card[3][3];
	}
	
	public Card getNeighbor(Integer row, Integer col, Character direction)
	{
		Card neighbor = null;
		
		try
		{
			switch(direction)
			{
			    case 't': return getCardAt(row - 1, col);
			    case 'r': return getCardAt(row, col + 1);
			    case 'b': return getCardAt(row + 1, col);
			    case 'l': return getCardAt(row, col - 1);
			}
		}
		catch(IndexOutOfBoundsException e)
		{
		}
		
		return neighbor;
	}
	
	public Card getCardAt(Integer row, Integer col) throws IndexOutOfBoundsException
	{
		return board[row][col];
	}
}
