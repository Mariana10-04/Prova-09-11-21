package com.prova0911.prova.repository;

import com.prova0911.prova.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {

    Optional<Contatos> findById(Long id);
    Optional<Contatos> findByEmail(String email);
    Optional<Contatos> findByNumber(String number);
}