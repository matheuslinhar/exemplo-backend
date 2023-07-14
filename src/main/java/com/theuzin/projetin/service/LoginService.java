package com.theuzin.projetin.service;

import com.theuzin.projetin.dto.LoginRequest;
import com.theuzin.projetin.model.Conta;
import com.theuzin.projetin.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
     private ContaRepository contaRepository;
    public void criarConta(LoginRequest request){
        if (contaRepository.findByEmail(request.getUsuario()).isPresent())
            throw new RuntimeException("Usuario já cadastrado");
        if (request.getUsuario().isBlank())
            throw new RuntimeException("Usuario invalido");
        Conta conta = new Conta();
        conta.setEmail(request.getUsuario());
        conta.setSenha(request.getSenha());
        contaRepository.save(conta);

    }
    public void fazerLogin(LoginRequest request) {
        Optional<Conta> conta = contaRepository.findByEmail(request.getUsuario());


        if (conta.isEmpty())
            throw new RuntimeException("NO EXIST");

        if (!conta.get().getSenha().equals(request.getSenha()))
            throw new RuntimeException("Senha incorreta");

    }

}
