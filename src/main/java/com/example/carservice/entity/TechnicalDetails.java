package com.example.carservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "technical_details", schema = "shop")
@Getter
@Setter
@NoArgsConstructor
public class TechnicalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int doorsNumber;

    private int seatsNumber;

    @OneToOne(targetEntity = EngineType.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private EngineType engineType;

    @OneToOne(targetEntity = EngineLayoutType.class, fetch = FetchType.EAGER)
    private EngineLayoutType engineLayoutType;

    @OneToOne(targetEntity = BodyType.class, fetch = FetchType.EAGER)
    private BodyType bodyType;


}
