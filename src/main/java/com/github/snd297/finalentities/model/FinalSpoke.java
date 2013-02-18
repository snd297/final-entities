package com.github.snd297.finalentities.model;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.github.snd297.modelutil.EntityWLongIdAndVersion;

public final class FinalSpoke extends EntityWLongIdAndVersion {
	private FinalWheel wheel;

	@NotNull
	@ManyToOne
	public FinalWheel getWheel() {
		return wheel;
	}

	public void setWheel(FinalWheel wheel) {
		this.wheel = wheel;
	}

}
