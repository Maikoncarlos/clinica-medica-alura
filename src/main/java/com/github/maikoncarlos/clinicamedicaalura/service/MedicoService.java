package com.github.maikoncarlos.clinicamedicaalura.service;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosCadastroMedicoRequest;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.DadosMedicoResumido;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.Medico;
import com.github.maikoncarlos.clinicamedicaalura.repository.medico.MedicoRepository;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoService {

    private MedicoRepository repository;
    private ClinicaMapper mapper;

    public void cadastrar(DadosCadastroMedicoRequest dadosMedico) {
        var medico = mapper.toMedico(dadosMedico);
        repository.save(medico);
    }

    public Page<DadosMedicoResumido> findAllAtivos(Pageable paginacao) {
//        return mapper.toMedicoResumido(repository.findAll(paginacao));
        return repository.findAllByAtivoTrue(paginacao).map(DadosMedicoResumido::new);
    }

    public Medico getMedicoPorId(Long id) {
       return repository.getReferenceById(id);
    }
}
