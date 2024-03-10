package com.github.maikoncarlos.clinicamedicaalura.service.validacoes.agendamento;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsultaDTO dados);
}
