package sg.edu.nus.iss.ssf_13l.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.ssf_13l.model.Person;
import sg.edu.nus.iss.ssf_13l.repository.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    public boolean create(Person person) {
        return personRepository.create(person);
    }

    public boolean delete(Person person) {
        return personRepository.delete(person);
    }

    public boolean update(Person person) {
        return personRepository.update(person);
    }

    public Person findById(String id) {
        return personRepository.findById(id);
    }
}
