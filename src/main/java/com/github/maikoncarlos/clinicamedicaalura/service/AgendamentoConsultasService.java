package com.github.maikoncarlos.clinicamedicaalura.service;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosCancelamentoDTO;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.consulta.DadosConsultaResponse;
import com.github.maikoncarlos.clinicamedicaalura.infra.exceptions.ValidacaoException;
import com.github.maikoncarlos.clinicamedicaalura.repository.consulta.Consulta;
import com.github.maikoncarlos.clinicamedicaalura.repository.consulta.ConsultaRepository;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.Medico;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.MedicoRepository;
import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.PacienteRepository;
import com.github.maikoncarlos.clinicamedicaalura.service.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import com.github.maikoncarlos.clinicamedicaalura.service.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoConsultasService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final List<ValidadorAgendamentoDeConsulta> validadores;
    private final List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DadosConsultaResponse agendar(DadosAgendamentoConsultaDTO dados) {

        var paciente = pacienteRepository.findById(dados.idPaciente())
                .orElseThrow(() -> new ValidacaoException("ERROR - paciente do ID informado não existe!"));

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("ERROR - medico do ID informado não existe!");
        }

        validadores.forEach( validadores -> validadores.validar(dados));

        var medico = escolherMedicoDaEspecialidadeAleatoriamente(dados);

        if(Objects.isNull(medico)){
            throw new ValidacaoException("Não tem nenhum médico disonível para atendimento!");
        }

        var consulta = consultaRepository.save(new Consulta(null, medico, paciente, dados.data(), null));

        return new DadosConsultaResponse(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }

    private Medico escolherMedicoDaEspecialidadeAleatoriamente(DadosAgendamentoConsultaDTO dados) {

        if (dados.idMedico() == null) {
            if (dados.especialidade() == null) {
                throw new ValidacaoException("ERROR - especialidade é obrigatória quando médico não for escolhido!");
            }
            return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
        }

        return medicoRepository.getReferenceById(dados.idMedico());
    }

    public void cancelar(DadosCancelamentoDTO cancelamentoDTO) {
        if(!consultaRepository.existsById(cancelamentoDTO.idConsulta())){
            throw new ValidacaoException("ERROR - Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(valid -> valid.validar(cancelamentoDTO));

        var consulta = consultaRepository.getReferenceById(cancelamentoDTO.idConsulta());
        consulta.cancelar(cancelamentoDTO.motivo());
    }
}
