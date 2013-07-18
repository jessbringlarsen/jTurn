package org.jturn.model;

import java.util.ArrayList;
import java.util.Collection;

public class Tournament extends EntityObject {
	private final String name;
	private final Collection<Category> categories = new ArrayList<>();

	public Tournament(String name) {
		this.name = name;
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}

	public String getName() {
		return name;
	}
}