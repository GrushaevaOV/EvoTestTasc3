package evo.task.evoTestTask3.repositories;

import evo.task.evoTestTask3.models.Motherboarder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboarderRepository extends JpaRepository<Motherboarder,Integer> {
    Motherboarder findByMotherboarderChoice(Boolean bool);
}
