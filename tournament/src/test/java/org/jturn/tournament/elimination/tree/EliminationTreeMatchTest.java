package org.jturn.tournament.elimination.tree;

import java.util.Arrays;
import java.util.Collections;

import org.jturn.model.Match;
import org.jturn.model.MatchResult;
import org.jturn.model.MatchResultInterface;
import org.jturn.model.SingleContestant;
import org.jturn.tournament.elimination.EliminationTreeInitializer;
import org.junit.Assert;
import org.junit.Test;

public class EliminationTreeMatchTest {

	@Test
	public void hasOneMatch() {
		Match finalie = new Match( 
				new SingleContestant(1, "Jess", "Bring-Larsen"),
				new SingleContestant(2, "Ole", "Hansen"));
		EliminationTreeInitializer initializer = new EliminationTreeInitializer();
		EliminationTree tree = initializer.initialize(Collections.singletonList(finalie));
		
		Assert.assertEquals(1, tree.getFirstRoundMatches().size());
		
		finalie.addResult(Collections.<MatchResultInterface>singletonList(new MatchResult(1, 3, 0)));
		tree.proceed();
		Assert.assertEquals(0, tree.getNextMatches().size());
	}
	
	@Test
	public void hasTwoMatch() {
		Match m1 = new Match( 
				new SingleContestant(1, "Jess", "Bring-Larsen"),
				new SingleContestant(4, "Ole", "Hansen"));
		
		Match m2 = new Match( 
				new SingleContestant(3, "Per", "Olsen"),
				new SingleContestant(2, "Tjele", "Jansen"));
		EliminationTreeInitializer initializer = new EliminationTreeInitializer();
		EliminationTree tree = initializer.initialize(Arrays.asList(m1, m2));
		
		Assert.assertEquals(2, tree.getFirstRoundMatches().size());
		
		m1.addResult(Collections.<MatchResultInterface>singletonList(new MatchResult(1, 3, 0)));
		m2.addResult(Collections.<MatchResultInterface>singletonList(new MatchResult(1, 3, 0)));
		tree.proceed();
		Assert.assertEquals(1, tree.getNextMatches().size());
	}
}
