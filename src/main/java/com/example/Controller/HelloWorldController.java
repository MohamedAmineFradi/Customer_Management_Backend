package com.example.Controller;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
   // Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/helloworld")
    public String helloWorld(){
      //  logger.debug("Request : getting to  {}", "hello world" );
        String response = "Hello World" ;
     //   logger.debug("Response {}",response);

        return response ;
    }
    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
      //  logger.debug("Request : getting to  {}", "Hello " + name );
        String response = "Hello " + name ;
      //  logger.debug("Response {}",response);

        return response ;
    }
    @RequestMapping("/goodbye")
    public String goodbye(){
       // logger.debug("Request : getting to  {}", "Good bye" );
        String response =  "Goodbye " ;
      //  logger.debug("Response {}",response);

        return response ;


    }
}
