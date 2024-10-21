package com.example.test.controller;

import com.example.test.dto.AuthenticationRequest;
import com.example.test.dto.RegisterRequest;
import com.example.test.exeption.ApiRequestException;
import com.example.test.security.AuthenticationResponce;
import com.example.test.service.servicelmp.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class Auth {

private final AuthenticationService authenticationService;
@PostMapping("/register")
    public ResponseEntity<AuthenticationResponce> regester(
            @RequestBody RegisterRequest registerRequest ){
           return new  ResponseEntity<>(authenticationService.regester(registerRequest) , HttpStatus.CREATED);
    }
@PostMapping("/authenticated")
    public ResponseEntity<AuthenticationResponce> authenticate(@RequestBody AuthenticationRequest responce ){

try {
    return new  ResponseEntity<>(authenticationService.authenticated(responce) , HttpStatus.OK);
}catch (ApiRequestException e){
    throw new  ApiRequestException("you don't have permission");
}

}
    @GetMapping("/")
    ResponseEntity<String> test(){
        return new ResponseEntity<>("hello word ", HttpStatus.OK);
    }
}
