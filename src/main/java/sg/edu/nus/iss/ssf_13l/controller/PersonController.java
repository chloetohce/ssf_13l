package sg.edu.nus.iss.ssf_13l.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.ssf_13l.model.Person;
import sg.edu.nus.iss.ssf_13l.service.PersonService;


@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String persons(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "persons";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "person-create";
    }
    
    @PostMapping("/create")
    public String postCreateForm(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "person-create";
        }
        Person p = new Person(person.getFirstName(),person.getLastName(),person.getDob(),person.getSalary(),person.getEmail(), person.getPhone(), person.getPostalCode());
        personService.create(p);
        return "redirect:/persons";
    }
    
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") String id) {
        personService.delete(personService.findById(id));
        return "redirect:/persons";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") String id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "person-update";
    }
    
    @PostMapping("/update")
    public String postMethodName(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "person-update";
        }
        personService.update(person);
        return "redirect:/persons";
    }
    
    
    
}
