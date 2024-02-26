package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Cliente cliente;

    @Column
    @Getter
    @Setter
    private Integer cantidad;

    @Column
    @Getter
    @Setter
    private Date fecha;
}
