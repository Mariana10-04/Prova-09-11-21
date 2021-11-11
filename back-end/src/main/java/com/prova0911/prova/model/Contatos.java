package com.prova0911.prova.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "contatos")
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String number;

//    public Contatos(Contatos entity) {
//        id = entity.getId();
//        nome = entity.getNome();
//        email = entity.getEmail();
//        number = entity.getNumber();
//    }


//    public Contatos() {
//    }
//
//    public Contatos(String nome, String email, String number) {
//        this.nome = nome;
//        this.email = email;
//        this.number = number;
//    }
}
