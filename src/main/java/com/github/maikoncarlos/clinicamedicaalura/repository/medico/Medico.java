package com.github.maikoncarlos.clinicamedicaalura.repository.medico;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.DadosAtualizacaoMedico;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.medico.Especialidade;
import com.github.maikoncarlos.clinicamedicaalura.repository.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public void atualizarDadosMedicos(DadosAtualizacaoMedico medico) {
        if(medico.nome() != null){
            this.nome = medico.nome();
        }
        if(medico.telefone() != null){
            this.telefone= medico.telefone();
        }
        if(medico.endereco() != null){
            this.endereco.atualizarEndereco(medico.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;

    }
}
