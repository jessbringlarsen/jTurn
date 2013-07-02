package org.jturn.model;

import java.util.Collection;


/**
 * Represent a part of a Category. E.g. a category can be two part: a pool 
 * caregory followed by a elimination tournament. 
 *
 */
public class CategoryTournemant extends EntityObject  {

//	private Configuration config; Configuration object stating how many winners and
//	how many points and sets a winner needs.
	private Category category;
	private Collection<MatchGroup> matchGroups;
	
}