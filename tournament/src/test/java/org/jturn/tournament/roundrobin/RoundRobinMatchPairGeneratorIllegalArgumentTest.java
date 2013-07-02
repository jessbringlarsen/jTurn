package org.jturn.tournament.roundrobin;

import org.junit.Assert;
import org.junit.Test;

public class RoundRobinMatchPairGeneratorIllegalArgumentTest {

	@Test
	public void testIllegalArgument() {
		testArgument(0);
		testArgument(1);
		testArgument(3);
		testArgument(13);
	}
	
	public void testArgument(int argument) {
		try {
			new RoundRobinMatchPairGenerator(argument);
			Assert.fail("Argument: " + argument + " should not be valid");
		} catch(IllegalArgumentException e) {
			// Ignore as this is expected
		}
	}
}
