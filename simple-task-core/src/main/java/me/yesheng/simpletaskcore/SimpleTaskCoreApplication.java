package me.yesheng.simpletaskcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SimpleTaskCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleTaskCoreApplication.class, args);
    }

}
