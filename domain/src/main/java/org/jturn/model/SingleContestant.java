/*
 * Created on 14-07-2004
 */
package org.jturn.model;

import java.io.Serializable;

/**
 *
 * Intent: Represent a contestent in a singels category
 * 
 * @author jebl
 */

public class SingleContestant extends EntityObject implements Serializable, ContestantInterface { //, Comparable<SingleContestant>,
	private String fName, sName;

	public SingleContestant(String fName, String sName) {
		this.fName = fName;
		this.sName = sName;
	}

	@Override
	public void setName(String fName, String sName) {
		this.fName = fName;
		this.sName = sName;
	}

	@Override
	public String getName() {
		return this.fName + " " + sName;
	}

	@Override
	public String getShortName() {
		return this.sName;
	}
}