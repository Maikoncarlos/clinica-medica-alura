package com.github.maikoncarlos.clinicamedicaalura.service;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.consulta.DadosConsultaResponse;
import com.github.maikoncarlos.clinicamedicaalura.infra.exceptions.ValidacaoException;
import com.github.maikoncarlos.clinicamedicaalura.repository.consulta.Consulta;
import com.github.maikoncarlos.clinicamedicaalura.repository.consulta.ConsultaRepository;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.Medico;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.MedicoRepository;
import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoConsultasService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public DadosConsultaResponse agendar(DadosAgendamentoConsultaDTO dados) {

        var paciente = pacienteRepository.findById(dados.idPaciente())
                .orElseThrow(() -> new ValidacaoException("ERROR - paciente do ID informado não existe!"));

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("ERROR - medico do ID informado não existe!");
        }
        var medico = escolherMedicoDaEspecialidadeAleatoriamente(dados);

        var consulta = consultaRepository.save(new Consulta(null, medico, paciente, dados.data()));

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

}
