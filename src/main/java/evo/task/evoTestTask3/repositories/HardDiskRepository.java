package evo.task.evoTestTask3.repositories;

import evo.task.evoTestTask3.models.HardDisc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisc, Integer> {
    HardDisc findByHardChoice(boolean bool);
}
