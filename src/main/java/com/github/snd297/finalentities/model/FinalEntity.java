package com.github.snd297.finalentities.model;

import javax.annotation.Nullable;
import javax.persistence.Entity;

import com.github.snd297.modelutil.EntityWLongIdAndVersion;

@Entity
public final class FinalEntity extends EntityWLongIdAndVersion {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(@Nullable String message) {
		this.message = message;
	}
}
