package com.sau.sbcodefirst.Repositories;

import com.sau.sbcodefirst.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
