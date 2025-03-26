package com.gozde.controller;

import com.gozde.document.UserProfile;
import com.gozde.dto.request.CreateUserRequestDto;
import com.gozde.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gozde.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {

    private final UserProfileService service;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto) {
        service.createUser(dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(String name) {
        return ResponseEntity.ok(service.upperName(name));
    }
}
