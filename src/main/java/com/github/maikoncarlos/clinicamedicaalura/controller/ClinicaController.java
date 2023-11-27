package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/clinica-voll")
public class ClinicaController {

    @PostMapping(value = "medicos")
    public void cadastrarMedicos(@RequestBody DadosCadastroMedicoRequest dadosMedico){
        System.out.println(dadosMedico);
    }
    @PostMapping(value = "pacientes")
    public void cadastrarPacientes(@RequestBody DadosCadastroPacienteRequest dadosPaciente){
        System.out.println(dadosPaciente);
    }
}
