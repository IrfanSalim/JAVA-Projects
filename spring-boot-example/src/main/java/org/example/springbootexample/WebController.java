package org.example.springbootexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/api/v1/customers")
public class WebController {

    @GetMapping("/add")
    public String add(Model model) {
        return "index"; // This will look for a file named index.html in src/main/resources/templates
    }

    @GetMapping("/update")
    public String update(Model model) {
        return "updateCustomer"; // This will look for a file named updateCustomer.html in src/main/resources/templates
    }
}
