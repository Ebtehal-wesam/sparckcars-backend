package com.example.sparkcars.Car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
@Configuration
public class CarConfig {
    @Bean
    CommandLineRunner commandLineRunner(CarRepository repositry){
        return args -> {
            Car camry = new Car("camry","toyota","japan","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTt4A-aGYEMv3-LMjjn_yI6UWxJal4vLsIEKQ&s","white");
            Car xr  = new Car("xr","merceds","germany","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTt4A-aGYEMv3-LMjjn_yI6UWxJal4vLsIEKQ&s","brown");

            repositry.saveAll(
                    List.of(camry,xr)
            );

        };
    }
}
