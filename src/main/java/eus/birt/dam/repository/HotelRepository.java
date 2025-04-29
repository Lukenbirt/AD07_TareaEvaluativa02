package eus.birt.dam.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String>{
	
}
