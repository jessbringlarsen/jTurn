package org.jturn.tournament.elimination.tree;

import java.util.ArrayList;
import java.util.Collection;

import org.jturn.model.Match;
import org.jturn.tournament.elimination.tree.traversal.EliminationTreeInOrderCommand;

public class EliminationTree {

	private EliminationTreeMatchNode root;

	public EliminationTree(EliminationTreeMatchNode root) {
		this.root = root;
	}
	
	public Collection<Match> getFirstRoundMatches() {
		Collection<Match> firstRoundNodes = new ArrayList<>();
		inOrder(root, firstRoundNodes, new EliminationTreeInOrderCommand() {
			
			@Override
			public boolean doCommand(EliminationTreeMatchNode node) {
				return node.getPreviousNodeA() == null && node.getPreviousNodeB() == null;
			}
		});
		return firstRoundNodes;
	}
	
	public Collection<Match> getNextMatches() {
		Collection<Match> matches = new ArrayList<>();
		inOrder(root, matches, new EliminationTreeInOrderCommand() {
			
			@Override
			public boolean doCommand(EliminationTreeMatchNode node) {
				return node.isReady();
			}
		});
		return matches;
		
	}
	
	public void proceed() {
		Collection<Match> matches = new ArrayList<>();
		inOrder(root, matches, new EliminationTreeInOrderCommand() {
			
			@Override
			public boolean doCommand(EliminationTreeMatchNode node) {
				if(node.getPreviousNodeA() != null && node.getPreviousNodeA().getMatch().isFinished()) {
					node.getMatch().setContestantA(node.getPreviousNodeA().getMatch().getWinner());
				}
				
				if(node.getPreviousNodeB() != null && node.getPreviousNodeB().getMatch().isFinished()) {
					node.getMatch().setContestantB(node.getPreviousNodeB().getMatch().getWinner());
				}
				return false;
			}
		});
	}
	
	public void inOrder(EliminationTreeMatchNode node, Collection<Match> matches, EliminationTreeInOrderCommand command) {
		if(node == null) {
			return;
		}
		
		inOrder(node.getPreviousNodeA(), matches, command);
		if(command.doCommand(node)) {
			matches.add(node.getMatch());
		}
		inOrder(node.getPreviousNodeB(), matches, command);
	}
}