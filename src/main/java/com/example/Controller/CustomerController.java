package com.example.stage2023;


import com.example.Spec.CustomerSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private  CustomerRepository customerRepository  ;


    @GetMapping("/customerslist")
    public List<CustomerEntity> list(@RequestParam(value = "customerId", required = false)Integer id,@RequestParam(value = "firstName",required = false)String firstname,@RequestParam(value = "lastName",required = false)String lastName,@RequestParam(value = "email",required = false)String email){
        Specification<CustomerEntity> specification = CustomerSpec.getSpec(id,firstname,lastName,email);
        return customerRepository.findAll(specification);
    }

//    @GetMapping("/customers")
//    public CustomerEntity searchByID(@RequestParam(name = "id", defaultValue = "1") Integer id){
//        if( customerRepository.findById(id).isPresent() ) {
//
//            return customerRepository.findById(id).get();
//        }
//        return null;
//    }
}
