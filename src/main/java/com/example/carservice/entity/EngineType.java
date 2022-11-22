package com.example.carservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "engine_type", schema="shop")
@Getter
@Setter
@NoArgsConstructor
public class EngineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String engineTypeName;

    private int engineVolume;

    private int enginePower;



}
