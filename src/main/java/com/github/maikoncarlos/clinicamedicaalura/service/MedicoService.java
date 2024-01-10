package com.github.maikoncarlos.clinicamedicaalura.service;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.DadosMedicoResumido;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.MedicoRepository;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicoService {

    private MedicoRepository repository;
    private ClinicaMapper mapper;

    public void cadastrar(DadosCadastroMedicoRequest dadosMedico) {
        var medico = mapper.toMedico(dadosMedico);
        repository.save(medico);
    }

    public List<DadosMedicoResumido> findAll() {
        return mapper.toMedicoResumido(repository.findAll());
    }
}
