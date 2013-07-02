package org.jturn.tournament.seed;

import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Test;

/**
 *
 * @author jbl
 *
 */
public class StandardSeedingIteratorEmptyTest {

	private static int[] seedingsEmpty = {};

	@Test
	public void testNullIterator() {
		Iterator<Integer> iterator = new EliminationRankIterator(null);
		Assert.assertFalse(iterator.hasNext());
	}

	@Test
	public void testIterator() {
		Iterator<Integer> iterator = new EliminationRankIterator(seedingsEmpty);
		Assert.assertFalse(iterator.hasNext());
	}
}
