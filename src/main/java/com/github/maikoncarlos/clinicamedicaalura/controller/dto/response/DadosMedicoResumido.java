package com.github.maikoncarlos.clinicamedicaalura.controller.dto.response;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.Especialidade;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.Medico;

public record DadosMedicoResumido(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosMedicoResumido(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}