package br.com.guutooh.erudio.controller;

import br.com.guutooh.erudio.model.Person;
import br.com.guutooh.erudio.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServices service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<Person> findAll() {
        return service.findAll();
    }


    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
