package com.malek.vols.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "numVol", types = { Vol.class })
public interface VolProjection {
	public String getNumVol();
	
}
