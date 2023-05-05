package com.malek.vols.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.malek.vols.entities.Aeroport;
import com.malek.vols.repos.AeroportRepository;
import com.malek.vols.repos.VolRepository;


@Service
public class AeroportServiceImpl implements AeroportService{

	@Autowired
	AeroportRepository aeroportRepository;
	
	
	@Override
	public Aeroport saveAeroport(Aeroport r) {
		// TODO Auto-generated method stub
		return aeroportRepository.save(r);
	}

	@Override
	public Aeroport updateAeroport(Aeroport r) {
		// TODO Auto-generated method stub
		return aeroportRepository.save(r);
	}

	@Override
	public void deleteAeroport(Aeroport r) {
		// TODO Auto-generated method stub
		aeroportRepository.delete(r);
	}

	@Override
	public void deleteAeroportByRef(Long id) {
		// TODO Auto-generated method stub
		aeroportRepository.deleteById(id);	
	}

	@Override
	public Aeroport getAeroport(Long id) {
		// TODO Auto-generated method stub
		return aeroportRepository.findById(id).get();
	}

	@Override
	public List<Aeroport> getAllAeroports() {
		// TODO Auto-generated method stub
		return aeroportRepository.findAll();
	}

	@Override
	public Page<Aeroport> getAllAeroportsParPage(int page, int size) {
		// TODO Auto-generated method stub
		return aeroportRepository.findAll(PageRequest.of(page, size));
	}

}
