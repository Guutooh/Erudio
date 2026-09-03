package br.com.guutooh.erudio.service;

import br.com.guutooh.erudio.controller.PersonController;
import br.com.guutooh.erudio.exception.ResourceNotFoundException;
import br.com.guutooh.erudio.model.Person;
import br.com.guutooh.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {


    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonController.class.getName());

    public Person findById(Long id) {

        logger.info("Finding person with id: " + id);

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this id: " + id));
    }

    public List<Person> findAll() {

        logger.info("Finding all persons");

        return repository.findAll();
    }

    public Person create(Person person) {

        logger.info("Creating one Person!");

        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");

        Person entity = findById(person.getId());

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!" + id);

        findById(id);
        repository.deleteById(id);

    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Some Address in Brazil");
        person.setGender("Male");

        return person;
    }

}
