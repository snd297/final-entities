package com.github.snd297.finalentities.model;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public final class FinalWheel extends EntityWLongIdAndVersion {
	private FinalBicycle bicycle;
	private Set<FinalMethodSpoke> spokes = newHashSet();

	// For Hibernate
	FinalWheel() {}

	public FinalWheel(FinalBicycle bicycle) {
		this.bicycle = bicycle;
		bicycle.getWheels().add(this);
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	public FinalBicycle getBicycle() {
		return bicycle;
	}

	@OneToMany(
			mappedBy = "wheel",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<FinalMethodSpoke> getSpokes() {
		return spokes;
	}

	public void setBicycle(FinalBicycle bicycle) {
		this.bicycle = bicycle;
	}

	@SuppressWarnings("unused")
	private void setSpokes(Set<FinalMethodSpoke> spokes) {
		this.spokes = spokes;
	}
}
