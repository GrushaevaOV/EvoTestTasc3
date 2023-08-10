package evo.task.evoTestTask3.repositories;

import evo.task.evoTestTask3.models.Brand;
import evo.task.evoTestTask3.models.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Integer> {
    Processor findByProcessorChoice(boolean bool);
}
