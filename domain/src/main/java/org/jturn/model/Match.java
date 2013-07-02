/*
 * Created on 14-07-2004
 */
package org.jturn.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent a match. Two contestants, court and winner. Also collects
 * the result of the match (set score etc.)
 *
 * @author jebl
 */

public class Match extends EntityObject {

	private final int matchNo;
	private final CategoryParticipant contestantA;
	private final CategoryParticipant contestantB;
	private final Map<Integer, MatchResult> matchResults;

	public Match(int matchNo, CategoryParticipant contestantA, CategoryParticipant contestantB) {
		this.matchNo = matchNo;
		this.contestantA = contestantA;
		this.contestantB = contestantB;
		this.matchResults = new HashMap<>();
	}

	/**
	 * @param resultNo resultNo indicate the sequenze number of the result
	 * @param result
	 */
	public void addResult(Integer resultNo, MatchResult result) {
		this.matchResults.put(resultNo, result);
	}

	public void clearResults() {
		this.matchResults.clear();
	}

	/**
	 * @return Returns the matchNo.
	 */
	public int getMatchNo() {
		return matchNo;
	}

	/**
	 * @return Returns the contestantA.
	 */
	public CategoryParticipant getContestantA() {
		return contestantA;
	}

	/**
	 * @return Returns the contestantB.
	 */
	public CategoryParticipant getContestantB() {
		return contestantB;
	}
	
	public Map<Integer, MatchResult> getMatchResults() {
		return matchResults;
	}
	
	@Override
	public String toString() {
		String ret = "Match no: " + this.matchNo;
		ret += "\nA: " + this.contestantA + "B: " + this.contestantB;
		return ret;
	}

}