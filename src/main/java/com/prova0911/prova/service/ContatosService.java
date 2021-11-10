package com.prova0911.prova.service;

import com.prova0911.prova.model.Contatos;
import com.prova0911.prova.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Optional<Contatos> contatoProcurado = repository.findByNumber(contato.getNumber());
        return repository.save(contato);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Contatos contatos) {
        Optional<Contatos> salaParaMudar = repository.findByNumber(contatos.getNumber());

        if (salaParaMudar.isEmpty()) {
        } else {
            repository.save(contatos);
        }
    }

    public Contatos creator(Contatos contact) {
        return contact;
    }
}

