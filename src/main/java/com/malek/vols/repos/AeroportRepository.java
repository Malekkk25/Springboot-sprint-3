package com.malek.vols.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.malek.vols.entities.Aeroport;
import com.malek.vols.entities.Vol;


public interface AeroportRepository extends JpaRepository<Aeroport,Long> {

}
