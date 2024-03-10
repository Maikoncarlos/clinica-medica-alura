package com.github.maikoncarlos.clinicamedicaalura.service.validacoesCancelamento;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosCancelamentoDTO;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoDTO cancelamentoDTO);
}
