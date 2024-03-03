package com.github.maikoncarlos.clinicamedicaalura.service.validacoes;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica  implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsultaDTO dados){
        var dataAgendamentoConsulta = dados.data();

        var domingo = dataAgendamentoConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaClinica = dataAgendamentoConsulta.getHour() < 7 ;
        var ultimoHorarioParaAgendamentoConsulta = dataAgendamentoConsulta.getHour() > 18;

        if(domingo || antesDaAberturaClinica || ultimoHorarioParaAgendamentoConsulta){
            throw new ValidacaoException("Consulta fora do horário do funcionamento da clínica - data solicita " + dataAgendamentoConsulta);
        }


    }
}
