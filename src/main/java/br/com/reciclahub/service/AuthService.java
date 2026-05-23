package br.com.reciclahub.service;

import br.com.reciclahub.dto.LoginRequestDTO;
import br.com.reciclahub.dto.LoginResponseDTO;
import br.com.reciclahub.security.JwtService;
import br.com.reciclahub.security.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO autenticar(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha())
        );

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return new LoginResponseDTO(
                token,
                "Bearer",
                jwtService.getExpirationMs(),
                userDetails.getIdEmpresa(),
                userDetails.getEmpresa().getNome(),
                userDetails.getEmpresa().getEmail(),
                userDetails.getEmpresa().getTipo()
        );
    }
}
