package com.example.test.service.servicelmp.auth;

import com.example.test.dto.AuthenticationRequest;
import com.example.test.dto.RegisterRequest;
import com.example.test.entity.Role;
import com.example.test.entity.Test;
import com.example.test.exeption.ApiRequestException;
import com.example.test.repository.TestRepo;
import com.example.test.security.AuthenticationResponce;
import com.example.test.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private  final TestRepo testRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponce authenticated (AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));
        var user = testRepo.findByEmail(authenticationRequest.getEmail()).orElseThrow(() -> new ApiRequestException("opps is not found"));

        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponce.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponce regester(RegisterRequest registerRequest) {
        var user = Test
                .builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .age(registerRequest.getAge())
                .role(Role.USER)
                .build();

        testRepo.save(user);
        var jwtToken = jwtService.generateToken(user); // This should work now

        return AuthenticationResponce.builder()
                .token(jwtToken)
                .build();
    }
}
