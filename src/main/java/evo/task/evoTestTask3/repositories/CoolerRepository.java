package evo.task.evoTestTask3.repositories;

import evo.task.evoTestTask3.models.Cooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolerRepository extends JpaRepository<Cooler, Integer> {
    Cooler findByCoolerChoice(Boolean bool);
}
