package com.example.Controller;

import com.example.DAO.db2.UserRepository;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository ;

//    @Transactional("userTransactionManager")
    @PostMapping("/addUser")
    public ResponseEntity<User> addCustomer(@RequestBody User user){

       // try {
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

}
