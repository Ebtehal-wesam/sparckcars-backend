package com.example.sparkcars.Car;

import jakarta.persistence.*;

@Entity(name="car")
@Table
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence", // nique name for the sequence generator that can be referenced by the @GeneratedValue annotation.
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id ;
    private String name;
    private String company ;
    private String country;
    private String model ;
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", country='" + country + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Car() {
    }

    public Car(String name, String company, String country, String model, String color) {
        this.name = name;
        this.company = company;
        this.country = country;
        this.model = model;
        this.color = color;
    }

    public Car(Long id, String name, String company, String country, String model, String color) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.country = country;
        this.model = model;
        this.color = color;
    }
}
