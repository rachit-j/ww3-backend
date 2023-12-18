package com.nighthawk.spring_portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/people")
    public String showPeople(Model model) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "Engineer"),
            new Person("Bob", 25, "Designer"),
            new Person("Charlie", 35, "Manager")
        );

        model.addAttribute("peopleList", people);
        return "people";
    }
}
