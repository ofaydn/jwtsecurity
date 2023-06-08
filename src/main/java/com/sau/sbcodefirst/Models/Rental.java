package com.sau.sbcodefirst.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="rent_date")
    private Date rentDate;
    @Column(name="return_date")
    private Date returnDate;
    @Column(name="is_returned", columnDefinition = "boolean default false")
    private boolean isReturned;
    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;
}

