package com.example.DAO.db1;

import com.example.model.Customer;
import com.example.model.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<Customer> searchCustomers(SearchCriteria criteria);

}
