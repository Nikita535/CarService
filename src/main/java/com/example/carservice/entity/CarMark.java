package com.example.carservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "car_mark", schema="shop")
@Getter
@Setter
@NoArgsConstructor
public class CarMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String mark;
    private String series;

    public CarMark(String mark, String series) {
        this.mark = mark;
        this.series = series;
    }
}
