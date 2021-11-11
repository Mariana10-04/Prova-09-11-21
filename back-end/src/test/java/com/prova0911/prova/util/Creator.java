package com.prova0911.prova.util;

import com.prova0911.prova.model.Contatos;
import org.springframework.stereotype.Component;

    @Component
    public class Creator {

        public static Contatos createContact(){
            return Contatos.builder()
                    .nome("marlao berreiro")
                    .email("urrante@gmail.com")
                    .number("1111111511")
                    .build();
        }

}
