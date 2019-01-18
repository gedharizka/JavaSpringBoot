package com.gedharizka.trainig.perpustakaan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaloApi {

    @GetMapping
    public String halo(){
        return "(\n" +
                "\"message\": \"Halo ini dari Springboot2 setelah push ke Git!\n\n" +
                ")";
    }
}
