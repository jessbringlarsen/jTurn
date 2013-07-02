package org.jturn.tournament.elimination;

import static org.hamcrest.CoreMatchers.is;

import org.jturn.tournament.elimination.ByeCalculator;
import org.junit.Assert;
import org.junit.Test;

public class ByeCalculatorTest {

	@Test (expected=IllegalArgumentException.class)
	public void testIllegalArgumentNegative() {
		ByeCalculator.noOfBye(-1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testIllegalArgumentZero() {
		ByeCalculator.noOfBye(0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testIllegalArgumentOne() {
		ByeCalculator.noOfBye(1);
	}
	
	@Test
	public void testLegalArguments() {
		Assert.assertThat(ByeCalculator.noOfBye(2), is(0));
		Assert.assertThat(ByeCalculator.noOfBye(3), is(1));
		Assert.assertThat(ByeCalculator.noOfBye(4), is(0));
		Assert.assertThat(ByeCalculator.noOfBye(5), is(3));
		Assert.assertThat(ByeCalculator.noOfBye(6), is(2));
		Assert.assertThat(ByeCalculator.noOfBye(7), is(1));
		Assert.assertThat(ByeCalculator.noOfBye(8), is(0));
		Assert.assertThat(ByeCalculator.noOfBye(9), is(7));
	}
}