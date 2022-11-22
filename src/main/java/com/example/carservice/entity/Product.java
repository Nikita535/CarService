package com.example.carservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product", schema="shop")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String model;

    private String color;

    private int price;

    private String availability;

    @OneToOne(targetEntity = CarMark.class,fetch = FetchType.EAGER)
    private CarMark carMark;

    @OneToOne(targetEntity = TechnicalDetails.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private TechnicalDetails technicalDetails;

    @OneToOne(targetEntity = Manufacture.class,fetch = FetchType.EAGER)
    private Manufacture manufacture;

}
