package evo.task.evoTestTask3.services;

import evo.task.evoTestTask3.models.OperatingFee;
import evo.task.evoTestTask3.repositories.OperatingFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OperatingFeeService {

    private final OperatingFeeRepository operatingFeeRepository;

    @Autowired
    public OperatingFeeService(OperatingFeeRepository operatingFeeRepository) {
        this.operatingFeeRepository = operatingFeeRepository;
    }


    public OperatingFee findChoice() {
        return operatingFeeRepository.findByOperatingChoice(true);
    }

    @Transactional
    public void makeOperatingFeeBrand(OperatingFee operatingFee) {
        Optional<OperatingFee> foundOperatingFee = operatingFeeRepository.findById(operatingFee.getId());
        if (foundOperatingFee.isPresent()) {
            foundOperatingFee.get().setOperatingChoice(true);
        }
    }

    @Transactional
    public void freedomBrand(OperatingFee operatingFee) {
        Optional<OperatingFee> foundOperatingFee = operatingFeeRepository.findById(operatingFee.getId());
        if (foundOperatingFee.isPresent()) {
            foundOperatingFee.get().setOperatingChoice(false);
        }
    }

}
