package com.qa.controllers;


import com.qa.model.GameOfCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.repository.GameOfCRUDRepository;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class GameOfCRUDControllers {

    @Autowired
    private GameOfCRUDRepository repository;

    @RequestMapping(value = "gameohcrud/Values", method = RequestMethod.GET)
    public List<GameOfCRUD> ListAllGameOfCRUD(){
        return repository.findAll();
    }

    @RequestMapping(value = "GameOfCRUDAdd", method = RequestMethod.POST)
    public GameOfCRUD addGameOfCRUD(@RequestBody GameOfCRUD gameOfCRUD){
        return repository.saveAndFlush(gameOfCRUD);
    }

    @RequestMapping(value = "GameOfCRUDGet/{id}", method = RequestMethod.GET)
    public GameOfCRUD getGameOfCRUD(@PathVariable Long id){
        return repository.findOne(id);
    }
    @RequestMapping(value = "GameOFCRUDDelete/{id}",method = RequestMethod.DELETE)
    public GameOfCRUD deleteGameOfCRUD(@PathVariable Long id){
        GameOfCRUD existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "GameOfCRUDUpdate/{id}",method = RequestMethod.PUT)
    public GameOfCRUD updateGameOfCRUD(@PathVariable Long id, @RequestBody GameOfCRUD gameOfCRUD){
        GameOfCRUD ex = repository.findOne(id);
        ex.setGameOfCRUD(gameOfCRUD);
        return ex;
    }


}

