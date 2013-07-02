/*
 * Created on 15-07-2004
 */
package org.jturn.model;


/**
 * <p>Represent a participant, in a category.</p>
 * 
 * @author jebl
 */
public class CategoryParticipant extends EntityObject { //implements Comparable<CategoryParticipant>, Serializable {
	private int seed; // replace with object implementing no seeding and seeding
	private ContestantInterface contestant;

	public CategoryParticipant(ContestantInterface contestant) {
		this.contestant = contestant;
	}

	public CategoryParticipant(int seed, ContestantInterface contestant) {
		this.seed = seed;
		this.contestant = contestant;
	}

	public ContestantInterface getContestant() {
		return contestant;
	}

	public void setContestant(ContestantInterface contestant) {
		this.contestant = contestant;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public boolean isBye() {
		if (this.contestant.getName().equals("Bye"))
			return true;
		else
			return false;
	}

	/*
	 * SortedMap is used to store objects of type CategoryParticipants. Sorted
	 * by: 1, 2, 3, 4, 0, 0, 0, 0....
	 */
/*	public int compareTo(CategoryParticipant compareTo) {
		int ret = 0;

		if (this.getSeed() != 0 && compareTo.getSeed() != 0) {
			if (this.getSeed() < compareTo.getSeed())
				ret = -1;
			else if (this.getSeed() > compareTo.getSeed())
				ret = 1;
		} else if (this.getSeed() == 0 || compareTo.getSeed() == 0) {
			if (this.getSeed() != 0 && compareTo.getSeed() == 0)
				ret = -1;
			else if (this.getSeed() == 0 && compareTo.getSeed() != 0)
				ret = 1;
			else
				ret = 1;
		}
		return ret;
	}*/

	public String toString() {
		return "Name: " + this.contestant.getName() + " Seed: " + this.seed
				+ "\n";
	}
}