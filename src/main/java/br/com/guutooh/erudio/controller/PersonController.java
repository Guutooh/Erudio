package br.com.guutooh.erudio.controller;

import br.com.guutooh.erudio.model.Person;
import br.com.guutooh.erudio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServices service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<Person>  findAll() {
        return service.findAll();
    }



}
