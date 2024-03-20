package com.github.maikoncarlos.clinicamedicaalura.repository.medico;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.Especialidade;
import com.github.maikoncarlos.clinicamedicaalura.repository.Endereco;
import com.github.maikoncarlos.clinicamedicaalura.repository.consulta.Consulta;
import com.github.maikoncarlos.clinicamedicaalura.repository.paciente.Paciente;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
// TODO configuração para rodar os testes no mesmo banco da aplicação
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    private static final String TELEFONE = "11 999999999";
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private EntityManager entityManager;

    Medico medico;
    Paciente paciente;

    @BeforeEach
    void setUp() {
        medico = cadastrarMedico("Medico", "medico2voll.med", "123456", Especialidade.CARDIOLOGIA);
        paciente = cadastrarPaciente("Paciente", "paciente@voll.med", "91054554056");
    }

    @Test
    @DisplayName("Cenário1 - Deve devolver null quando o unico medico não estiver disponivel na data")
    void escolherMedicoAleatorioLivreNaData_Cenario1() {

        var dataConsultaNaProximaSegundaAsDez = LocalDateTime.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .toLocalDate().atTime(10, 0);

        cadastrarConsulta(medico, paciente, dataConsultaNaProximaSegundaAsDez);

        var medicoLivre = medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA, dataConsultaNaProximaSegundaAsDez);

       assertThat(medicoLivre).isNull();

    }

    private Consulta cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        var consulta = Consulta.builder().medico(medico).paciente(paciente).data(data).build();
        entityManager.persist(consulta);
        return consulta;
    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = Medico.builder().nome(nome).telefone(TELEFONE).email(email).crm(crm).especialidade(especialidade).endereco(dadosEndereco()).ativo(Boolean.TRUE).build();
        entityManager.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = Paciente.builder().nome(nome).telefone(TELEFONE).email(email).cpf(cpf).endereco(dadosEndereco()).build();
        entityManager.persist(paciente);
        return paciente;
    }

    private Endereco dadosEndereco() {
        return new Endereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                "Distrito Federal",
                "DF"
        );
    }
}