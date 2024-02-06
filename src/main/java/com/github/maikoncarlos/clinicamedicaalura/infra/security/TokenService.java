package com.github.maikoncarlos.clinicamedicaalura.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.github.maikoncarlos.clinicamedicaalura.controller.dto.request.usuario.DadosUsuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value ("${api.security.token.secret}")
    private String secret;


    public String gerarToken(DadosUsuario usuario) {

        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(usuario.login())
                    .withExpiresAt(dataExpiracaoToken())
                    .sign(algoritimo);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    private static Instant dataExpiracaoToken() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
