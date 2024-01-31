package com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.medico;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.Especialidade;
import com.github.maikoncarlos.clinicamedicaalura.repository.Endereco;

public record DadosDetalhadosMedicos(
        Long id,
        String nome,
        String telefone,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco) {
}