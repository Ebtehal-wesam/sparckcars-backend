package com.example.sparkcars.Car;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carrepository ;
    @Autowired
    public CarService(CarRepository carrepository) {
        this.carrepository = carrepository;
    }


    public List<Car> getCars(){
        return carrepository.findAll();
//        return  List.of(
//                new Student(1L,"ebtehal","ebtehal@gmail.com",
//                        LocalDate.of(2000,1,16),24));
    }
    public Car getCarById(Long id) {
        Optional<Car> optionalcar = carrepository.findById(id);

        if (optionalcar.isPresent()) {
            return optionalcar.get();
        } else {
            throw new IllegalStateException("car not found with ID: " + id);
        }
    }

    public Car findCarById(Long id){
        return carrepository.findCarById(id).orElseThrow(() -> new CarNotFoundExcption("cant find this car "));
    }
    public void addNewCar(Car car) {
//
        carrepository.save(car);
    }

    public void deleteCar(Long carid) {
        boolean b = carrepository.existsById(carid);
        if (!b){
            throw new IllegalStateException("car not exist : "+carid);
        }else {
            carrepository.deleteById(carid);
        }
    }
    @Transactional
    public Car updateCar(Car car) {
        return carrepository.save(car);
//        Car car = carrepository.findById(carid).
//                orElseThrow( () -> new IllegalStateException("" +
//                        "car doesnt exist to update "));
//
//        if (name != null && name.length() > 0 && !Objects.equals(car.getName(), name )){
//            car.setName(name);
//
//        }
//        if (model != null && model.length() > 0 && !Objects.equals(car.getModel(), model )){
//            car.setModel(model);
//
//        }
//        if (company != null && company.length() > 0 && !Objects.equals(car.getCompany(), company )){
//            car.setCompany(company);
//
//        }

    }
}
