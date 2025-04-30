package eus.birt.dam.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Aeropuerto;

public interface AeropuertoRepository extends MongoRepository<Aeropuerto, String>{
	
}
