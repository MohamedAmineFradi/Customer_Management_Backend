package com.example.Controller;

import com.example.Service.CustomerService;
import com.example.model.Customer;
import com.example.model.SearchCriteria;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService  ;



    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        try {
            Customer customer1 = customerService.add(customer);
            System.out.println(customer);
            return new ResponseEntity<>(customer1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @GetMapping("/customersList")
    public List<Customer> allCustomers(){
            return customerService.getALL();
    }


    @PostMapping("/searchcustomers")
    public ResponseEntity<?> searchCustomer(@RequestBody  SearchCriteria searchCriteria) {

        System.out.println(searchCriteria);

        List<Customer> customers = customerService.searchCustomer(searchCriteria);
        System.out.println(customers);
        if(customers.isEmpty()){
            throw new EntityNotFoundException();
        }

        return  new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
        }






    @Transactional("customerTransactionManager")
    @GetMapping("/error")
    public ResponseEntity<?> throwException(){

        return ResponseEntity.ok(CustomerService.throwException());
    }


//
//    @Transactional("customerTransactionManager")
//    @GetMapping("/searchCustomerslist")
//    public List<Customer> list(@RequestParam(value = "customerId", required = false)Integer id, @RequestParam(value = "firstName",required = false)String firstname, @RequestParam(value = "lastName",required = false)String lastName, @RequestParam(value = "email",required = false)String email){
//        Specification<Customer> specification = CustomerSpec.getSpec(id,firstname,lastName,email);
//        return customerRepository.findAll(specification);
//    }

}
