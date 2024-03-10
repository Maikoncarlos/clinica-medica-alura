package com.github.maikoncarlos.clinicamedicaalura.service.validacoes.agendamento;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.infra.exceptions.ValidacaoException;
import com.github.maikoncarlos.clinicamedicaalura.repository.consulta.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{

    private final ConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsultaDTO dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Médico já possui outra consulta médica no mesmo horário");
        }
    }
}
