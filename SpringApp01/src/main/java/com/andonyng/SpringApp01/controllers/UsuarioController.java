package com.andonyng.SpringApp01.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    //URL "/prueba"
    @RequestMapping(value = "prueba")
    public List<String> prueba() {
        return List.of("Manzana","Pera","Kiwi","Mandarina","Platano");
    }

}
