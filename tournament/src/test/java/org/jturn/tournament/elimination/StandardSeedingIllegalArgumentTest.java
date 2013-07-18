package org.jturn.tournament.elimination;

import org.jturn.tournament.elimination.InitialEliminationTreeCalculator;
import org.junit.Test;

public class StandardSeedingIllegalArgumentTest {

	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentNegative() {
		new InitialEliminationTreeCalculator(-1);
	}
	
	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentZero() {
		new InitialEliminationTreeCalculator(0);
	}
	
	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentOne() {
		new InitialEliminationTreeCalculator(1);
	}
	
	@Test (expected=IllegalArgumentException.class)  
	public void testIllegalArgumentFive() {
		new InitialEliminationTreeCalculator(5);
	}
}
