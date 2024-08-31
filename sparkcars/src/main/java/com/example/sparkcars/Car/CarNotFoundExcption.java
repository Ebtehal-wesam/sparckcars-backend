package com.example.sparkcars.Car;

public class CarNotFoundExcption extends RuntimeException {
    public CarNotFoundExcption(String message) {
        super(message);
    }
}
