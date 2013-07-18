package org.jturn.tournament.elimination;

import java.util.Iterator;

import org.jturn.tournament.elimination.EliminationRankIterator;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jbl
 *
 */
public class StandardSeedingIteratorEmptyTest {

	private static int[] seedingsEmpty = {};

	@Test(expected=IllegalArgumentException.class)
	public void testNullIterator() {
		Iterator<Integer> iterator = new EliminationRankIterator(null);
		Assert.assertFalse(iterator.hasNext());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIterator() {
		Iterator<Integer> iterator = new EliminationRankIterator(seedingsEmpty);
		Assert.assertFalse(iterator.hasNext());
	}
}
