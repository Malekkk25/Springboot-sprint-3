package com.malek.vols.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.malek.vols.entities.Aeroport;
import com.malek.vols.entities.Vol;

@RepositoryRestResource(path = "rest")
public interface VolRepository extends JpaRepository<Vol,Long> {

	List<Vol> findByDestination(String destination);
	 List<Vol> findByDestinationContains(String destination); 
	
	 @Query("select v from Vol v where v.destination like %?1 and v.agence like ?2")
	 List<Vol> findByDestAgence (String nom, String agence);
	  
	 @Query("select v from Vol v where v.aeroport = ?1")
	 List<Vol> findByAeroport (Aeroport aeroport);
	 
	 List<Vol> findByAeroportIdAir(Long id);
	 List<Vol> findByOrderByDestinationAsc();
	 
	 @Query("select v from Vol v order by v.destination ASC, v.agence DESC")
	 List<Vol> trierVolsDestAgence ();
	 
	 
	 long count();


	 


	
}
