package sg.edu.nus.iss.ssf_13l.repository;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.ssf_13l.model.Person;

@Repository
public class PersonRepository {
    private final List<Person> persons;
    private static final File db = new File("src/main/resources/db/persons.csv");
    
    
    public PersonRepository() {
        this.persons = new ArrayList<>();
        persons.add(new Person("Abigail", "Holiday", LocalDate.now(), 2000, "abiday@gmail.com"));
        persons.add(new Person("Lawrence", "Teo", LocalDate.now(), 5000, "lawteo@gmail.com"));

        // try (BufferedReader in = new BufferedReader(new FileReader(db))) {
        //     String line = "";
        //     while ((line = in.readLine()) != null) {
        //         String[] values = line.split(",");
        //         LocalDate.
        //         persons.add(new Person(values[0], values[1], dob, Integer.parseInt(values[3]), values[4]));
        //     }
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
    }

    public List<Person> getAllPersons() {
        return persons;
    }

    public boolean create(Person person) {
        return persons.add(person);
    }

    public boolean delete(Person person) {
        return persons.remove(person);
    }

    public boolean update(Person person) {
        Optional<Person> optPerson = persons.stream()
            .filter(p -> p.getId().equals(person.getId()))
            .findFirst();
        delete(optPerson.orElse(person));
        create(person);
        return true;
    }

    public Person findById(String id) {
        Optional<Person> person = persons.stream().filter(p -> p.getId().equals(id)).findFirst();
        System.out.println(person.isPresent());
        return persons.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }
}
