package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;

public record DadosCadastroMedicoRequest(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco) { }