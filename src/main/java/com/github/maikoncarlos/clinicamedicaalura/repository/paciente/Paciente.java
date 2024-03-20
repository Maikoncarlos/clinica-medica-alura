package com.github.maikoncarlos.clinicamedicaalura.repository.paciente;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.paciente.DadosAtualizacaoPaciente;
import com.github.maikoncarlos.clinicamedicaalura.repository.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
@Table(name = "pacientes")
@Entity(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public void atualizarDadosMedicos(DadosAtualizacaoPaciente paciente) {
        if (paciente.nome() != null) {
            this.nome = paciente.nome();
        }
        if (paciente.email() != null) {
            this.email = paciente.email();
        }
        if (paciente.telefone() != null) {
            this.telefone = paciente.telefone();
        }
        if (paciente.endereco() != null) {
            this.endereco.atualizarEndereco(paciente.endereco());
        }

    }

    public void inativar() {
        this.ativo = false;
    }
}
