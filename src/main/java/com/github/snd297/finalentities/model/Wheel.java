package com.github.snd297.finalentities.model;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Wheel extends EntityWLongIdAndVersion {

	private Set<Spoke> spokes = newHashSet();

	@OneToMany(
			mappedBy = "wheel",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<Spoke> getSpokes() {
		return spokes;
	}

	@SuppressWarnings("unused")
	private void setSpokes(Set<Spoke> spokes) {
		this.spokes = spokes;
	}
}
