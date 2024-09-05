package com.mx.apiCrudPeliculas.service;

import java.util.List;

import com.mx.apiCrudPeliculas.entity.Peliculas;

public interface PeliculasService {

public List<Peliculas> listar();

public String guardar(Peliculas pelicula);

public Peliculas buscar(Long id);

public boolean editar(Peliculas pelicula);

public boolean eliminar(Long id);

public String buscarporNombre(Peliculas pelicula);

public String buscarporGenero(Peliculas pelicula);

public String EliminarporNombre(Peliculas pelicula);
	
}
