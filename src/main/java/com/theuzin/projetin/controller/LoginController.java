package com.theuzin.projetin.controller;

import com.theuzin.projetin.dto.LoginRequest;
import com.theuzin.projetin.dto.LoginResponse;
import com.theuzin.projetin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> fazerLogin(@RequestBody LoginRequest request){
        loginService.fazerLogin(request);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/criar-conta")
    public ResponseEntity<LoginResponse> criarConta(@RequestBody LoginRequest request){
        loginService.criarConta(request);
        return ResponseEntity.noContent().build();

    }

}
