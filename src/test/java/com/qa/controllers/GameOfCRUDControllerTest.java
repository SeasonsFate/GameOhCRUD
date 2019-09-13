package com.qa.controllers;


import com.qa.model.GameOfCRUD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.qa.repository.GameOfCRUDRepository;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameOfCRUDControllerTest {
    @InjectMocks
    private GameOfCRUDControllers gameOfCRUDControllers;

    @Mock
    private GameOfCRUDRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllGameOfCRUD() {
        List<GameOfCRUD> gameOfCRUDList = new ArrayList<>();
        GameOfCRUD gameOfCRUD = new GameOfCRUD();
        gameOfCRUD.setActorName("dave");
        gameOfCRUD.setCharacterName("tarj");
        gameOfCRUD.setHouse("fish");
        gameOfCRUDList.add(gameOfCRUD);

        when(repository.findAll()).thenReturn(gameOfCRUDList);
        assertEquals(gameOfCRUDControllers.ListAllGameOfCRUD().get(0).getActorName(),"dave");
    }

    @Test
    public void testGetGameOfCRUD(){
        GameOfCRUD gameOfCRUD = new GameOfCRUD();
        gameOfCRUD.setActorName("dave");
        gameOfCRUD.setCharacterName("tarj");
        gameOfCRUD.setHouse("fish");
        gameOfCRUD.setId(3l);

        when(repository.findOne(3l)).thenReturn(gameOfCRUD);
        assertEquals(gameOfCRUDControllers.getGameOfCRUD(3l).getActorName(),"dave");


    }
    @Test
    public void testAddHero(){
        GameOfCRUD gameOfCRUD = new GameOfCRUD();
        gameOfCRUD.setActorName("dave");
        gameOfCRUD.setCharacterName("tarj");
        gameOfCRUD.setHouse("fish");
        gameOfCRUD.setId(3l);

        when(repository.saveAndFlush(gameOfCRUD)).thenReturn(gameOfCRUD);
        assertEquals(gameOfCRUDControllers.addGameOfCRUD(gameOfCRUD).getActorName(),"dave");

    }
    @Test
    public void testDeleteHero(){

        GameOfCRUD gameOfCRUD = new GameOfCRUD();
        gameOfCRUD.setActorName("dave");
        gameOfCRUD.setCharacterName("tarj");
        gameOfCRUD.setHouse("fish");
        gameOfCRUD.setId(3l);


        when(repository.findOne(7l)).thenReturn(gameOfCRUD);
        repository.delete(7l);
        assertEquals( gameOfCRUDControllers.deleteGameOfCRUD(7l),gameOfCRUD);


    }







}
