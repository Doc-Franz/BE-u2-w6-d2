package com.example.blogging.controller;

import com.example.blogging.model.Autore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")

public class AutoreController {

    public static int id = 1;

    List<Autore> autoreList = new ArrayList<>();

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String inserisciAutore(@RequestBody Autore autore){
        autoreList.add(autore);
        String nome = autore.getNome();
        String cognome = autore.getCognome();
        autore.setId(id);
        id++;
        return "L'autore " + nome + " " + cognome + " con id " +id + " è stato inserito nel database";
    }

    @GetMapping
    public List<Autore> getAllAuthors(){
        return autoreList;
    }

    @GetMapping("/{id}")
    public Autore recuperaAutore(@PathVariable int id){
        Autore autoreById = null;
        for(Autore autore: autoreList){
            if (autore.getId() == id){
                autoreById = autore;
            }
        }
        return autoreById;
    }

    @PutMapping("/{id}")
    public Autore modifica(@RequestBody Autore autore, @PathVariable int id){

        for (int i = 0; i < autoreList.size(); i ++){
            if (autoreList.get(i).getId() == id){
                autoreList.set(i, autore);
                return autore;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autore non trovato");
        }
}
