package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosUsuario(
        @NotBlank
        @Email
        String login,
        @NotBlank
        @Size(min = 1, max = 8)
        String senha) {
}
