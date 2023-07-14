package com.theuzin.projetin.repository;

import com.theuzin.projetin.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta,Long> {
    Optional<Conta> findByEmail(String email);
}
