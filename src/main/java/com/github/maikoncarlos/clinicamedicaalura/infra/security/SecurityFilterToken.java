package com.github.maikoncarlos.clinicamedicaalura.infra.security;

import com.github.maikoncarlos.clinicamedicaalura.infra.exceptions.TokenNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilterToken extends OncePerRequestFilter {

    private final TokenService tokenService;
    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarTokenJWT(request);
        tokenService.getSubject(tokenJWT);

        filterChain.doFilter(request, response);
    }

    private String recuperarTokenJWT(HttpServletRequest request) throws TokenNotFoundException {
        var authorization = request.getHeader("Authorization");
        if(authorization == null){
            throw new TokenNotFoundException("Token JWT não enviado no cabeçalho Authorization!");
        }

        return authorization.replace("Bearer ", "");
    }
}
