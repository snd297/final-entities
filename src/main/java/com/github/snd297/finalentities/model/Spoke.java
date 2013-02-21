package com.github.snd297.finalentities.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Spoke extends EntityWLongIdAndVersion {
	private Wheel wheel;

	Spoke() {}

	public Spoke(Wheel wheel) {
		this.wheel = wheel;
		wheel.getSpokes().add(this);
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

}
