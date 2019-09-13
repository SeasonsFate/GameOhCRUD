package com.qa.repository;

import com.qa.model.GameOfCRUD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameOfCRUDRepository extends JpaRepository<GameOfCRUD,Long> {

}
