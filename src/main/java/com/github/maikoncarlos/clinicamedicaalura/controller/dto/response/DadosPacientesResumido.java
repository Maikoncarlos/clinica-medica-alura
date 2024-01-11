package com.github.maikoncarlos.clinicamedicaalura.controller.dto.response;

import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.Paciente;

public record DadosPacientesResumido(

        String nome,

        String email,

        String telefone,

        String cpf) {
    public DadosPacientesResumido(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}