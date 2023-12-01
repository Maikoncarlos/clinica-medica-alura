package com.github.maikoncarlos.clinicamedicaalura.repository.paciente;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
@Table(name = "pacientes")
@Entity(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private String telefone;
    private String cpf;
    @Embedded
    private DadosEndereco endereco;
}
