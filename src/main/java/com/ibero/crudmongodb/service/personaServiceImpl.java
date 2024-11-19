package com.ibero.crudmongodb.service;

import com.ibero.crudmongodb.api.personaRepository;
import com.ibero.crudmongodb.model.persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class personaServiceImpl implements personaService{
    
    @Autowired
    private personaRepository personaRepository;

    @Override
    public List<persona> getAllpersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public persona savePersona(persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void deletePersonaById(Long id) {
        personaRepository.deleteById(id);
    }
    
}
