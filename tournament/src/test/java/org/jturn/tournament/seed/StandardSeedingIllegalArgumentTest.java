package org.jturn.tournament.seed;

import org.junit.Test;

public class StandardSeedingIllegalArgumentTest {

	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentNegative() {
		new Elimination(-1);
	}
	
	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentZero() {
		new Elimination(0);
	}
	
	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentOne() {
		new Elimination(1);
	}
	
	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentFive() {
		new Elimination(5);
	}
}
