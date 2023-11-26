package com.github.maikoncarlos.clinicamedicaalura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/clinica")
public class ClinicaController {

    @GetMapping
    public String clinicaTeste(){
        return "teste projeto";
    }
}
