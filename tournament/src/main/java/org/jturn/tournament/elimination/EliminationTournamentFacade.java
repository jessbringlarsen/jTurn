package org.jturn.tournament.elimination;

import java.util.Collection;

import org.jturn.model.Match;
import org.jturn.tournament.elimination.tree.EliminationTree;

public class EliminationTournamentFacade {

	private EliminationTree tree;
	
	public void initialize(int numberOfPlayers) {
		EliminationTreeInitializer treeInitializer = new EliminationTreeInitializer();
		//tree = treeInitializer.initialize(numberOfPlayers);
	}
	
	public Collection<Match> getNextMatches() {
		return tree.getNextMatches();
	}
}