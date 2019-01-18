package com.gedharizka.trainig.perpustakaan.controller;

import com.gedharizka.trainig.perpustakaan.entity.Penerbit;
import com.gedharizka.trainig.perpustakaan.repository.PenerbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/penerbit")
public class PenerbitApi {

    @Autowired
    private PenerbitRepository repository;

    @GetMapping
    public Iterable<Penerbit> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Penerbit> save(
            @RequestBody Penerbit penerbit){
        penerbit = repository.save(penerbit);
        return ResponseEntity.ok(penerbit);
    }

    @GetMapping("/contoh")
    public Penerbit inti(
            @RequestParam(name = "id") String data1,
            @RequestParam(name = "nama", required =false)String data2){
        return new Penerbit(data1,data2);
    }

    @GetMapping("/(id)")
    public ResponseEntity<Penerbit> findById(
            @PathVariable("id") String penerbitId){
        Optional<Penerbit> penerbitOptional= repository.findById(penerbitId);
        if(penerbitOptional.isPresent())
            return ResponseEntity.ok(penerbitOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("(/id)")
    public ResponseEntity<?> deleteById(String id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
