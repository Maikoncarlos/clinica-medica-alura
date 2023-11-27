package com.github.maikoncarlos.clinicamedicaalura.controller.dto.request;

public record DadosEndereco(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero) { }