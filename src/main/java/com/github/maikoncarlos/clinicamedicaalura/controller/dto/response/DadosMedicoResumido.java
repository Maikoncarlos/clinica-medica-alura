package com.github.maikoncarlos.clinicamedicaalura.controller.dto.response;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.Especialidade;

public record DadosMedicoResumido(
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {
}