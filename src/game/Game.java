/**
 * @author Cory Finch
 */

package game;

import java.util.ArrayList;

import card.Card;
import card.CardReader;
import card.Hand;

/**
 * Manages the flow of the game. Determines which player goes first, then maintains the turn order until the game is over.
 */
public class Game 
{
	private GameBoard board;
	private Hand     red;
	private Hand     blue;
	private Boolean  whoseTurn;
	
	public Game()
	{
		board      = new GameBoard();
		red        = CardReader.readHand("red");
		blue       = CardReader.readHand("blue");
		whoseTurn  = new java.util.Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE) % 2 == 0;
	}
	
	public Game(GameBoard board, Hand redHand, Hand blueHand, boolean playersTurn)
	{
		this.board = GameBoard.copy(board);
		red        = redHand.copy();
		blue       = blueHand.copy();
		whoseTurn  = playersTurn;
	}
	
	public void play()
	{
		if(whoseTurn)
		{
			while(!gameIsOver())
			{
				whoseTurn = false;
				//red plays card
				whoseTurn = true;
				//blue plays card
			}
		}
		else
		{
			while(!gameIsOver())
			{
				whoseTurn = true;
			    //blue plays card
				whoseTurn = false;
				//red plays card
			}
		}
	}
	
	public void playCard(boolean player, int card, int row, int col)
	{
		//blue
		if(player)
		{
			board.putCard(row, col, blue.playCard(card));
		}
		else
		{
			board.putCard(row, col, red.playCard(card));
		}
	}
	
	public GameBoard getBoard()
	{
		return board;
	}
	
	public Game copy()
	{
		return new Game(this.board, this.red, this.blue, whoseTurn);
	}
	
	public boolean getWhoseTurn()
	{
		boolean currTurn = whoseTurn;
		
		whoseTurn = !whoseTurn;
		
		return currTurn;
	}
	
	public ArrayList<Game> generateChildren(boolean color)
	{
		ArrayList<Game> children = new ArrayList<Game>();
		Hand playersHand         = getPlayersHand(color);
		
		for(int card = 0; card < playersHand.getHandSize(); card++)
		{
			if(playersHand.getCard(card) != null)
			{
				for(int row = 0; row < 3; row++)
				{
					for(int col = 0; col < 3; col++)
					{
						if(board.canPlaceCard(row, col))
						{
							Game childGame = this.copy();
							childGame.playCard(color, card, row, col);
							children.add(childGame);
						}
					}
				}
			}
		}
		
		return children;
	}
	
	private Hand getPlayersHand(boolean color)
	{
		if(color)
		{
			return blue.copy();
		}
		else
		{
			return red.copy();
		}
	}
	
	public boolean gameIsOver()
	{
		return board.openSpaces() == 0;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		if(whoseTurn)
		{
			sb.append("*");
		}
		
		sb.append("Blue's Hand: ");
		sb.append(blue.toString());
		sb.append("\n");
		
		if(!whoseTurn)
		{
			sb.append("*");
		}
		
		sb.append("Red's Hand: ");
		sb.append(red.toString());
		sb.append("\n");
		
		sb.append("Board: " );
		sb.append(board.toString());
		
		return sb.toString();
	}
}