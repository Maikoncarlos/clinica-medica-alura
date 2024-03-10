package com.github.maikoncarlos.clinicamedicaalura.service.validacoesCancelamento;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosCancelamentoDTO;
import com.github.maikoncarlos.clinicamedicaalura.infra.exceptions.ValidacaoException;
import com.github.maikoncarlos.clinicamedicaalura.repository.consulta.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
@RequiredArgsConstructor
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta{

    private final ConsultaRepository repository;
    @Override
    public void validar(DadosCancelamentoDTO cancelamentoDTO) {
        var consulta = repository.getReferenceById(cancelamentoDTO.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if(diferencaEmHoras < 24){
            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }

    }
}
