package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosAtualizacaoMedico;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.DadosMedicoResumido;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.DadosPacientesResumido;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.MedicoRepository;
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
    private final MedicoRepository medicoRepository;

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

    @GetMapping(value = "medicos/listaPaginada")
    public Page<DadosMedicoResumido> listarTodosMedicosPaginados(@PageableDefault(size = 5, sort = "nome") Pageable paginacao){
        return medicoService.findAllAtivos(paginacao);
    }

    @GetMapping(value = "pacientes/listaPaginada")
    public Page<DadosPacientesResumido> listarTodosPacientesPaginados(@PageableDefault(size = 5, sort = "nome") Pageable paginacao){
        return pacienteService.findAll(paginacao);
    }

    @PutMapping(value = "medicos")
    @Transactional
    public void atualizarDadosMedicos(@RequestBody @Valid DadosAtualizacaoMedico dadosAtualizacaoMedico){
       var medico = medicoService.getMedicoPorId(dadosAtualizacaoMedico.id());
       medico.atualizarDadosMedicos(dadosAtualizacaoMedico);
    }

    @DeleteMapping(value = "medicos/{id}")
    @Transactional
    public void deletarMedico(@PathVariable("id") Long id){
        var medico = medicoService.getMedicoPorId(id);
        medico.inativar();

    }

}
