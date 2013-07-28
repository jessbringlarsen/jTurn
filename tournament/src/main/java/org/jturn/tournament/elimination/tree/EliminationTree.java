package org.jturn.tournament.elimination.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jturn.model.ContestantInterface;
import org.jturn.model.Match;
import org.jturn.tournament.elimination.tree.traversal.EliminationTreeInOrderCommand;

import com.google.common.collect.TreeMultimap;

public class EliminationTree {

	private EliminationTreeMatchNode root;

	public EliminationTree(EliminationTreeMatchNode root) {
		this.root = root;
	}
	
	public Map<Integer, Collection<ContestantInterface>> getResult() {
		Collection<Match> firstRoundNodes = new ArrayList<>();
		EliminationTreeInOrderResultCommand eliminationTreeInOrderResultCommand = new EliminationTreeInOrderResultCommand();
		inOrder(root, firstRoundNodes, eliminationTreeInOrderResultCommand);
		
		Map<ContestantInterface, Integer> matchWins = eliminationTreeInOrderResultCommand.getMatchWins();
		
		TreeMultimap<Integer, ContestantInterface> result = TreeMultimap.create(
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			}, new Comparator<ContestantInterface>() {
					
				@Override
				public int compare(ContestantInterface o1, ContestantInterface o2) {
					return Integer.valueOf(o1.getSeed()).compareTo(Integer.valueOf(o2.getSeed()));
				}
		});
		
		for(Entry<ContestantInterface, Integer> entry : matchWins.entrySet()) {
			result.put(entry.getValue(), entry.getKey());
		}
		
		return result.asMap();
	}
	
	private class EliminationTreeInOrderResultCommand implements EliminationTreeInOrderCommand {

		private final Map<ContestantInterface, Integer> matchWins = new HashMap<>();
		
		@Override
		public boolean doCommand(EliminationTreeMatchNode node) {
			if(node.getMatch().isFinished()) {
				ContestantInterface winner = node.getMatch().getWinner();
				if(matchWins.containsKey(winner)) {
					int wins = matchWins.get(winner).intValue()+1;
					matchWins.put(winner, Integer.valueOf(wins));
				} else {
					matchWins.put(winner, Integer.valueOf(1));
				}
				
				ContestantInterface looser = node.getMatch().getLooser();
				if(!matchWins.containsKey(looser)) {
					matchWins.put(looser, Integer.valueOf(0));
				}
			}
			return false;
		}

		public Map<ContestantInterface, Integer> getMatchWins() {
			return matchWins;
		}
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