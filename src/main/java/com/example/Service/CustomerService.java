package com.example.Service;

import com.example.DAO.db1.CustomerMapper;
import com.example.DAO.db1.CustomerRepository;
import com.example.model.Customer;
import com.example.model.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerMapper customerMapper;
    @Autowired
    public CustomerService( @Qualifier("customerMapper") CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }
    @Autowired
    CustomerRepository customerRepository  ;


    @Transactional("customerTransactionManager")
    public Customer add(Customer customer) {
        customerRepository.save(customer);

        return customer;
    }

    @Transactional("customerTransactionManager")
    public List<Customer> getALL(){
        return customerRepository.findAll();

    }

    @Transactional("customerTransactionManager")
    @PostMapping("/searchcustomers")
    public List<Customer> searchCustomer(SearchCriteria searchCriteria) {

         return  customerMapper.searchCustomers(searchCriteria);

    }


    public static String throwException() {
    throw new IllegalStateException();
    }
}
