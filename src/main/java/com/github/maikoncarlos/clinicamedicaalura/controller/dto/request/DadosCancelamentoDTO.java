package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoDTO(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamentoEnum motivo) {
}
