package com.ibero.crudmongodb.api;

import com.ibero.crudmongodb.model.persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface personaRepository extends MongoRepository<persona, Long>{
    
}
