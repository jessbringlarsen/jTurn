package org.jturn.tournament.elimination;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.jturn.model.Match;
import org.jturn.tournament.elimination.tree.EliminationTree;
import org.jturn.tournament.elimination.tree.EliminationTreeMatchNode;

import com.google.common.base.Preconditions;

/**
 * Responsible for initializing the elimination tree with the 
 * correct number of nodes. 
 *
 */
public class EliminationTreeInitializer {

	public EliminationTree initialize(List<Match> firstRoundMatches) {
		Preconditions.checkArgument(firstRoundMatches != null, "Argument must be non null!");
		Preconditions.checkArgument(firstRoundMatches.size() > 0, "Argument must contain at least one match!");
		
		Deque<EliminationTreeMatchNode> matches = new ArrayDeque<>();
		for(Match match : firstRoundMatches) {
			matches.add(new EliminationTreeMatchNode(match));
		}
		Deque<EliminationTreeMatchNode> root = buildNextRound(matches);
		return new EliminationTree(root.poll());
	}
	
	private Deque<EliminationTreeMatchNode> buildNextRound(Deque<EliminationTreeMatchNode> matchNodes) {
		if(matchNodes.size() < 2) {
			return matchNodes;
		}
		Deque<EliminationTreeMatchNode> nextRoundMatches = new ArrayDeque<>();
		while(!matchNodes.isEmpty()) {
			nextRoundMatches.add(new EliminationTreeMatchNode(matchNodes.pop(), matchNodes.pop()));
		}
		return buildNextRound(nextRoundMatches);
	}
}