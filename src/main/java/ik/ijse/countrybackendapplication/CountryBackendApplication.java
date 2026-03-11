package ik.ijse.countrybackendapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CountryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryBackendApplication.class, args);
    }

}
