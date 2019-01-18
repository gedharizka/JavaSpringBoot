package com.gedharizka.trainig.perpustakaan.controller;


import com.gedharizka.trainig.perpustakaan.entity.Anggota;
import com.gedharizka.trainig.perpustakaan.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/anggota")
public class AnggotaApi {

    @Autowired
    private AnggotaRepository repository;

    @GetMapping
    public Iterable<Anggota> findall(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Anggota> save(@RequestBody Anggota anggota){
        anggota = repository.save(anggota);
        return ResponseEntity.ok(anggota);
    }

    @GetMapping("/contoh")
    public Anggota inti(@RequestParam (name = "id") String data1, @RequestParam(name = "nama")String data2,@RequestParam(name = "nomoe_ktp") String data3,@RequestParam(name = "alamat")String data4){
        return new Anggota(data1,data2,data3,data4);
    }


    @GetMapping("/(id)")
    public ResponseEntity<Anggota> findById(@PathVariable("id") String AnggotaId){
        Optional<Anggota> anggotaOptional= repository.findById(AnggotaId);
        if (anggotaOptional.isPresent())
            return ResponseEntity.ok(anggotaOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("(/id)")
    public ResponseEntity<?>deleteById(String id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
