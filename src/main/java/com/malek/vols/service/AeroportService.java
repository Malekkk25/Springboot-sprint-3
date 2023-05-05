package com.malek.vols.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.malek.vols.entities.Aeroport;

public interface AeroportService {
	Aeroport saveAeroport(Aeroport r);
	Aeroport updateAeroport(Aeroport r);
	void deleteAeroport(Aeroport r);
	 void deleteAeroportByRef(Long id);
	 Aeroport getAeroport(Long id);
	List<Aeroport> getAllAeroports();
	Page<Aeroport> getAllAeroportsParPage(int page, int size);

}
