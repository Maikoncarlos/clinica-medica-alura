package com.github.maikoncarlos.clinicamedicaalura.repository.medico;

import com.github.maikoncarlos.clinicamedicaalura.repository.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
