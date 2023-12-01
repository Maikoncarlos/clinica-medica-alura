package com.github.maikoncarlos.clinicamedicaalura.service;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.PacienteRepository;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PacienteService {

    private PacienteRepository repository;
    private ClinicaMapper mapper;

    public void cadastrar(DadosCadastroPacienteRequest dadosPaciente) {
        var paciente = mapper.toPaciente(dadosPaciente);
        System.out.println(paciente.toString());
        repository.save(paciente);
    }
}
