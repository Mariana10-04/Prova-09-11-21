package com.prova0911.prova.util;

import com.prova0911.prova.model.Contatos;
import org.springframework.stereotype.Component;

    @Component
    public class Creator {

        public static Contatos createContact() {
            return new Contatos("Mariana Gon", "marianagondasilva@gmail.com", "45998072662");
        }

}
