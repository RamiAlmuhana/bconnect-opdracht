package com.rami.bconnectopdrachtbackend.controller;

import com.rami.bconnectopdrachtbackend.dto.CompanyDTO;
import com.rami.bconnectopdrachtbackend.model.Company;
import com.rami.bconnectopdrachtbackend.dao.CompanyRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    @PostMapping
    public ResponseEntity<?> saveCompany(@Valid @RequestBody CompanyDTO dto) {
        Company company = new Company();
        company.setCompanyName(dto.getCompanyName());
        company.setTelephoneNumber(dto.getTelephoneNumber());
        company.setEmployees(dto.getEmployees());
        company.setCoCNumber(dto.getCoCNumber());
        company.setVatNumber(dto.getVatNumber());
        company.setIbanNumber(dto.getIbanNumber());
        company.setBudget(dto.getBudget());
        company.setDescription(dto.getDescription());

        Company saved = companyRepository.save(company);
        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(companyRepository.findAll());
    }
}
