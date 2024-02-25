package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.consulta.DadosConsultaResponse;
import com.github.maikoncarlos.clinicamedicaalura.service.AgendamentoConsultasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final AgendamentoConsultasService consultasService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosConsultaResponse> agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO consultaDTO){

        return ResponseEntity.ok().body(consultasService.agendar(consultaDTO));
    }
}
