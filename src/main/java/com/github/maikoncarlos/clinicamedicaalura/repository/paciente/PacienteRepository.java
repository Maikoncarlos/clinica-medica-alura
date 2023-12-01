package com.github.maikoncarlos.clinicamedicaalura.repository.paciente;

import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
