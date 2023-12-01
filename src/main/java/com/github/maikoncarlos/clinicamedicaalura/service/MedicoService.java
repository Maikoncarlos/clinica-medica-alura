package com.github.maikoncarlos.clinicamedicaalura.service;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.MedicoRepository;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoService {

    private MedicoRepository repository;
    private ClinicaMapper mapper;

    public void cadastrar(DadosCadastroMedicoRequest dadosMedico) {
        var medico = mapper.toMedico(dadosMedico);
        System.out.println(medico.toString());
        repository.save(medico);
    }
}
