package org.jturn.tournament.elimination.tree;

import org.jturn.model.Match;

public class EliminationTreeMatchNode {
	
	private final EliminationTreeMatchNode previousNodeA;
	private final EliminationTreeMatchNode previousNodeB;
	
	private Match match;

	public EliminationTreeMatchNode(Match match) {
		this(null, null, match);
	}
	
	public EliminationTreeMatchNode(EliminationTreeMatchNode previousNodeA, EliminationTreeMatchNode previousNodeB) {
		this(previousNodeA, previousNodeB, new Match());
	}
	
	public EliminationTreeMatchNode(EliminationTreeMatchNode previousNodeA,
			EliminationTreeMatchNode previousNodeB, Match match) {
		this.previousNodeA = previousNodeA;
		this.previousNodeB = previousNodeB;
		this.match = match;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}
	
	public Match getMatch() {
		return match;
	}

	public boolean isReady() {
		return match != null && !match.isFinished() && match.isReady();
	}
	
	public EliminationTreeMatchNode getPreviousNodeA() {
		return previousNodeA;
	}

	public EliminationTreeMatchNode getPreviousNodeB() {
		return previousNodeB;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EliminationTreeMatchNode [previousNodeA=")
				.append(previousNodeA).append(", previousNodeB=")
				.append(previousNodeB).append(", match=").append(match)
				.append("]");
		return builder.toString();
	}
	
	
}