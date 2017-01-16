package com.catho.opportunity.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
@SpringBootApplication
@ComponentScan({"com.catho.opportunity.configuration", "com.catho.opportunity.resource", "com.catho.opportunity.services", "com.catho.opportunity.provider"})
public class Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

}