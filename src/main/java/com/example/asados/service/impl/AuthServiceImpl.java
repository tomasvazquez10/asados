package com.example.asados.service.impl;

import com.example.asados.entity.Usuario;
import com.example.asados.repository.UsuarioRepository;
import com.example.asados.service.AuthService;
import com.example.asados.config.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepo;
    private final JwtService jwtService;

    public AuthServiceImpl(UsuarioRepository usuarioRepo,
                           JwtService jwtService) {
        this.usuarioRepo = usuarioRepo;
        this.jwtService = jwtService;
    }

    @Override
    public String login(String username, String password) {

        Usuario user = usuarioRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Password incorrecta");
        }

        return jwtService.generateToken(username);
    }
}
