package com.prova0911.prova.controller;


import com.prova0911.prova.model.Contatos;
import com.prova0911.prova.service.ContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatosController {

    @Autowired
    private ContatosService service;

    @Autowired
    public ContatosController(ContatosService service) {
        this.service = service;
    }
    @GetMapping  //list
    public ResponseEntity<List<Contatos>> list() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping  //save
    public ResponseEntity<Contatos> save(@RequestBody Contatos address) throws Exception {
        return new ResponseEntity<>(service.save(address), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")  //delete
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping  //update
    public ResponseEntity<Void> replace(@RequestBody Contatos contatos) throws Exception {
        service.update(contatos);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
