package com.gedharizka.trainig.perpustakaan.controller;

import com.gedharizka.trainig.perpustakaan.entity.Pengarang;
import com.gedharizka.trainig.perpustakaan.repository.PengarangRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengarang")
public class PengarangApi {

    private PengarangRepository repository;


    public Iterable<Pengarang>findAll(){
        return repository.findAll();
    }
}
