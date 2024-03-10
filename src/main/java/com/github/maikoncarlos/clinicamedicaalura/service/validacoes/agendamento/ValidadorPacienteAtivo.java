package com.github.maikoncarlos.clinicamedicaalura.service.validacoes.agendamento;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.infra.exceptions.ValidacaoException;
import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    private final PacienteRepository repository;
    @Override
    public void validar(DadosAgendamentoConsultaDTO dados) {
        if(Objects.isNull(dados.idPaciente())){
            return;
        }

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com Paciente!");
        }

    }
}
