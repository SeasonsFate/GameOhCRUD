package repository;

import model.GameOfCRUD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameOfCRUDRepository extends JpaRepository<GameOfCRUD,Long> {

}
