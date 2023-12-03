package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = "com.example.model") // Replace with the actual package of Customer entity
public class Stage2023Application implements CommandLineRunner, WebMvcConfigurer {
    //@Autowired
   // private ErrorConfig x ;


    public static void main(String[] args) {


        SpringApplication.run(Stage2023Application.class, args);

    }

    @Override
    public void run(String... args)throws Exception{
       // System.out.println(x.getEr01Code() );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }
}
