package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameOfCRUD {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String character_name;
    String actor_name;
    String house;
    boolean alive;

    public GameOfCRUD(){
        super();
    }
    public GameOfCRUD(String character_name, String actor_name, String house, boolean alive){

        super();
        this.actor_name = actor_name;
        this.character_name = character_name;
        this.house = house;
        this.alive = alive;
    }
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacterName() {
        return character_name;
    }

    public void setCharacterName(String character_name) {
        this.character_name = character_name;
    }

    public String getActorName() {
        return character_name;
    }

    public void setActorName(String actor_name) {
        this.actor_name =actor_name;
    }


    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive ) {
        this.alive = alive;
    }

    public void setGameOfCRUD(GameOfCRUD gameOfCRUD){
        this.alive = gameOfCRUD.alive;
        this.house = gameOfCRUD.house;
        this.actor_name = gameOfCRUD.actor_name;
        this.character_name = gameOfCRUD.character_name;
    }





}
