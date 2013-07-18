package org.jturn.tournament.elimination;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.jturn.model.Match;
import org.jturn.tournament.elimination.tree.EliminationTree;
import org.jturn.tournament.elimination.tree.EliminationTreeMatchNode;

/**
 * Responsible for initializing the elimination tree with the 
 * correct number of nodes. 
 *
 */
class EliminationTreeInitializer {

	EliminationTree initialize(List<Match> firstRoundMatches) {
		
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