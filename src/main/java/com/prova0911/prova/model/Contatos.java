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

    public Contatos(Contatos entity){
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        number = entity.getNumber();
    }

}
