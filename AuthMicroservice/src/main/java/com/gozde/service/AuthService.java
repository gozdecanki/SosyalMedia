package com.gozde.service;

import com.gozde.dto.request.CreateUserRequestDto;
import com.gozde.dto.request.LoginRequestDto;
import com.gozde.dto.request.RegisterRequestDto;
import com.gozde.entity.Auth;
import com.gozde.manager.UserProfileManager;
import com.gozde.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
       Auth auth= repository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword()).build());

       userProfileManager.createUser(CreateUserRequestDto.builder()
               .authId(auth.getId())
               .email(auth.getEmail())
               .userName(auth.getUserName())
               .build());

       return auth;

    }

    public Boolean login(LoginRequestDto dto) {

        return  repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
