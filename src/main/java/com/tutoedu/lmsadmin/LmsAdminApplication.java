package com.tutoedu.lmsadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LmsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsAdminApplication.class, args);
    }

}
