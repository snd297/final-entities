package com.github.snd297.finalentities.model;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.github.snd297.modelutil.EntityWLongIdAndVersion;

@Entity
public final class FinalBicycle extends EntityWLongIdAndVersion {
	private Set<FinalWheel> wheels = newHashSet();

	public void addWheel(FinalWheel wheel) {
		wheels.add(wheel);
		wheel.setBicycle(this);
	}

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
