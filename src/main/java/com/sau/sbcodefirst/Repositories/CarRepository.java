package com.sau.sbcodefirst.Repositories;

import com.sau.sbcodefirst.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
