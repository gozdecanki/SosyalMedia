package com.gozde.controller;

import com.gozde.dto.request.LoginRequestDto;
import com.gozde.dto.request.RegisterRequestDto;
import com.gozde.entity.Auth;
import com.gozde.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gozde.config.RestApis.*;



@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {

    private final AuthService service;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto) {

        if (!dto.getPassword().equals(dto.getRepassword())) {
            throw new RuntimeException("Şifreler uymuyor");
        }
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
