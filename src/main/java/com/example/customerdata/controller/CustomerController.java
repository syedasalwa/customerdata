package com.example.customerdata.controller;


import com.example.customerdata.model.Customer;
import com.example.customerdata.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Void> updated(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteByCustomerId")
    public ResponseEntity<Void> deleteByCustomerId(@RequestParam Long id) {
        customerService.deleteByCustomerId(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<Customer>> listAll () {
        List<Customer> allCustomers = customerService.listAll();
        return ResponseEntity.ok(allCustomer);
}
        @GetMapping("/customerName")
    private List<Customer> getByCustomerName(@RequestParam String firstLetter){
        return customerService.getByCustomerName(firstLetter);
    }
}
