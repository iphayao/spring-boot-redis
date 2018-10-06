package com.iphayao.demo.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


import java.util.List;

@EnableRedisRepositories
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByFirstName(String firstName);
}
