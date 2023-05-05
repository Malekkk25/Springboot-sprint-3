package com.malek.vols.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.malek.vols.entities.Aeroport;
import com.malek.vols.entities.Vol;

public interface VolService {
Vol saveVol(Vol v);
Vol updateVol(Vol v);
void deleteVol(Vol v);
void deleteVolById(Long id);
Vol getVol(Long id);
List<Vol> getAllVols();
Page<Vol> getAllVolsParPage(int page, int size);
List<Vol> findByDestination(String destination);
List<Vol> findByDestinationContains(String destination);
List<Vol> findByDestAgence (String destination, String agence);
List<Vol> findByAeroport (Aeroport aeroport);
List<Vol> findByAerportIdAir(Long id);
List<Vol> findByOrderByDestinationAsc();
List<Vol> trierVolsDestAgence();
long countVols();
List<Aeroport> getAllAeroports();
//List<Aeroport> getAllAeroports();

}
