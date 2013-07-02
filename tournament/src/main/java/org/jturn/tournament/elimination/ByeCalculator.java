package org.jturn.tournament.elimination;

import static com.google.common.base.Preconditions.checkArgument;

class ByeCalculator {

	/**
	 * Determine the no of bye's needed.
	 * The number of participants in a single elimination tournament
	 * must be equal to the next power of two.
	 *
	 * @param numberOfPlayers number of participants in the tournament
	 * @return the numberOfPlayers rounded up to the nearest power of two
	 */
	static int noOfBye(int numberOfPlayers) {
		checkArgument(numberOfPlayers > 1, "Number of players must be greater that one");
		
		int counter = 2;
		while(counter < numberOfPlayers) {
			counter = counter * 2;
		}
		return counter - numberOfPlayers;
	}
}
