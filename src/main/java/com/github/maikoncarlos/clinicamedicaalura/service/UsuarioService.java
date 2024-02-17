package com.github.maikoncarlos.clinicamedicaalura.service;

import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.usuario.DadosUsuario;
import com.github.maikoncarlos.clinicamedicaalura.repository.usuario.UsuarioRepository;
import com.github.maikoncarlos.clinicamedicaalura.service.mapper.ClinicaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ClinicaMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public void execute(DadosUsuario dadosUsuario) {
        var senhaEncriptada = passwordEncoder.encode(dadosUsuario.senha());
        var dadosUsuarioEncriptado = new DadosUsuario(dadosUsuario.login(), senhaEncriptada);
        var usuario = mapper.toUsuario(dadosUsuarioEncriptado);

        usuarioRepository.save(usuario);

    }
}
