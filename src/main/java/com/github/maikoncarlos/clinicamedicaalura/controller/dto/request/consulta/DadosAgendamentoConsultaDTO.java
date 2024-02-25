package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultaDTO(
        @JsonAlias("medico_id")
        Long idMedico,
        @NotNull
        @JsonAlias("paciente_id")
        Long idPaciente,
        Especialidade especialidade,
        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data) {
}
