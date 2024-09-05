package com.mx.apiCrudPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiCrudPeliculas.entity.Peliculas;
import com.mx.apiCrudPeliculas.service.PeliculasImp;




@RestController
@RequestMapping("PeliculasWs")
@CrossOrigin
public class PeliculasWs {

@Autowired
PeliculasImp imp;

//Peticion get para listar


//http://localhost:9000/PeliculasWs/listar
@GetMapping("listar")
public List<Peliculas>listar(){
	return imp.listar();
}


//http://localhost:9000/PeliculasWs/guardar
@PostMapping("guardar")
public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula) {
	
	String respuesta =imp.guardar(pelicula);
	
	if(respuesta.equals("idExistente")) 
		return new ResponseEntity<String>("Esa clave unica ya existe",HttpStatus.OK);
	else if (respuesta.equals("nombreExiste"))
		
		return new ResponseEntity<String>("Ese nombre ya existe",HttpStatus.OK);
		
	else {
		return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
	}
	
	
	
	
}

//http://localhost:9000/PeliculasWs/buscar
@PostMapping("buscar")
public Peliculas buscar(@RequestBody Peliculas pelicula) {
	return imp.buscar(pelicula.getId());
}


//http://localhost:9000/PeliculasWs/editar
@PostMapping("editar")
public ResponseEntity<?>editar(@RequestBody Peliculas pelicula){
	boolean respuesta = imp.editar(pelicula);
	if(respuesta==false)
		return new ResponseEntity<String>("Ese id no existe",HttpStatus.OK);
	else {
	return new ResponseEntity<>(pelicula,HttpStatus.CREATED);
}
}


///http://localhost:9000/PeliculasWs/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Peliculas pelicula) {
		
		return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);
}
	
	//POR NOMBRE
	
	///http://localhost:9000/PeliculasWs/buscarporNombre
	@PostMapping("buscarporNombre")
	public ResponseEntity<?> buscarporNombre(@RequestBody Peliculas pelicula) {
		
		return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);
		
	}
		
	
	
	
//POR GENERO
	///http://localhost:9000/PeliculasWs/buscarporGenero
	@PostMapping("buscarporGenero")
	public ResponseEntity<?> buscarporGenero(@RequestBody Peliculas pelicula) {

		return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);

	}
	
	
	
	
	//POR NOMBRE
	
	///http://localhost:9000/PeliculasWs/eliminarporNombre
	@PostMapping("eliminarporNombre")
	public ResponseEntity<?> eliminarporNombre(@RequestBody Peliculas pelicula) {

		return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);

	}
	
	
	
	
}
