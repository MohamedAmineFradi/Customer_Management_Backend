package com.example.DAO;

import com.example.entity.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {


   Optional<CustomerEntity> findById(Integer integer);

   List<CustomerEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String searchKey, String searchKey1, String searchKey2);

   List<CustomerEntity> findAll(Specification<CustomerEntity> specification);
}
