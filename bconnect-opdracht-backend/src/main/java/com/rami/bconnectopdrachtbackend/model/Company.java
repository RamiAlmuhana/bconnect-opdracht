package com.rami.bconnectopdrachtbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String telephoneNumber;
    private String employees;
    private String coCNumber;
    private String vatNumber;
    private String ibanNumber;
    private Integer budget;

    @Column(length = 1000)
    private String description;
}
