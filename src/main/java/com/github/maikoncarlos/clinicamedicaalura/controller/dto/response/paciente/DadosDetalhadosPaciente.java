package com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.paciente;

import com.github.maikoncarlos.clinicamedicaalura.repository.Endereco;

public record DadosDetalhadosPaciente(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco) {
}
