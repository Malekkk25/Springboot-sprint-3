package com.malek.vols;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.malek.vols.entities.Vol;

import com.malek.vols.repos.VolRepository;
import com.malek.vols.service.VolService;
import com.malek.vols.entities.Aeroport;

@SpringBootTest
class ProjetVolApplicationTests {

	@Autowired
	private VolRepository volRepository;
	
	@Autowired
	private VolService volService;
	
	
	@Test
	public void testCreateVol() {
		Vol v=new Vol("TU620","TunisAir",new Date(),"France","atteri");
		volRepository.save(v);
	}
	
	@Test
	public void testFindVol()
	{
	Vol v = volRepository.findById(1L).get(); 
	System.out.println(v);
	}
	
	@Test
	public void testUpdateVol()
	{
	Vol v = volRepository.findById(1L).get();
	v.setDestination("France");
	volRepository.save(v);
	}
	
	@Test
	public void testDeleteVol()
	{
	volRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousVols()
	{
	List<Vol> vo = volRepository.findAll();
	for (Vol v : vo)
	{
	System.out.println(v);
	}}

	@Test
	public void testFindByNumVolContains()
	{
	Page<Vol> vo = volService.getAllVolsParPage(0,2);
	System.out.println(vo.getSize());
	System.out.println(vo.getTotalElements());
	System.out.println(vo.getTotalPages());
	vo.getContent().forEach(v -> {System.out.println(v.toString());
	 });
	
	}
	
	
	@Test
	public void testFindByDestinationContains ()
	{
	List<Vol> vo=volRepository.findByDestinationContains("Egypte");
	for (Vol v : vo)
	{
	System.out.println(v);
	} }

	@Test
	public void testfindByAgence()
	{
	List<Vol> vo = volRepository.findByDestAgence("Istanbul", "TunisAir");
	for (Vol v : vo)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void testfindByAeroport()
	{
	Aeroport air = new Aeroport();
	air.setIdAir(1L);
	List<Vol> vo = volRepository.findByAeroport(air);
	for (Vol v : vo)
	{
	System.out.println(v);
	}
	}

	@Test
	public void findByAeroportIdAir()
	{
	List<Vol> vo = volRepository.findByAeroportIdAir(1L);
	for (Vol v : vo)
	{
	System.out.println(v);
	}
	 }
	
	@Test
	public void testfindByOrderByDestinationAsc()
	{
	List<Vol> vo = volRepository.findByOrderByDestinationAsc();
	for (Vol v : vo)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void testTrierVolsDestAgence()
	{
	List<Vol> vo = volRepository.trierVolsDestAgence();
	for (Vol v : vo)
	{
	System.out.println(v);
	}
	}

	

	

}
