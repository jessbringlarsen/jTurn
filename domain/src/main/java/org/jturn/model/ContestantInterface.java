/*
 * Created on 14-07-2004
 */
package org.jturn.model;


/**
 * @author jebl Intent: Provide an interface for contestants in the tournament.
 *
 */

public interface ContestantInterface {
	String getName();

	String getShortName();
	
	int getSeed();

	boolean isBye();
}
