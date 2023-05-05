package com.malek.vols.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.malek.vols.entities.Vol;
import com.malek.vols.repos.AeroportRepository;
import com.malek.vols.repos.VolRepository;
import com.malek.vols.entities.Aeroport;

@Service
public class VolServiceImpl implements VolService {

	@Autowired
	VolRepository volRepository;
	
	
	
	@Autowired
	AeroportRepository aeroportRepository;
	
	public Vol saveVol(Vol v) {
		return volRepository.save(v);
	}

	public Vol updateVol(Vol v) {
		
		return volRepository.save(v);
	}

	public void deleteVol(Vol v) {
		
		volRepository.delete(v);
		
	}

	public void deleteVolById(Long id) {
		
		volRepository.deleteById(id);
	}

	public Vol getVol(Long id) {
		
		return volRepository.findById(id).get();
	}

	public List<Vol> getAllVols() {
		
		return volRepository.findAll();
	}
	@Override
	public Page<Vol> getAllVolsParPage(int page, int size) {
	return volRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Vol> findByDestination(String destination) {

		return volRepository.findByDestination(destination);
	}

	@Override
	public List<Vol> findByDestinationContains(String destination) {
		
		return volRepository.findByDestinationContains(destination);
	}

	@Override
	public List<Vol> findByDestAgence(String destination, String agence) {
		return volRepository.findByDestAgence(destination, agence);
	}





	@Override
	public List<Vol> findByOrderByDestinationAsc() {
		return volRepository.findByOrderByDestinationAsc();
	}

	@Override
	public List<Vol> trierVolsDestAgence() {
		return volRepository.trierVolsDestAgence();
	}

	@Override
	public List<Vol> findByAeroport(Aeroport aeroport) {
		return volRepository.findByAeroport(aeroport);
	}

	@Override
	public List<Vol> findByAerportIdAir(Long id) {
		return volRepository.findByAeroportIdAir(id);
	}

	@Override
	public long countVols() {
		return  volRepository.count();
	}

	@Override
	public List<Aeroport> getAllAeroports() {
		// TODO Auto-generated method stub
		return aeroportRepository.findAll();
	}
	
	/*@Override
	public List<Aeroport> getAllAeroports(){
		return  aeroportRepository.findAll;
	}*/
	
	

	
}
