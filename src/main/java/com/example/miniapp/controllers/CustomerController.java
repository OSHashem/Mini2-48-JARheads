package com.example.miniapp.controllers;

import com.example.miniapp.models.Customer;
import com.example.miniapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

// RESTful endpoint methods...

    //    Post request to add a new customer.
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {

        return customerService.addCustomer(customer);
    }

    //    Get request to retrieve all customers.
    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    //    Get request to retrieve a customer by ID.
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {

        return customerService.getCustomerById(id);
    }

    //    Put request to update customer information.
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

        return customerService.updateCustomer(id, customer);
    }

    //    Delete request to remove a customer.
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);
        return "Customer with ID " + id + " has been deleted.";
    }

    //    Get request to retrieve customers whose email address ends with a specific domain.
    @GetMapping("/findByEmailDomain")
    public List<Customer> findCustomersByEmailDomain(@RequestParam String domain) {

        return customerService.findCustomersByEmailDomain(domain);
    }

    //    Get request to retrieve customers whose phone number starts with a specific prefix.
    @GetMapping("/findByPhonePrefix")
    public List<Customer> findCustomersByPhonePrefix(@RequestParam String prefix) {

        return customerService.findCustomersByPhonePrefix(prefix);
    }
}
