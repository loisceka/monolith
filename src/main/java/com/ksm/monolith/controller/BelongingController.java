/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.controller;

import com.ksm.monolith.model.Belonging;
import com.ksm.monolith.model.Person;
import com.ksm.monolith.service.BelongingService;
import com.ksm.monolith.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author loisceka
 */
@RestController
@RequestMapping("api/belonging")

public class BelongingController {
    @Autowired
    BelongingService belongingService;
    @Autowired
    PersonService personService;
    
    @GetMapping()
    public List<Belonging> getAll(){
        return belongingService.getAllBelonging();
    }
    
    @GetMapping("/{id}") //localhost:8080/api/belonging/1
    public Belonging getById(@PathVariable Integer id){
        return belongingService.getById(id);
    }
    
    @PostMapping()
     public Person save(@RequestBody Belonging belonging){
         System.out.println(belonging);
       return personService.givePencilAndEraserToNewPerson(belonging);
       
    }
    
    @PutMapping("/{id}") 
    public Belonging save(@PathVariable Integer id,@RequestBody Belonging belonging){
        return belongingService.update(id, belonging);
    }
    
    @DeleteMapping("/{id}")
    public Belonging delete(@PathVariable Integer id){
        return belongingService.deleteById(id);
    } 
}
