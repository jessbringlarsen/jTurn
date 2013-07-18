package org.jturn.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a match.
 *
 * @author jebl
 */

public class Match extends EntityObject {

	private final int matchNo;
	private ContestantInterface contestantA;
	private ContestantInterface contestantB;
	private List<MatchResult> matchResults;

	public Match(int matchNo) {
		this.matchNo = matchNo;
	}
	
	public Match(int matchNo, ContestantInterface contestantA, ContestantInterface contestantB) {
		this(matchNo);
		this.contestantA = contestantA;
		this.contestantB = contestantB;
	}

	public ContestantInterface getWinner() {
		if(isFinished()) {
			int resultA = 0;
			int resultB = 0;
			for(MatchResult result : matchResults) {
				if(result.getResultA() > result.getResultB()) {
					resultA++;
				} else {
					resultB++;
				}
			}
			if(resultA > resultB) {
				return contestantA;
			} else {
				return contestantB;
			}
		}
		return null;
	}
	
	public void setContestantA(ContestantInterface contestantA) {
		this.contestantA = contestantA;
	}

	public void setContestantB(ContestantInterface contestantB) {
		this.contestantB = contestantB;
	}

	public boolean isFinished() {
		return !matchResults.isEmpty();
	}
	
	public boolean isReady() {
		return contestantA != null && contestantB != null;
	}
	
	/**
	 * @param resultNo indicate the sequence number of the result
	 * @param result
	 */
	public void addResult(List<MatchResult> results) {
		matchResults = new ArrayList<>(results);
	}

	public void clearResults() {
		matchResults.clear();
	}

	/**
	 * @return Returns the matchNo.
	 */
	public int getMatchNo() {
		return matchNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Match [matchNo=").append(matchNo)
				.append(", contestantA=").append(contestantA)
				.append(", contestantB=").append(contestantB)
				.append(", matchResults=").append(matchResults).append("]");
		return builder.toString();
	}
	
	
}