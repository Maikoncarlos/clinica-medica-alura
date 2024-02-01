package com.github.maikoncarlos.clinicamedicaalura.service.mapper;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosCadastroPacienteRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.medico.DadosDetalhadosMedicos;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.paciente.DadosDetalhadosPaciente;
import com.github.maikoncarlos.clinicamedicaalura.repository.Endereco;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.Medico;
import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClinicaMapper {
    @Mapping(constant = "true", target = "ativo")
    Paciente toPaciente(DadosCadastroPacienteRequest request);
    @Mapping(constant = "true", target = "ativo")
    Medico toMedico(DadosCadastroMedicoRequest request);
    Endereco map(DadosEndereco value);

    DadosDetalhadosMedicos toDadosDetalhadosMedicos(Medico medicoSaved);

    DadosDetalhadosPaciente toDadosDetalhadosPacientes(Paciente paciente);
}
