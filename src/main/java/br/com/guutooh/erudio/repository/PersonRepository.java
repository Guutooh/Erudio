package br.com.guutooh.erudio.repository;

import br.com.guutooh.erudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
