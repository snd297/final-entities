package com.github.snd297.finalentities.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

import com.github.snd297.modelutil.EntityWLongIdAndVersion;

@Entity
@Proxy(lazy = false)
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