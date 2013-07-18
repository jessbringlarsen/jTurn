package org.jturn.tournament.elimination;

import java.util.Collection;
import java.util.List;

import org.jturn.model.Match;
import org.jturn.model.MatchResult;
import org.jturn.tournament.elimination.tree.EliminationTree;

/**
 * Responsible for providing methods for retrieving the next matches 
 * that is to be played and provide methods for registering results.
 * 
 * @author jbl
 *
 */
public class EliminationTournamentFacade {

	private EliminationTree tree;
	
	public void initialize(int numberOfPlayers) {
		EliminationTreeInitializer treeInitializer = new EliminationTreeInitializer();
		tree = treeInitializer.initialize(numberOfPlayers);
	}
	
	public Collection<Match> getNextMatches() {
		return tree.getNextMatches();
	}
	
	public void addResult(Integer matchNo, List<MatchResult> matchResult) {
		
	}
}