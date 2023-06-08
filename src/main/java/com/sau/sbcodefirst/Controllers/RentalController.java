package com.sau.sbcodefirst.Controllers;

import com.sau.sbcodefirst.Models.Rental;
import com.sau.sbcodefirst.Repositories.CarRepository;
import com.sau.sbcodefirst.Repositories.CustomerRepository;
import com.sau.sbcodefirst.Repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RentalController {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/rental")
    public String getIndex(Model model){
        Iterable<Rental> rentalList = rentalRepository.getAll();
        model.addAttribute("rentalList", rentalList);
        return "rental/index";
    }
    @PostMapping("/rental/del")
    public String rentalDelete(Rental rental){
        if(rental == null) {
            System.out.println("Rental is null");
            return "redirect:/rental";
        }
        rentalRepository.setDeleted(rental.getId());
        return "redirect:/rental";
    }
    @PostMapping("/rental/ret")
    public String rentalReturn(Rental rental){
        if(rental == null) {
            System.out.println("Rental is null");
            return "redirect:/rental";
        }
        rentalRepository.setReturned(rental.getId());
        return "redirect:/rental";
    }
}
