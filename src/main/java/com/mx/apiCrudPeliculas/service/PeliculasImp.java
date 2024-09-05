package com.mx.apiCrudPeliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiCrudPeliculas.entity.Peliculas;
import com.mx.apiCrudPeliculas.repository.PeliculasDao;

import jakarta.transaction.Transactional;

@Service
public class PeliculasImp implements PeliculasService {

	
	
	//Inyeccion de dependencias
		@Autowired
		PeliculasDao dao;
		
		
		@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Override
	public List<Peliculas> listar() {
		// TODO Auto-generated method stub
		return (List<Peliculas>)dao.findAll();
	}
		
		//validar que el id y nombre exixtan para guardar
@org.springframework.transaction.annotation.Transactional
	@Override
	public String guardar(Peliculas pelicula) {
		// TODO Auto-generated method stub
	
	//obtener los registros bd
	//ciclo
	//if f
	
	
	String respuesta ="";
	boolean bandera = false;
	for(Peliculas p:dao.findAll()) {
		
		//todos los tipos de dats primitivoss que estan parciados
		//comparralos con el equals
		
		if(p.getId().equals(pelicula.getId())) {
		respuesta="idExiste";
		bandera = true;
		break;
	}else if(p.getNombre().equals(pelicula.getNombre())) {
		respuesta="nombreExistente";
		bandera=true;
		break;
	}
}
	
	if (bandera==false)
		dao.save(pelicula);
	
	return respuesta;
	
	
	}
@org.springframework.transaction.annotation.Transactional
	@Override
	public Peliculas buscar(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}


@org.springframework.transaction.annotation.Transactional
	@Override
	public boolean editar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		
	boolean bandera = true;
	if(buscar(pelicula.getId())==null) {
		bandera = false;
		
	}else {
		dao.save(pelicula);
	}
	return bandera;
	}




@org.springframework.transaction.annotation.Transactional
	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		boolean bandera =true;
		if(buscar(id)==null) {
			bandera = false;
			
		}else {
			
			dao.deleteById(id);
		}
		return bandera;
	}


//Buscar por nombre --- objeto
	//Buscar por genero ----lista(objetos)
	//Eliminar por nombre --- validar que el nombre exista --- mensaje


	@Transactional
	@Override
	public String buscarporNombre(Peliculas pelicula) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Peliculas p: dao.findAll()) {
			
			if(p.getId().equals(pelicula.getId())) {
				respuesta = "Existe Id";
				bandera = true;
				break;
			} else if (p.getNombre().equals(pelicula.getNombre())) {
				respuesta="Existe Nombre";
				bandera = true;
				break;
			}
		}
		
		if(bandera=false)
		dao.findAll();
		return respuesta;
	}




	@Transactional
	@Override
	public String buscarporGenero(Peliculas pelicula) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Peliculas p: dao.findAll()) {
			
			if(p.getId().equals(pelicula.getId())) {
				respuesta = "Existe Id";
				bandera = true;
				break;
			} else if (p.getGenero().equals(pelicula.getGenero())) {
				respuesta="Existe este genero";
				bandera = true;
				break;
			}
		}
		
		if(bandera=false)
		dao.findAll();
		return respuesta;
	}



	

	@Transactional
	@Override
	public String EliminarporNombre(Peliculas pelicula) {
		// TODO Auto-generated method stub
		String respuesta = "";
		boolean bandera = false;
		for (Peliculas p: dao.findAll()) {
			
			if(p.getId().equals(pelicula.getId())) {
				respuesta = "Existe este Id";
				bandera = true;
				break;
			} else if (p.getNombre().equals(pelicula.getNombre())) {
				respuesta="Existe Nombre";
				bandera = true;
				break;
			}
		}
		
		if(bandera=false)
		dao.delete(pelicula);
		return respuesta;
	}

	

	
	
	
}
	
	
		
	
	

