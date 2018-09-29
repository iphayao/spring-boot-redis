package com.iphayao.demo.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotNull;

@Data
@RedisHash("customer")
public class Customer {
    @Id
    private String id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer age;
    @NotNull
    private String email;
}
