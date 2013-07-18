/*
 * Created on 14-07-2004
 */
package org.jturn.model;


/**
 *
 * Intent: Represent a contestent in a singels category
 * 
 * @author jebl
 */

public class SingleContestant extends BaseContestant {

	public SingleContestant(int seed, String firstName, String surName) {
		super(seed, firstName, surName);
	}
	

	@Override
	public boolean isBye() {
		return false;
	}
}