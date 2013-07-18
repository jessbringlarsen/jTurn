/*
 * Created on 14-07-2004
 */
package org.jturn.model;

import java.util.Collection;


/**
 *
 * Represent a group of matches. A group of matches could be a pool or a
 * single elimination match.
 *
 * @author jebl
 */
public class MatchGroup extends EntityObject {

	private final Collection<Match> matches;

	public MatchGroup(Collection<Match> matches) {
		this.matches = matches;
	}
}