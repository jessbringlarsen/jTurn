package org.jturn.model;


/**
 * Represents the common attributes for an entity object.
 *
 * @author jbl
 */
public class EntityObject implements Comparable<EntityObject> {

	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
    public boolean equals(Object o) {
		if (this == o) {
            return true;
        }

        if (o instanceof EntityObject) {
            return getId().equals(((EntityObject) o).getId());
        }

        return false;
    }

	public int compareTo(EntityObject o) {
		return this.getId().compareTo(o.getId());
	}
}
