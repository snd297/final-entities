package com.github.snd297.finalentities.model;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public final class FinalBicycle extends EntityWLongIdAndVersion {
	private Set<FinalWheel> wheels = newHashSet();

	@OneToMany(
			mappedBy = "bicycle",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@Size(max = 2)
	public Set<FinalWheel> getWheels() {
		return wheels;
	}

	@SuppressWarnings("unused")
	private void setWheels(Set<FinalWheel> wheels) {
		this.wheels = wheels;
	}

}
