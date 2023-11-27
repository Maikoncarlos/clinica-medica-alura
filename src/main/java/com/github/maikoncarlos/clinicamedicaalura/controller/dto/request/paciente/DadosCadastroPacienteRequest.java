package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;

public record DadosCadastroPacienteRequest(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) { }