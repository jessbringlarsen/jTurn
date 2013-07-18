package org.jturn.tournament.elimination;

import java.util.ArrayDeque;
import java.util.Deque;

import org.jturn.tournament.elimination.tree.EliminationTree;
import org.jturn.tournament.elimination.tree.EliminationTreeMatchNode;

/**
 * Responsible for initializing the elimination tree with the 
 * correct number of nodes. 
 *
 */
class EliminationTreeInitializer {

	EliminationTree initialize(int numberOfPlayers) {
		int numberOfFirstRoundMatches = numberOfPlayers/2;
		
		Deque<EliminationTreeMatchNode> matches = new ArrayDeque<>();
		for(int i=0; i<numberOfFirstRoundMatches; i++) {
			matches.add(new EliminationTreeMatchNode());
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