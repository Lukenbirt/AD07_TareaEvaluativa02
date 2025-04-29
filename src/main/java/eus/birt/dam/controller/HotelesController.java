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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Hotel;
import eus.birt.dam.repository.HotelRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class HotelesController {

	
	@Autowired
	HotelRepository hotelRepository;
	
	/**
	 * Endpoint principal de hoteles.
	 * @return
	 */
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> index() {
	    try {
	        List<Hotel> hotels = hotelRepository.findAll();
	        return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<Hotel>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/provinces")
	public ResponseEntity<List<String>> getAllTerritories() {
	    try {
	        List<Hotel> hotels = hotelRepository.findAll();
	        Set<String> uniqueTerritories = new HashSet<>();
	        for (Hotel hotel : hotels) {
	            uniqueTerritories.add(hotel.getProperties().getTerritory());
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