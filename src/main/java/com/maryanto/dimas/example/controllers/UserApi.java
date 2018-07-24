package com.maryanto.dimas.example.controllers;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/users")
public class UserApi {

    @PostMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserLogin(Authentication principal) {
        Map<String, Object> params = new HashedMap<>();
        params.put("time", new Date());
        params.put("currentUser", principal.getName());
        return ok().body(params);
    }
}
