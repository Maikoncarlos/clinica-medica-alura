package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import com.github.maikoncarlos.clinicamedicaalura.service.MedicoService;
import com.github.maikoncarlos.clinicamedicaalura.service.PacienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/clinica-voll")
@AllArgsConstructor
public class ClinicaController {

    private MedicoService medicoService;
    private PacienteService pacienteService;

    @PostMapping(value = "medicos")
    @Transactional
    public void cadastrarMedicos(@RequestBody @Valid DadosCadastroMedicoRequest dadosMedico){
       medicoService.cadastrar(dadosMedico);

    }
    @PostMapping(value = "pacientes")
    @Transactional
    public void cadastrarPacientes(@RequestBody @Valid DadosCadastroPacienteRequest dadosPaciente){
        pacienteService.cadastrar(dadosPaciente);
    }
}
