package br.com.guutooh.erudio.service;

import br.com.guutooh.erudio.controller.PersonController;
import br.com.guutooh.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {


    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonController.class.getName());

    public Person findById(String id) {
        logger.info("Finding person with id: " + id);

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Gustavo");
        person.setLastName("Santos");
        person.setAddress("São paulo");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll(){

        List<Person> persons =  new ArrayList<Person>();

        for (int i = 1; i <= 10 ; i++) {

            Person person = mockPerson(i);

            persons.add(person);
        }

        return persons;
    }

    public Person create(Person person) {

        logger.info("Creating one Person!");

        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id) {

        logger.info("Deleting one Person!");

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
