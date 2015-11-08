/**
 * @author Donald Aufiero
 */

package algorithm;

import java.util.ArrayList;

import card.Card;
import card.Hand;
import game.GameBoard;

/**
 *	Represents the state of a game. New Nodes are created to represent future moves until the game is over.
 */
public class Node 
{
	private GameBoard board;
	private Hand      redHand;
	private Hand      blueHand;
	private int       row = -1;
	private int       col = -1;
	
	public Node(GameBoard board, Hand redHand, Hand blueHand)
	{
		this.board    = GameBoard.copy(board);
		this.redHand  = redHand.copy();
		this.blueHand = blueHand.copy();
	}
	
	public GameBoard getBoard()
	{
		return board;
	}
	
	public Hand getPlayerHand(boolean player)
	{
		if(player)
		{
			return blueHand;
		}
		else
		{
			return redHand;
		}
	}
	
	public ArrayList<Node> generateChildren(boolean player)
	{
		ArrayList<Node> children = new ArrayList<Node>();
		
		if(player)
		{
			for(int card = 0; card < blueHand.getHandSize(); card++)
			{
				
			}
		}
		else
		{
			
		}
		
		return children;
	}
}
