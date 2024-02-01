package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosAtualizacaoPaciente;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.DadosPacientesResumido;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.paciente.DadosDetalhadosPaciente;
import com.github.maikoncarlos.clinicamedicaalura.service.PacienteService;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "v1/clinica-voll/pacientes")
@AllArgsConstructor
public class PacienteController {

    private PacienteService pacienteService;
    private ClinicaMapper mapper;


    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosPaciente> cadastrarPacientes(@RequestBody @Valid DadosCadastroPacienteRequest dadosPaciente, UriComponentsBuilder uriComponentsBuilder){
        DadosDetalhadosPaciente pacienteSalvo = pacienteService.cadastrar(dadosPaciente);
        URI location = uriComponentsBuilder.
                path("v1/clinica-voll/pacientes/{id}").
                buildAndExpand(pacienteSalvo.id()).
                toUri();

        return ResponseEntity.created(location).body(pacienteSalvo);
    }

    @GetMapping(value = "{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadosPaciente> buscarPacientePorId(@PathVariable("id") Long id){
        var paciente = pacienteService.getPacientePorId(id);
        DadosDetalhadosPaciente pacientePertencenteAoId = mapper.toDadosDetalhadosPacientes(paciente);

        return ResponseEntity.ok().body(pacientePertencenteAoId);
    }

    @GetMapping(value = "listaPaginada")
    public ResponseEntity<Page<DadosPacientesResumido>> listarTodosPacientesPaginados(@PageableDefault(size = 5, sort = "nome") Pageable paginacao){
        Page<DadosPacientesResumido> pacientesPaginados = pacienteService.findAllAtivos(paginacao);

        return ResponseEntity.ok(pacientesPaginados);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosPaciente> atualizarDadosPacientes(@RequestBody @Valid DadosAtualizacaoPaciente dadosAtualizacaoPaciente){
        var paciente = pacienteService.getPacientePorId(dadosAtualizacaoPaciente.id());
        paciente.atualizarDadosMedicos(dadosAtualizacaoPaciente);

        return ResponseEntity.ok().body(mapper.toDadosDetalhadosPacientes(paciente));
    }

    @DeleteMapping(value = "{id}")
    @Transactional
    public ResponseEntity<Void> deletarPaciente(@PathVariable("id") Long id){
        var paciente = pacienteService.getPacientePorId(id);
        paciente.inativar();

        return ResponseEntity.noContent().build();
    }

}
