/*
 * Copyright 2013 Sam Donnelly
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.snd297.finalentities.model;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Wheel extends LongIdAndVersion {

	private Set<Spoke> spokes = newHashSet();

	@OneToMany(
			mappedBy = "wheel",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<Spoke> getSpokes() {
		return spokes;
	}

	@SuppressWarnings("unused")
	private void setSpokes(Set<Spoke> spokes) {
		this.spokes = spokes;
	}
}
