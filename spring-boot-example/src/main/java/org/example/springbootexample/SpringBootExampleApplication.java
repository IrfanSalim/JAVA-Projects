package org.example.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class SpringBootExampleApplication {

    private final CustomerRepository customerRepository;

    public SpringBootExampleApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }

    @GetMapping("/greet")
    public String greet() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(String name, String email, Integer age) {

    }

    @PostMapping()
    public Customer addCustomer(@RequestBody NewCustomerRequest customer) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customer.name());
        newCustomer.setEmail(customer.email());
        newCustomer.setAge(customer.age());
        return customerRepository.save(newCustomer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") Integer id, @RequestBody NewCustomerRequest updateDetails) {
        return customerRepository.findById(id).map(customer -> {
            if (updateDetails.name() != null) {
                customer.setName(updateDetails.name());
            }
            if (updateDetails.email() != null) {
                customer.setEmail(updateDetails.email());
            }
            if (updateDetails.age() != null) {
                customer.setAge(updateDetails.age());
            }
            return customerRepository.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        customerRepository.deleteById(id);
    }

}
