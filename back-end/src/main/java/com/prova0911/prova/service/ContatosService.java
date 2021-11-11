package com.prova0911.prova.service;

import com.prova0911.prova.model.Contatos;
import com.prova0911.prova.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosService {
    @Autowired
    private ContatosRepository repository;

    public List<Contatos> listAll() {
        return repository.findAll();
    }

    public Optional<Contatos> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Contatos> findByNumber(String Number) {
        return repository.findByNumber(Number);
    }

    public Contatos save(Contatos contato) {

        Optional<Contatos> emailFound = repository.findByEmail(contato.getEmail());
        Optional<Contatos> numberFound = repository.findByNumber(contato.getNumber());

        if (emailFound.isPresent() || numberFound.isPresent()) {
            throw new RuntimeException("Email ou Telefone já existe!!!");
        } else {
            return repository.save(contato);
        }
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Contatos update(Contatos contatos) {return repository.save(contatos);}

    public Contatos creator(Contatos contact) {
        return contact;
    }
}

