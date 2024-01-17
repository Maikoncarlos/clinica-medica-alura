package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedicoRequest(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{3,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) { }