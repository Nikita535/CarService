package com.example.carservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "engine_layout_type", schema="shop")
@Getter
@Setter
@NoArgsConstructor
public class EngineLayoutType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String engineLayoutTypeName;

    public EngineLayoutType(String engineLayoutTypeName) {
        this.engineLayoutTypeName = engineLayoutTypeName;
    }
}
