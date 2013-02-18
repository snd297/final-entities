package com.github.snd297.finalentities.model;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.github.snd297.modelutil.EntityWLongIdAndVersion;

@Entity
public final class FinalWheel extends EntityWLongIdAndVersion {
	private FinalBicycle bicycle;
	private Set<FinalSpoke> spokes = newHashSet();

	public void addSpoke(FinalSpoke spoke) {
		spokes.add(spoke);
		spoke.setWheel(this);
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
	public Set<FinalSpoke> getSpokes() {
		return spokes;
	}

	public void setBicycle(FinalBicycle bicycle) {
		this.bicycle = bicycle;
	}

	@SuppressWarnings("unused")
	private void setSpokes(Set<FinalSpoke> spokes) {
		this.spokes = spokes;
	}
}
