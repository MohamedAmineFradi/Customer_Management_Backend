package com.example.Spec;

import com.example.model.Customer;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomerSpec {

    public static Specification<Customer> getSpec(Integer id, String firstname, String lastname, String email){
        return ((root, query, criteriaBuilder) ->{
            List<Predicate> predicate = new ArrayList<>();
            if(id !=null ){
                predicate.add(criteriaBuilder.equal(root.get("customerId"),id));

            }
            if(firstname !=null && !(firstname.isEmpty()) ){
                predicate.add(criteriaBuilder.equal(root.get("firstName"),firstname));

            }
            if(lastname !=null  && !(lastname.isEmpty())){
                predicate.add(criteriaBuilder.equal(root.get("lastName"),lastname));

            }
            if(email !=null  && !(email.isEmpty())){
                predicate.add(criteriaBuilder.equal(root.get("email"),email));
            }
            return criteriaBuilder.and(predicate.toArray(new  Predicate[0]));
        } );
    }
}
