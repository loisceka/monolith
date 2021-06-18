/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.service;

import com.ksm.monolith.model.Belonging;
import com.ksm.monolith.model.Brand;
import com.ksm.monolith.model.Person;
import com.ksm.monolith.repository.BelongingRepository;
import com.ksm.monolith.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author loisceka
 */
@Service
public class PersonService {
    @Autowired //dependency injection 
    PersonRepository personRepository;
    @Autowired
    BelongingRepository belongingRepository;

    //Create
    public boolean save(Person person) {
        Person p = personRepository.save(person);
        return personRepository.existsById(p.getId());
    }

    //Read All
    public List<Person> getAllPerson() {
        List<Person> people = personRepository.findAll();
        return people;
    }
    //Insert Data Awal
    public void dummyData() {
        List<Person> people = new ArrayList<>();
        
        people.add(new Person("Kevin", "Harlim", "Male"));
        people.add(new Person("Lois", "Ceka", "Male"));
        people.add(new Person("Artour", "Babaev", "Male")); 
        personRepository.saveAll(people);
    }
    //Insert Data
    public Person insertData(Person person) {
        if (person.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data already exists");
        }
        return personRepository.save(person);
    }
    
    //Read -> getById(Integer id) -> findById(id)
    public Person getById(Integer id){
        if (personRepository.existsById(id)) {
            return personRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data");
    }

    //Update -> update(Integer id) -> 1 Kevin Harlim
    public Person update(Integer id, Person person){
        Person oldPerson = getById(id);
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setGender(person.getGender());

         return personRepository.save(oldPerson);
    } 
    //Delete -> deleteById(Integer id)
    public Person deleteById(Integer id){
        Person person = getById(id);
        personRepository.delete(person);
        return person;
    }
    //Adding Person and Belongings
    public Person givePencilAndEraserToNewPerson(Belonging belonging){
        Person person = getById(belonging.getId());
        List<Belonging> belongings = new ArrayList<>();
        belongings.add(new Belonging(belonging.getName(), belonging.getQuantity(), person));
        List<Belonging> insertedBelongings = belongingRepository.saveAll(belongings);
        person.setBelongings(insertedBelongings);
        personRepository.save(person);
        return person;
    }
    /*
    //Find All Female 
    public List<Person> getFemales(){
        return personRepository.findAllFemales();
    }
    */
}
