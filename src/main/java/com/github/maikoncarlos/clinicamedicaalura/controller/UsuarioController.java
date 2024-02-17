package com.github.maikoncarlos.clinicamedicaalura.controller;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.usuario.DadosUsuario;
import com.github.maikoncarlos.clinicamedicaalura.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody @Valid DadosUsuario dadosUsuario){
        usuarioService.execute(dadosUsuario);
        return ResponseEntity.noContent().build();
    }
}
