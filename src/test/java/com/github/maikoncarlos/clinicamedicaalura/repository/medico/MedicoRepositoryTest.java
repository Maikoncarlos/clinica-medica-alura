package com.github.maikoncarlos.clinicamedicaalura.repository.medico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
// TODO ccofigurar para rodar os testes no mesmo banco da aplicação
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
class MedicoRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void escolherMedicoAleatorioLivreNaData() {
    }
}