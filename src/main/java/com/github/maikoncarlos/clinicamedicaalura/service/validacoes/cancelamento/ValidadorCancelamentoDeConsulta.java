package com.github.maikoncarlos.clinicamedicaalura.service.validacoes.cancelamento;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosCancelamentoDTO;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoDTO cancelamentoDTO);
}
