package org.jturn.tournament.elimination;

import org.jturn.tournament.elimination.InitialEliminationTreeCalculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * A smoke test that validate that the tournament tree is done right.
 *
 * @author jbl
 *
 */
public class StandardSeedingTest {

	private static int[] seedingsTwo = {0, 1};
	private static int[] seedingsFour = {0, 3, 2, 1};
	private static int[] seedingsEight = {0, 7, 4, 3, 2, 5, 6, 1};
	private static int[] seedingsSixteen = {0, 15, 8, 7, 4, 11, 12, 3, 2, 13, 10, 5, 6, 9, 14, 1};
	private static int[] seedingsThirtyTwo = {0, 31, 16, 15, 8, 23, 24, 7, 4, 27, 20, 11, 12, 19, 28, 3, 2, 29, 18, 13, 10, 21, 26, 5, 6, 25, 22, 9, 14, 17, 30, 1};

	@Test
	public void test() {
		Assert.assertArrayEquals(seedingsTwo, new InitialEliminationTreeCalculator(2).ranks());
		Assert.assertArrayEquals(seedingsFour, new InitialEliminationTreeCalculator(4).ranks());
		Assert.assertArrayEquals(seedingsEight, new InitialEliminationTreeCalculator(8).ranks());
		Assert.assertArrayEquals(seedingsSixteen, new InitialEliminationTreeCalculator(16).ranks());
		Assert.assertArrayEquals(seedingsThirtyTwo, new InitialEliminationTreeCalculator(32).ranks());
	}
}


