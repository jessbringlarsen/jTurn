package org.jturn.tournament.elimination;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jturn.model.Match;
import org.jturn.model.MatchResult;
import org.jturn.model.SingleContestant;
import org.jturn.tournament.elimination.tree.EliminationTree;
import org.junit.Assert;
import org.junit.Test;

public class EliminationTreeInitializerTest {

	@Test
	public void testCorrectNumberOfFirstroundMatchesIsGenerated() {
		for(int i=2; i<=256; i=i+i) {
			EliminationTreeInitializer eliminationTreeInitializer = new EliminationTreeInitializer();
			EliminationTree tree = eliminationTreeInitializer.initialize(getMatches(i));
			
			Assert.assertThat(tree.getFirstRoundMatches().size(), is(i));
		}
	}
	
	@Test
	public void testNextMatches() {
		EliminationTreeInitializer eliminationTreeInitializer = new EliminationTreeInitializer();
		EliminationTree tree = eliminationTreeInitializer.initialize(getMatches(2));

		List<Match> matches = new ArrayList<>(tree.getFirstRoundMatches());
		for(Match match : matches) {
			match.addResult(Collections.singletonList(new MatchResult(1, 1, 0)));
		}
		tree.proceed();
		Assert.assertThat(tree.getNextMatches().size(), is(1));
	}
	
	private List<Match> getMatches(int numberOfMatches) {
		List<Match> result = new ArrayList<>(numberOfMatches);
		
		int seed=1;
		for(int i=0; i<numberOfMatches; i++) {
			Match match = new Match();
			match.setContestantA(new SingleContestant(seed, "playerA-" + seed++, ""));
			match.setContestantB(new SingleContestant(seed, "playerB-" + seed, ""));
			result.add(match);
		}
		return result;
	}
}