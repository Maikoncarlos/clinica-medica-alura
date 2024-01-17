package com.github.maikoncarlos.clinicamedicaalura.repository;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public void atualizarEndereco(DadosEndereco endereco) {
        if(endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if(endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if(endereco.numero() != null){
            this.numero = endereco.numero();
        }
        if(endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
        if(endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if(endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if(endereco.uf() != null){
            this.uf = endereco.uf();
        }
    }
}
