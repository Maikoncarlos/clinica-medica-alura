package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosCancelamentoDTO;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.consulta.DadosConsultaResponse;
import com.github.maikoncarlos.clinicamedicaalura.service.AgendamentoConsultasService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/consultas")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    private final AgendamentoConsultasService consultasService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosConsultaResponse> agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO consultaDTO){
        var agendaDTO = consultasService.agendar(consultaDTO);
        return ResponseEntity.ok().body(agendaDTO);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> cancelar(@RequestBody @Valid DadosCancelamentoDTO cancelamentoDTO){
        consultasService.cancelar(cancelamentoDTO);
        return ResponseEntity.noContent().build();
    }
}
