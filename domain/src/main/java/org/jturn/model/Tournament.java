package org.jturn.model;

public class Tournament extends EntityObject {
	private String name;

	public Tournament(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Turnering: " + this.name;
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

	@Override
	public boolean equals(Object tournament) {
		if (this == tournament) return true;
	    if (tournament == null) return false;
	    if (this.getClass() != tournament.getClass()) return false;
	    Tournament otherTournament = (Tournament) tournament;
	    return (this.getName().equals(otherTournament.getName()));
	}
}