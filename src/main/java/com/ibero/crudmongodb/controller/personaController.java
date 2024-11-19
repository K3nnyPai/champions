package com.ibero.crudmongodb.controller;

import com.ibero.crudmongodb.model.persona;
import com.ibero.crudmongodb.service.personaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")
public class personaController {
    
    @Autowired
    private personaService personaService;
    
    @GetMapping("all")
    public ResponseEntity<List<persona>> getAllPersonas(){
        List<persona> personas = personaService.getAllpersonas();
        return ResponseEntity.ok().body(personas);
    }
    
    @GetMapping("/byid/{id}")
     public ResponseEntity<persona> getPersonaById(@PathVariable Long id){
        Optional<persona> persona = personaService.getPersonaById(id);
        if(persona.isPresent()){
             return ResponseEntity.ok().body(persona.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
   @PostMapping("/save")
   
   public ResponseEntity<persona> savePersona(@RequestBody @Validated persona persona){
       persona savedPersona = personaService.savePersona(persona);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
   }
   
   @PutMapping("/update/{id}")
   public ResponseEntity<persona>updatePersona(@PathVariable Long id, @RequestBody @Validated persona persona){
       Optional<persona> personaoptional = personaService.getPersonaById(id);
       if(personaoptional.isPresent()){
       persona.setId(id);
       persona updatePersona = personaService.savePersona(persona);
       return ResponseEntity.ok().body(updatePersona);
       }
       else{
       return ResponseEntity.notFound().build();
       }
       
   }
   
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersonaById(@PathVariable Long id){
    personaService.deletePersonaById(id);
    return ResponseEntity.noContent().build();
   }
}
