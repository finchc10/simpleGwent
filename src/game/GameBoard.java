/**
 * @author Cory Finch
 */

package game;

import card.Card;

/**
 * Data structure that stores the position of the cards that have been played.
 */
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
			//no neighbor
		}
		
		return neighbor;
	}
	
	public Boolean putCard(Integer row, Integer col, Card c)
	{
		Boolean placed = false;
		
		if(board[row][col] == null)
		{
			board[row][col] = c;
			flipCards(row, col, c);
			placed = true;
		}
		
		return placed;
	}
	
	public boolean canPlaceCard(int row, int col)
	{
		return board[row][col] == null;
	}
	
	private void flipCards(int row, int col, Card cardPlayed)
	{
		Card topNeighbor   = getNeighbor(row, col, 't');
		Card rightNeighbor = getNeighbor(row, col, 'r');
		Card botNeighbor   = getNeighbor(row, col, 'b');
		Card leftNeighbor  = getNeighbor(row, col, 'l');
		
		if(topNeighbor != null)
		{
			if(topNeighbor.getDirectionRank('b') < cardPlayed.getDirectionRank('t'))
			{
				topNeighbor.flip();
			}
		}
		
		if(rightNeighbor != null)
		{
			if(rightNeighbor.getDirectionRank('l') < cardPlayed.getDirectionRank('r'))
			{
				rightNeighbor.flip();
			}
		}
		
		if(botNeighbor != null)
		{
			if(botNeighbor.getDirectionRank('t') < cardPlayed.getDirectionRank('b'))
			{
				botNeighbor.flip();
			}
		}
		
		if(leftNeighbor != null)
		{
			if(leftNeighbor.getDirectionRank('r') < cardPlayed.getDirectionRank('l'))
			{
				leftNeighbor.flip();
			}
		}
	}
	
	public static GameBoard copy(GameBoard original)
	{
		GameBoard board = new GameBoard();
		
		for(int col = 0; col < 3; col++)
		{
			for(int row = 0; row < 3; row++)
			{
				board.copyTo(row, col, original.getCardAt(row, col));
			}
		}
		
		return board;
	}
	
	public Card getCardAt(Integer row, Integer col) throws IndexOutOfBoundsException
	{
		return board[row][col];
	}
	
	public int openSpaces()
	{
		int openSpaces = 0;
				
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				if(board[row][col] == null)
				{
					openSpaces++;
				}
			}
		}
		
		return openSpaces;
	}
		
	public int heuristicValue()
	{
		int heuristicValue    =  0;
		int blueCards         = cardsOwnedBy(true);
		int redCards          = cardsOwnedBy(false);
		
		if(openSpaces() == 0)
		{
			int lossScore = -10;
			int winScore  =  10;
			int drawScore = -5;
			
			if(blueCards == redCards)
			{
				heuristicValue = drawScore;
			}
			else if(redCards > blueCards)
			{
				heuristicValue = winScore;
			}
			else
			{
				heuristicValue = lossScore;
			}
		}
		else
		{
			heuristicValue = redCards - blueCards;
		}
		
		return heuristicValue;
	}
	
	public void copyTo(int row, int col, Card cardToCopy)
	{
		board[row][col] = cardToCopy;
	}
	
	private int cardsOwnedBy(boolean player)
	{
		int cardCount = 0;
		
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				if(board[row][col] != null)
				{
					if(board[row][col].getController() == player)
					{
						cardCount++;
					}
				}
			}
		}
		
		return cardCount;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		int spot = 1;
		
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				sb.append(spot);
				sb.append(": ");
				
				Card c = this.getCardAt(row, col);
				spot++;
				
				if(c == null)
				{
					sb.append("[EMPTY]");
				}
				else
				{
					sb.append(c.toString());
				}
				
				if(col + 1 < 3)
				{
					sb.append(", ");
				}
			}
			
			if(row + 1 < 3)
			{
				sb.append(", ");
			}
		}
		
		return sb.toString();
	}
}
