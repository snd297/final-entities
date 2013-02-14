package com.github.snd297.modelutil;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class EntityWLongIdAndVersion {

	private Long id;
	private Integer version;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@Version
	public Integer getVersion() {
		return version;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	@SuppressWarnings("unused")
	private void setVersion(Integer version) {
		this.version = version;
	}
}
