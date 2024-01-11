package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.DadosMedicoResumido;
import com.github.maikoncarlos.clinicamedicaalura.service.MedicoService;
import com.github.maikoncarlos.clinicamedicaalura.service.PacienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/clinica-voll")
@AllArgsConstructor
public class ClinicaController {

    private MedicoService medicoService;
    private PacienteService pacienteService;

    @PostMapping(value = "medicos")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarMedicos(@RequestBody @Valid DadosCadastroMedicoRequest dadosMedico){
       medicoService.cadastrar(dadosMedico);

    }
    @PostMapping(value = "pacientes")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPacientes(@RequestBody @Valid DadosCadastroPacienteRequest dadosPaciente){
        pacienteService.cadastrar(dadosPaciente);
    }

    @GetMapping(value = "medicos/listAll")
    public Page<DadosMedicoResumido> listAll(@PageableDefault(size = 5, sort = "nome") Pageable paginacao){
        return medicoService.findAll(paginacao);

    }

}
