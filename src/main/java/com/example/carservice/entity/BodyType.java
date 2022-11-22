package com.example.carservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "body_type", schema="shop")
@Getter
@Setter
@NoArgsConstructor
public class BodyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String bodyTypeName;

    public BodyType(String bodyTypeName) {
        this.bodyTypeName = bodyTypeName;
    }
}
