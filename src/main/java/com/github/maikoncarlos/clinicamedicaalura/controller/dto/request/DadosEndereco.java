package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern (regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        @Size (max = 2)
        String uf,
        String complemento,
        String numero) { }