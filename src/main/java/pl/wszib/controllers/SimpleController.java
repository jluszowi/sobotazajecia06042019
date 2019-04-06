package pl.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private List<Person> listPerson;

    public SimpleController() {
        listPerson = generateList();
    }

    @GetMapping("basic")
    public String basic(Model model) {

        String firstName = "Jan";
        String lastName = "Kowalski";
        model.addAttribute("fName", firstName);
        model.addAttribute("lName", lastName);

        Person person = new Person();
        person.setFirstName("Jacek");
        person.setLastName("Nowak");
        person.setPhoneNumber("43534545");
        person.setSalary(1000.00);
        person.setVisible(true);

        model.addAttribute("person", person);

        return "basicTemplate";

    }
    @GetMapping("iteration")
    public String iteration(Model model) {
   /*List<Person> list = generateList();*/        //do drugiego zadania usuwamy te linijki
        model.addAttribute("list", listPerson);
        return "iterationTemplate";
    }

    @GetMapping("links")
    public String links(Model model) {
        return "linksTemplate";
    }

    @GetMapping("inter")
    public String inter(Model model) {
        return "interTemplate";
    }

    @GetMapping("forms")
    public String forms(Model model) {
        model.addAttribute("person", new Person());
        return "formsTemplate";
    }

    @PostMapping("formsSave")
    public String formSave(Person person, Model model) {

        listPerson.add(person);
        return "successTemplate";

    }

    private List<Person> generateList() {
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("Jan");
        person1.setLastName("Nowak");
        person1.setPhoneNumber("7775345");
        person1.setSalary(1099.00);
        person1.setVisible(true);
        list.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Karolina");
        person2.setLastName("Kotek");
        person2.setPhoneNumber("4965585");
        person2.setSalary(2400.00);
        person2.setVisible(false);
        list.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Krzyś");
        person3.setLastName("Jakiś");
        person3.setPhoneNumber("998877");
        person3.setSalary(1025.00);
        person3.setVisible(true);
        list.add(person3);

        return list;
    }


    @GetMapping("fragments")
    public String fragments(Model model) {
        return "fragments/fragmentsTemplate";
    }

    @GetMapping("fragmentsT")
    public String fragmentsT(Model model) {
        return "fragmentsTemplateT";
    }


}
