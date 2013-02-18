package com.github.snd297.finalentities.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.github.snd297.modelutil.EntityWLongIdAndVersion;

@Entity
public final class FinalSpoke extends EntityWLongIdAndVersion {
	private FinalWheel wheel;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	public FinalWheel getWheel() {
		return wheel;
	}

	public void setWheel(FinalWheel wheel) {
		this.wheel = wheel;
	}

}
