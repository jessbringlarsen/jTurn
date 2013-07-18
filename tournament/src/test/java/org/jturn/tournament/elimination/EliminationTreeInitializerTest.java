package org.jturn.tournament.elimination;

import static org.hamcrest.CoreMatchers.is;

import org.jturn.tournament.elimination.tree.EliminationTree;
import org.junit.Assert;
import org.junit.Test;

public class EliminationTreeInitializerTest {

	@Test
	public void testCorrectNumberOfFirstroundMatchesIsGenerated() {
		for(int i=2; i<=256; i=i+i) {
			EliminationTreeInitializer eliminationTreeInitializer = new EliminationTreeInitializer();
			EliminationTree tree = eliminationTreeInitializer.initialize(i);
			
			Assert.assertThat(tree.getNumberOfFirstRoundMatches(), is(i/2));
		}
	}
}