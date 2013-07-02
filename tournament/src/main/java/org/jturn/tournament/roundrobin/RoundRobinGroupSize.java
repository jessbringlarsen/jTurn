package org.jturn.tournament.roundrobin;

/**
 * Provide methods to calculate group sizes in round robin tournaments.
 * <p>
 * It is assumed that the number of players is known and the size of the primary groups.
 * 
 * @author jbl
 *
 */
public class RoundRobinGroupSize {

	/**
	 * Method to calculate the possible total number of groups with the specified size.<br />
	 * E.g. if the specified total number of players is 16 and groupSize chosen is 5 the 
	 * return value will 2, because 2*5 is 10. 
	 * 
	 * @param noOfPlayers number of players of the tournament
	 * @param groupSize group size wanted
	 * @return the total possible number of groups with the specified size
	 */
	public int getPrimaryGroups(int noOfPlayers, int groupSize) {
		if(noOfPlayers%groupSize == 0) {
		 	return noOfPlayers/groupSize;
		} else {
			int x = noOfPlayers - groupSize;
			return (int)Math.floor(x/groupSize);
		}
	}
	
	/**
	 * Return the size of a possible secondary group of the tournament.<br />
	 * E.g. if the total number of players is 16 and the primary group size wanted is 
	 * 4 <code>getSecondaryGroupSize</code> will return 5 because there will be a total of
	 * 3 x 4 + 1 x 5 group in the tournament.
	 * 
	 * @param noOfPlayers number of players of the tournament
	 * @param primaryGroupSize the primary group size wanted for the tournament
	 * @return the secondary group size
	 */
	public int getSecondaryGroup(int noOfPlayers, int primaryGroupSize) {
		if(noOfPlayers%primaryGroupSize == 0) {
		 	return 0;
		} else {
			int noOfGroupWithPrimarySize = getPrimaryGroups(noOfPlayers, primaryGroupSize);
			int secondaryGroupSize = noOfPlayers - noOfGroupWithPrimarySize*primaryGroupSize;
			return secondaryGroupSize;
		}
	}
}