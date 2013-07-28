package org.jturn.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represent a match.
 *
 * @author jebl
 */

public class Match extends EntityObject {

	private ContestantInterface contestantA;
	private ContestantInterface contestantB;
	private List<MatchResultInterface> matchResults;

	public Match() {
		this(null, null);
	}
	
	public Match(ContestantInterface contestantA, ContestantInterface contestantB) {
		this.contestantA = contestantA;
		this.contestantB = contestantB;
		this.matchResults = Collections.emptyList();
	}

	public ContestantInterface getWinner() {
		if(contestantA.isBye()) {
			return contestantB;
		} else if(contestantB.isBye()) {
			return contestantA;
		}
		
		int resultA = 0;
		int resultB = 0;
		for(MatchResultInterface result : matchResults) {
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
	
	public ContestantInterface getLooser() {
		if(getWinner().equals(contestantA)) {
			return contestantB;
		}
		return contestantA;
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
	public void addResult(List<MatchResultInterface> results) {
		matchResults = new ArrayList<>(results);
	}

	public void clearResults() {
		matchResults.clear();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Match [contestantA=").append(contestantA)
				.append(", contestantB=").append(contestantB)
				.append(", matchResults=").append(matchResults).append("]");
		return builder.toString();
	}
	
	
}