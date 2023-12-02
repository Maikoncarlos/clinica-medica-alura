package com.github.maikoncarlos.clinicamedicaalura.service.mapper;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import com.github.maikoncarlos.clinicamedicaalura.repository.Endereco;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.Medico;
import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.Paciente;
import org.mapstruct.Mapper;

@Mapper
public interface ClinicaMapper {

    Paciente toPaciente(DadosCadastroPacienteRequest request);
    Medico toMedico(DadosCadastroMedicoRequest request);
    Endereco map(DadosEndereco value);
}