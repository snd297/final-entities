package com.github.snd297.finalentities.model;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.github.snd297.modelutil.EntityWLongIdAndVersion;

public final class FinalWheel extends EntityWLongIdAndVersion {
	private FinalBicycle bicycle;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	public FinalBicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(FinalBicycle bicycle) {
		this.bicycle = bicycle;
	}
}
