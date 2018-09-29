package com.iphayao.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = customerService.retrieveCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getCustomers(@RequestParam String name) {
        List<Customer> customers = customerService.retrieveCustomersByName(name);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        Optional<?> customer = customerService.retrieveCustomers(id);
        if(!customer.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping()
    public ResponseEntity<?> postCustomers(@RequestBody Customer body) {
        Customer customer = customerService.createCustomer(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCustomers(@PathVariable String id, @RequestBody Customer body) {
        Optional<?> customer = customerService.updateCustomer(id, body);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable String id) {
        if(!customerService.deleteCustomer(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
