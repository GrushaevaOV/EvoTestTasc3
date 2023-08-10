package evo.task.evoTestTask3.repositories;

import evo.task.evoTestTask3.models.OperatingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatingFeeRepository extends JpaRepository<OperatingFee,Integer> {
    OperatingFee findByOperatingChoice(Boolean bool);
}
