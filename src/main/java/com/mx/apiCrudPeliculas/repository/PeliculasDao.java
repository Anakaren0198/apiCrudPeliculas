package com.mx.apiCrudPeliculas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.apiCrudPeliculas.entity.Peliculas;

@Repository
public interface PeliculasDao extends CrudRepository<Peliculas, Long> {

	
	
	
}


