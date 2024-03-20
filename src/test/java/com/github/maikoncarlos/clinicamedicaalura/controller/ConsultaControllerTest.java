package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.consulta.DadosAgendamentoConsultaDTO;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.Especialidade;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.response.consulta.DadosConsultaResponse;
import com.github.maikoncarlos.clinicamedicaalura.service.AgendamentoConsultasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private JacksonTester<DadosAgendamentoConsultaDTO> dadosAgendamentoConsultaDTOJson;
    @Autowired
    private JacksonTester<DadosConsultaResponse> dadosConsultaResponseJson;

    @MockBean
    private AgendamentoConsultasService consultasService;

    DadosAgendamentoConsultaDTO consultaDTO;
    DadosConsultaResponse consultaResponse;

    @BeforeEach
    void setUp() {
        LocalDateTime data = LocalDateTime.now().plusHours(3);
        consultaDTO = new DadosAgendamentoConsultaDTO(2L, 1L, Especialidade.CARDIOLOGIA, data);
        consultaResponse = new DadosConsultaResponse(1L, 2L, 1L, data);
    }

    @Test
    @DisplayName("Cenário1 - Deve devolver codigo 400 quando informacoes vierem invalidas")
    @WithMockUser
    void agendar_Cenario1() throws Exception {
        var response = mvc.perform(post("/v1/consultas"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Cenário2 - Deve devolver codigo 200 com os dados do agendamento do consulta")
    @WithMockUser
    void agendar_Cenario2() throws Exception {
        when(consultasService.agendar(any(DadosAgendamentoConsultaDTO.class))).thenReturn(consultaResponse);

        var response = mvc
                .perform(post("/v1/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosAgendamentoConsultaDTOJson.write(consultaDTO).getJson()))
                .andReturn().getResponse();

        var expected = dadosConsultaResponseJson.write(consultaResponse).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(expected);
    }
}