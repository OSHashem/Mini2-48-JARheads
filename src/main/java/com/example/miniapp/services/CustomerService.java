package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

// Business logic methods here...

    //To add a new customer to the system.
    public Customer addCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    //    To retrieve all customers.
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    //    To retrieve a specific customer by their ID.
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    //    To update a customer’s information.
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        // If you want to update trips too, handle that here
        return customerRepository.save(existingCustomer);
    }

    //    To delete a customer record from the system.
    public void deleteCustomer(Long id) {

        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    //    To retrieve all customers whose email addresses end with a specific domain.
    public List<Customer> findCustomersByEmailDomain(String domain) {

        return customerRepository.findByEmailDomain(domain);
    }

    //    To retrieve all customers whose phone numbers start with a specific prefix.
    public List<Customer> findCustomersByPhonePrefix(String prefix) {

        return customerRepository.findByPhonePrefix(prefix);
    }
}