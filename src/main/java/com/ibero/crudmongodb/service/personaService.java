package com.ibero.crudmongodb.service;

import com.ibero.crudmongodb.model.persona;
import java.util.List;
import java.util.Optional;

public interface personaService {
    
    List<persona> getAllpersonas();
    Optional<persona> getPersonaById(Long id);
    persona savePersona(persona persona);
    void deletePersonaById(Long id);
    
    
}
