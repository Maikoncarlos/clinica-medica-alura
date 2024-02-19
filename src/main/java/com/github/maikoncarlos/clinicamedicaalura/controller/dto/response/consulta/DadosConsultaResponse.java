package com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.consulta;

import java.time.LocalDateTime;

public record DadosConsultaResponse(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data) {
}
