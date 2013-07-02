package org.jturn.tournament.seed;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;

/**
 * Implementation of Algorithm 3.8 as described in the book:
 * Algorithms and Networking for Computer Games by Jouni Smed and Harri Hakonen
 * <p>
 * Contains methods to order of list of players by rank for the first round of a
 * elimination tournament.
 *
 * @author jbl
 *
 */
final class Elimination {

	private int numberOfPlayers;
	
	Elimination(int numberOfPlayers) { 
		checkArgument(numberOfPlayers > 1, "Number of players must be greater that one");
		checkArgument(noOfBye(numberOfPlayers) == 0, "Number of players must be 2, 4, 8, 16, 32...");
		
		this.numberOfPlayers = numberOfPlayers;
	}
	
	private int noOfBye(int numberOfPlayers) {
		int counter = 2;
		while(counter < numberOfPlayers) {
			counter = counter * 2;
		}
		return counter - numberOfPlayers;
	}
	
	/**
	 * This method orders an array where the elements corresponds
	 * to the match paring of the first round of a single elimination
	 * tournament.
	 * <p>
	 * E.g. by supplying the input of 16 the return value would be an zero based
	 * array containing match parings for the first round of the tournament: <br />
	 * [0, 15, 8, 7, 4, 11, 12, 3, 2, 13, 10, 5, 6, 9, 14, 1]</p>
	 * 
	 * @param numberOfPlayers number of players in the tournament. This number must be a power of 2
	 * @return a zero based array where the numbers are ordered
	 * according to the first round matches of the single elimination
	 * tournament
	 *
	 */	
	int[] ranks() {
		int[] ranks = new int[numberOfPlayers];
		Arrays.fill(ranks, -1);
		ranks[0] = 0;

		return rankInternal(ranks, 2, 0, numberOfPlayers-1);
	}

	private int[] rankInternal(int[] ranks, int playersPrRound, int playerA, int playerB) {
		if(playerA == playerB) {
			return ranks;
		}

		if(ranks[playerA] == -1) {
			ranks[playerA] = (playersPrRound-1)-ranks[playerB];
		} else {
			ranks[playerB] = (playersPrRound-1)-ranks[playerA];
		}

		int tmp = (playerB-playerA-1)/2;
		ranks = rankInternal(ranks, 2*playersPrRound, playerA, playerA+tmp);
		ranks = rankInternal(ranks, 2*playersPrRound, playerA+tmp+1, playerB);
		return ranks;
	}
}