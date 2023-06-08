package com.sau.sbcodefirst.Controllers;

import com.sau.sbcodefirst.Models.Customer;
import com.sau.sbcodefirst.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/customer")
    public String getIndex(Model model){
        Iterable<Customer> customerList = customerRepository.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/index";
    }

    @GetMapping("/customer/add")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/customer/addcustomer";
    }
    @PostMapping("customer/add")
    public String customerAdd(Customer customer){
        if(customer == null) {
            System.out.println("Customer is null");
            return "redirect:/customer";
        }
        customerRepository.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/customer/del")
    public String deleteCustomer(@RequestParam("id") int id, Model model){
        Optional<Customer> customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/delcustomer";
    }
    @PostMapping("/customer/del")
    public String customerDelete(Customer customer){
        if(customer == null) {
            System.out.println("Customer is null");
            return "redirect:/customer";
        }
        customerRepository.delete(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/update")
    public String updateCustomer(@RequestParam("id") int id, Model model){
        Optional<Customer> customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/updatecustomer";
    }
    @PostMapping("/customer/update")
    public String customerUpdate(Customer customer){
        if(customer == null) {
            System.out.println("Customer is null");
            return "redirect:/customer";
        }
        customerRepository.save(customer);
        return "redirect:/customer";
    }
}
