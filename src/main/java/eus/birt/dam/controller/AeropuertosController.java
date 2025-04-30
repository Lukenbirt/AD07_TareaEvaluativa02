package eus.birt.dam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Aeropuerto;
import eus.birt.dam.repository.AeropuertoRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class AeropuertosController {

	
	@Autowired
	AeropuertoRepository aeropuertoRepository;
	
	// endpoint que muestra el listado de aeropuertos
	@GetMapping("/aeropuertos")
	public ResponseEntity<List<Aeropuerto>> index() {
	    try {
	        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
	        return new ResponseEntity<List<Aeropuerto>>(aeropuertos, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<Aeropuerto>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	// endpoint que muestra el listado de aeropuertos de una determinada provincia
	@GetMapping("/aeropuertos/{provincia}")
	public ResponseEntity<List<Aeropuerto>> getAeropuertosByProvincia(@PathVariable String provincia) {
	    try {
	        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
	        List<Aeropuerto> filteredAeropuertos = new ArrayList<>();

	        for (Aeropuerto aeropuerto : aeropuertos) {
	            if (aeropuerto.getProperties().getTerritory().equalsIgnoreCase(provincia)) {
	                filteredAeropuertos.add(aeropuerto);
	            }
	        }

	        return new ResponseEntity<>(filteredAeropuertos, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	// endpoint que muestra las webs de los aeropuertos
	@GetMapping("/webs")
	public ResponseEntity<List<String>> getAllTerritories() {
	    try {
	        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
	        Set<String> uniqueTerritories = new HashSet<>();
	        for (Aeropuerto aeropuerto : aeropuertos) {
	            uniqueTerritories.add(aeropuerto.getProperties().getWeb());
	        }
	        List<String> sortedTerritories = new ArrayList<>(uniqueTerritories);
	        Collections.sort(sortedTerritories);
	        return new ResponseEntity<List<String>>(sortedTerritories, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}