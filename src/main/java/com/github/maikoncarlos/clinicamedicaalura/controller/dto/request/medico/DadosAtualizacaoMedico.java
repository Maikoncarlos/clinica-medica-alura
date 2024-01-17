package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}