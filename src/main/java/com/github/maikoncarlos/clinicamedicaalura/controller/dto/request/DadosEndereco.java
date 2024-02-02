package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosEndereco(
        @NotBlank(message = "{cep.obrigatorio}")
        @Pattern (regexp = "\\d{8}", message = "{cep.invalido}")
        String cep,
        @NotBlank(message = "{logradouro.obrigatorio}")
        String logradouro,
        @NotBlank(message = "{numero.obrigatorio}")
        String numero,
        String complemento,
        @NotBlank(message = "{bairro.obrigatorio}")
        String bairro,
        @NotBlank(message = "{cidade.obrigatoria}")
        String cidade,
        @NotBlank(message = "{uf.obrigatoria}")
        @Size (max = 2, message = "{uf.invalido}")
        String uf) {
}