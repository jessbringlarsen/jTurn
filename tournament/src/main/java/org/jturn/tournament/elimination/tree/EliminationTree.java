package org.jturn.tournament.elimination.tree;

import java.util.ArrayList;
import java.util.Collection;

import org.jturn.model.Match;
import org.jturn.model.MatchResult;

public class EliminationTree {

	private EliminationTreeMatchNode root;

	public EliminationTree(EliminationTreeMatchNode root) {
		this.root = root;
	}
	
	void addResult(Integer matchNo, MatchResult result) {
		
	}
	
	public int getNumberOfFirstRoundMatches() {
		Collection<EliminationTreeMatchNode> firstRoundNodes = new ArrayList<>();
		inOrder(root, firstRoundNodes);
		return firstRoundNodes.size();
	}
	
	public void inOrder(EliminationTreeMatchNode node, Collection<EliminationTreeMatchNode> firstRoundNodes) {
		if(node == null) {
			return;
		}
		
		inOrder(node.getPreviousNodeA(), firstRoundNodes);
		if(node.getPreviousNodeA() == null && node.getPreviousNodeB() == null) {
			firstRoundNodes.add(node);
		}
		inOrder(node.getPreviousNodeB(), firstRoundNodes);
	}
	
	public Collection<Match> getNextMatches() {
		Collection<Match> matches = new ArrayList<>();
		inOrderNextMatches(root, matches);
		return matches;
		
	}
	
	public void inOrderNextMatches(EliminationTreeMatchNode node, Collection<Match> matches) {
		if(node == null) {
			return;
		}
		
		inOrderNextMatches(node.getPreviousNodeA(), matches);
		if(node.isReady()) {
			matches.add(node.getMatch());
		}
		inOrderNextMatches(node.getPreviousNodeB(), matches);
	}
}