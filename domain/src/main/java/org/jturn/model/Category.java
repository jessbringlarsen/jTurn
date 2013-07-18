package org.jturn.model;

import java.util.Collection;
import java.util.TreeMap;


/**
 * Represent a category e.g. Single Senior A
 */
public class Category extends EntityObject {
	private final String name;
	private final TreeMap<Integer, ContestantInterface> contestants = new TreeMap<>();
	
	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public TreeMap<Integer, ContestantInterface> getContestants() {
		return contestants;
	}

	public void addContestants(Collection<ContestantInterface> contestants) {
		for(ContestantInterface contestant : contestants) {
			Integer seed = Integer.valueOf(contestant.getSeed());
			
			if(!this.contestants.containsKey(seed)) {
				this.contestants.put(seed, contestant);
			} else {
				throw new IllegalArgumentException("Collections contains duplicate seedings for seed: " + contestant.getSeed());
			}
		}
	}
}