package com.iphayao.demo.customer;


import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableRedisRepositories
public interface CustomerRepository extends CrudRepository<Customer, String> {
    List<Customer> findByFirstName(String firstName);
}
