package com.example.sparkcars.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
@EnableWebMvc
public class CarController {
    private final CarService carservice ;
    @Autowired
    public CarController(CarService carservice) {
        this.carservice = carservice;
        // Autowired // this.studentservice = new StudentService //
    }
    @GetMapping("/all")
    public List<Car> getStudents(){
        return carservice.getCars();
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        try {
            // 1. Call the student service to retrieve the student by ID
            Car car = carservice.getCarById(id);
            // 2. Return the student resource with a 200 OK status
            return ResponseEntity.ok(car);
        } catch (IllegalStateException e) {
            // 3. Handle the case where the student is not found
            return ResponseEntity.notFound().build();
        }
//        catch (Exception e) {
//            // 4. Handle any other exceptions that may occur
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ErrorResponse("Error retrieving student", e.getMessage()));
//        }
    }
    @PostMapping("/add")
    public void registerNewCar(@RequestBody Car car){
        carservice.addNewCar(car);
    }

    @DeleteMapping(path= "/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long carid){
        carservice.deleteCar(carid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path= "/find/{id}")
    public ResponseEntity<Car> getCarByID(@PathVariable("id") Long carid){
       Car car = carservice.findCarById(carid);
       return new ResponseEntity<>(car, HttpStatus.OK);
    }
    ///  String name, String model, String company
    @PutMapping(path="/update")
    public  ResponseEntity<Car> updateCar( @RequestBody Car car
    ){
        Car updatecar = carservice.updateCar(car);
        return new ResponseEntity<>(updatecar, HttpStatus.OK);

    }
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
//        Employee updateEmployee = employeeService.updateEmployee(employee);
//        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
//    }


}
