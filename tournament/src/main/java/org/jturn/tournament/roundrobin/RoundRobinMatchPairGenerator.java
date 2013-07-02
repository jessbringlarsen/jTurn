package org.jturn.tournament.roundrobin;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.LinkedList;

import org.jturn.util.Pair;

/**
 * Responsible for for constructing pairs of matches to be played in a roundrobin tournament.
 * <p> 
 * 
 * @author jbl
 *
 */
class RoundRobinMatchPairGenerator {

	private int roundNumber;
	private int numberOfPlayers;
	private LinkedList<Integer> firstRow;
	private LinkedList<Integer> secondRow; 
	     
	RoundRobinMatchPairGenerator(int numberOfPlayers) {
		checkArgument(numberOfPlayers > 0, "argument must be greater that zero");
		checkArgument(numberOfPlayers%2 == 0, "argument must be an even number");
		
		this.roundNumber = 1;
		this.numberOfPlayers = numberOfPlayers;
		this.firstRow = new LinkedList<Integer>();
		this.secondRow = new LinkedList<Integer>();
		
		initializeRows();
	}
	
	private void initializeRows() {
		for(int i=0; i<numberOfPlayers/2; i++) {
			firstRow.add(Integer.valueOf(i));
		}
		
		for(int i=numberOfPlayers-1; i>=numberOfPlayers/2; i--) {
			secondRow.add(Integer.valueOf(i));
		}
	}
	
	/**
	 * The generation is complete when the last element is
	 * back on the starting position. 
	 * 
	 * @return true if there is more rounds to be played
	 */
	boolean hasMoreRounds() {
		if(!isFirstRound() && isLastElementBackOnStartPosition()) {
			return false;
		}
		return true;
	}
	
	ArrayList<Pair<Integer, Integer>> nextRound() {
		ArrayList<Pair<Integer, Integer>> result = new ArrayList<Pair<Integer,Integer>>();
		
		for(int i=0; i<numberOfPlayers/2; i++) {
			result.add(new Pair<Integer, Integer>(firstRow.get(i)+1, secondRow.get(i)+1));
		}
		shiftArrays();
		roundNumber++;
		return result;
	}

	private void shiftArrays() {
		firstRow.add(1, secondRow.removeFirst());
		secondRow.addLast(firstRow.removeLast());
	}
	
	private boolean isFirstRound() {
		return roundNumber == 1;
	}
	
	private boolean isLastElementBackOnStartPosition() {
		return Integer.valueOf(numberOfPlayers-1).equals(secondRow.peek());
	}
}
