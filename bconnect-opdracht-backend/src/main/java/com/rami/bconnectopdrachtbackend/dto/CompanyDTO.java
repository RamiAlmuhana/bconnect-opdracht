package com.rami.bconnectopdrachtbackend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CompanyDTO {

    @NotBlank(message = "Company name is required.")
    private String companyName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Telefoonnummer moet uit 10 cijfers bestaan.")
    private String telephoneNumber;

    @NotBlank(message = "Employees field is required.")
    private String employees;

    @Pattern(regexp = "^[0-9]{8,12}$", message = "Ongeldig KvK-nummer.")
    private String coCNumber;

    @Pattern(regexp = "^[0-9]{9}B0[0-9]{1,2}$", message = "Ongeldig BTW-nummer.")
    private String vatNumber;

    @Pattern(regexp = "^NL\\d{2}[A-Z]{4}\\d{10}$", message = "Ongeldig IBAN.")
    private String ibanNumber;

    private Integer budget;

    @Size(max = 1000, message = "Description mag maximaal 1000 tekens bevatten.")
    private String description;
}
