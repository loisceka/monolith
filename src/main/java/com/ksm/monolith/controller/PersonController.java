/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.controller;

import com.ksm.monolith.model.Brand;
import com.ksm.monolith.model.Person;
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
@RequestMapping("api/person")

public class PersonController {
    @Autowired
    PersonService personService;
    
    /**
     * - GET    -> getAll() 
     * - GET    -> getById() 
     * - POST    -> save(Person person) 
     * - PUT    -> saveNewLastName(Integer id, String lastName) 
     * - DELETE    -> delete(Integer id)
     */
    
    @GetMapping()
    public List<Person> getAll(){
        return personService.getAllPerson();
    }
    
    @GetMapping("/{id}") //localhost:8080/api/person/1
    public Person getById(@PathVariable Integer id){
        return personService.getById(id);
    }
    
    @PostMapping()
    public Person save(@RequestBody Person person){
        return personService.insertData(person);
    }
    
    @PutMapping("/{id}") // Put [..] -> Mudjiarto, Patch Kelana -> Mudjiarto
    public Person save(@PathVariable Integer id,@RequestBody Person person){
        return personService.update(id, person);
    }
    
    @DeleteMapping("/{id}")
    public Person delete(@PathVariable Integer id){
        return personService.deleteById(id);
    }
    /*    
    @GetMapping("allFemale")
    public @ResponseBody List<Person> femaleList(){
        List<Person> people = personService.getFemales();
        
         for (Person person : people) {
            System.out.println(person.getId());
            System.out.println(person.getFirstName());
            System.out.println(person.getLastName());
            System.out.println(person.getGender());
        }
        return people;
    }
    @GetMapping("belonging")
    public @ResponseBody String personBelonging(){
//        Person person = new Person("Lois", "Ceka", "Male");
        personService.givePencilAndEraserToNewPerson(1, 1);
        return "person";
    }
    @GetMapping("belongingList")
    public @ResponseBody List<Person> belongingList(){
        List<Person> people = personService.getAllPerson();
        
        for (Person person : people) {
            System.out.println(person.getFirstName());
            for (Belonging belonging : person.getBelongings()) {
                System.out.println(belonging.getId());
                System.out.println(belonging.getName());
            }
        }
        return people;
    } */
}
