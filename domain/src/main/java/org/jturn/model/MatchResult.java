/*
 * Created on 14-07-2004
 */
package org.jturn.model;


/**
 * Represent a match result. Either match score (eg. 3-0) or set score
 * (eg. 11-7).
 */

public class MatchResult extends EntityObject {

	private final int resultA;
	private final int resultB;

	/**
	 * Register multiple results in a single match. E.g. 11-4, 11-7, ...
	 *
	 * @param resultA
	 * @param resultB
	 */
	public MatchResult(int resultNo, int resultA, int resultB) {
		this.resultA = resultA;
		this.resultB = resultB;
	}
	
	public int getResultA() {
		return resultA;
	}

	public int getResultB() {
		return resultB;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MatchResult [resultA=").append(resultA)
				.append(", resultB=").append(resultB).append("]");
		return builder.toString();
	}
}