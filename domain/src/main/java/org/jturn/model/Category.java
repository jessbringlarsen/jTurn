package org.jturn.model;

import java.util.Collection;


//import dk.bringlarsen.tournament.draw.DrawStrategy;

/**
 * Represent a category e.g. Single Senior A
 */
public class Category extends EntityObject {
	private Tournament tournament;
	private String name;

	private Collection<CategoryTournemant> tournaments;
	private Collection<CategoryParticipant> participants;
	
}