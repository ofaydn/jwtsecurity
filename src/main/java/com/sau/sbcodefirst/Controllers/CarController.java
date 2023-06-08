package com.sau.sbcodefirst.Controllers;

import com.sau.sbcodefirst.Models.Car;
import com.sau.sbcodefirst.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @GetMapping("/car")
    public String getIndex(Model model){
        Iterable<Car> carList = carRepository.findAll();
        model.addAttribute("carList", carList);
        return "car/index";
    }
    @GetMapping("/car/add")
    public String addCar(Model model){
        Car c = new Car();
        model.addAttribute("car", c);
        return "/car/addcar";
    }
    @PostMapping("car/add")
    public String carAdd(Car car){
        if(car == null) {
            System.out.println("Car is null");
            return "redirect:/car";
        }
        carRepository.save(car);
        return "redirect:/car";
    }
    @GetMapping("/car/del")
    public String deleteCar(@RequestParam("id") int id, Model model){
        Optional<Car> c = carRepository.findById(id);
        model.addAttribute("car", c);
        return "/car/delcar";
    }
    @PostMapping("/car/del")
    public String carDelete(Car car){
        if(car == null) {
            System.out.println("Car is null");
            return "redirect:/car";
        }
        carRepository.delete(car);
        return "redirect:/car";
    }

    @GetMapping("/car/update")
    public String updateCar(@RequestParam("id") int id, Model model){
        Optional<Car> c = carRepository.findById(id);
        model.addAttribute("car", c);
        return "/car/updatecar";
    }
    @PostMapping("/car/update")
    public String carUpdate(Car car){
        if(car == null) {
            System.out.println("Car is null");
            return "redirect:/car";
        }
        carRepository.save(car);
        return "redirect:/car";
    }
}
