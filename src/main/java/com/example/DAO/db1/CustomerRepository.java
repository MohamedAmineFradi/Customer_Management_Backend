package com.example.DAO.db1;

import com.example.model.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    Optional<Customer> findById(Integer integer);

   List<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String searchKey, String searchKey1, String searchKey2);


   List<Customer> findAll(Specification<Customer> specification);
}
