package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.usuario.DadosUsuario;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/login")
@RequiredArgsConstructor
public class AutenticacaoUsuarioController {

    private final AuthenticationManager manager;
    private final ClinicaMapper mapper;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosUsuario usuario){
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.login(), usuario.senha()));
        return ResponseEntity.ok().build();
    }
}
