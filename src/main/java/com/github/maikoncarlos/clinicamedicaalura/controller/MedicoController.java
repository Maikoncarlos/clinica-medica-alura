package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosAtualizacaoMedico;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.DadosMedicoResumido;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.medico.DadosDetalhadosMedicos;
import com.github.maikoncarlos.clinicamedicaalura.service.MedicoService;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "v1/clinica-voll/medicos")
@AllArgsConstructor
public class MedicoController {

    private MedicoService medicoService;
    private ClinicaMapper mapper;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DadosDetalhadosMedicos> cadastrarMedicos(@RequestBody @Valid DadosCadastroMedicoRequest dadosMedico, UriComponentsBuilder uriComponentsBuilder){
        DadosDetalhadosMedicos medicoSalvo = medicoService.cadastrar(dadosMedico);
        URI location = uriComponentsBuilder
                .path("v1/clinica-voll/medicos/{id}")
                .buildAndExpand(medicoSalvo.id())
                .toUri();

        return ResponseEntity.created(location).body(medicoSalvo);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DadosDetalhadosMedicos> buscarMedicoPorId(@PathVariable("id") Long id){
        var medico = medicoService.getMedicoPorId(id);
        DadosDetalhadosMedicos medicoPertencenteAoId = mapper.toDadosDetalhadosMedicos(medico);

        return ResponseEntity.ok().body(medicoPertencenteAoId);
    }

    @GetMapping(value = "listaPaginada")
    public ResponseEntity<Page<DadosMedicoResumido>> listarTodosMedicosPaginados(@PageableDefault(size = 5, sort = "nome") Pageable paginacao){
        Page<DadosMedicoResumido> medicosPaginados = medicoService.findAllAtivos(paginacao);

        return ResponseEntity.ok(medicosPaginados);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosMedicos> atualizarDadosMedicos(@RequestBody @Valid DadosAtualizacaoMedico dadosAtualizacaoMedico){
       var medico = medicoService.getMedicoPorId(dadosAtualizacaoMedico.id());
       medico.atualizarDadosMedicos(dadosAtualizacaoMedico);

       return ResponseEntity.ok().body(mapper.toDadosDetalhadosMedicos(medico));
    }

    @DeleteMapping(value = "{id}")
    @Transactional
    public ResponseEntity<Void> deletarMedico(@PathVariable("id") Long id){
        var medico = medicoService.getMedicoPorId(id);
        medico.inativar();

        return ResponseEntity.noContent().build();
    }

}
