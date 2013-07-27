package org.jturn.tournament.elimination.tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.jturn.model.ContestantInterface;
import org.jturn.model.Match;
import org.jturn.model.MatchResult;
import org.jturn.model.SingleContestant;
import org.jturn.tournament.elimination.EliminationTreeInitializer;
import org.junit.Assert;
import org.junit.Test;

public class EliminationTreeResultTest {

	@Test
	public void hasOneMatch() {
		SingleContestant constant1 = new SingleContestant(1, "Jess", "Bring-Larsen"); 
		SingleContestant constant2 = new SingleContestant(2, "Ole", "Hansen");
		
		Match finalie = new Match(constant1, constant2);
		EliminationTreeInitializer initializer = new EliminationTreeInitializer();
		EliminationTree tree = initializer.initialize(Collections.singletonList(finalie));

		finalie.addResult(Collections.singletonList(new MatchResult(1, 3, 0)));
		tree.proceed();
		
		Map<Integer, Collection<ContestantInterface>> result = tree.getResult();
		Assert.assertEquals(2, result.size());
		
		Iterator<Entry<Integer, Collection<ContestantInterface>>> resultIterator = result.entrySet().iterator();
		Assert.assertEquals(constant1, resultIterator.next().getValue().iterator().next());
		Assert.assertEquals(constant2, resultIterator.next().getValue().iterator().next());
	}
	
	@Test
	public void hasTwoMatch() {
		SingleContestant constant1 = new SingleContestant(1, "Jess", "Bring-Larsen");
		SingleContestant constant2 = new SingleContestant(2, "Per", "Larsen"); 
		SingleContestant constant3 = new SingleContestant(3, "Tjele", "Jansen");
		SingleContestant constant4 = new SingleContestant(4, "Ole", "Hansen");
		
		Match m1 = new Match( 
				constant1,
				constant4);
		
		Match m2 = new Match( 
				constant2,
				constant3);
		EliminationTreeInitializer initializer = new EliminationTreeInitializer();
		EliminationTree tree = initializer.initialize(Arrays.asList(m1, m2));
		
		m1.addResult(Collections.singletonList(new MatchResult(1, 3, 0)));
		m2.addResult(Collections.singletonList(new MatchResult(1, 3, 0)));
		tree.proceed();
		
		Collection<Match> finalie = tree.getNextMatches();
		Assert.assertEquals(1, finalie.size());
		finalie.iterator().next().addResult(Collections.singletonList(new MatchResult(1, 3, 0)));
		tree.proceed();
		
		Map<Integer, Collection<ContestantInterface>> result = tree.getResult();
		Assert.assertEquals(3, result.size());
		
		Iterator<Entry<Integer, Collection<ContestantInterface>>> resultIterator = result.entrySet().iterator();
		Assert.assertEquals(constant1, resultIterator.next().getValue().iterator().next());
		Assert.assertEquals(constant2, resultIterator.next().getValue().iterator().next());
		
		Iterator<ContestantInterface> thirdAndFour = resultIterator.next().getValue().iterator();
		Assert.assertEquals(constant3, thirdAndFour.next());
		Assert.assertEquals(constant4, thirdAndFour.next());
	}
}