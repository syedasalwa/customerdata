package com.example.customerdata.service;

import com.example.customerdata.model.Customer;
import com.example.customerdata.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public void save(Customer customer) {
        customerRepo.save(customer);
    }
    public void deleteByCustomerId(Long customerId) {
        customerRepo.deleteById(customerId);

    }
    public List<Customer> listAll() {
        List<Customer> allCustomer = customerRepo.findAll();
        return allCustomer;
    }
    public Customer getByCustomerId(Long customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(new Customer());
        return customer;
    }
    public List<Customer> getByCustomerName(String name) {
        return customerRepo.findByNameStartingWith(name);
    }
}

