package evo.task.evoTestTask3.services;

import evo.task.evoTestTask3.models.Cooler;
import evo.task.evoTestTask3.repositories.CoolerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CoolerService {
    final private CoolerRepository coolerRepository;

    @Autowired
    public CoolerService(CoolerRepository coolerRepository) {
        this.coolerRepository = coolerRepository;
    }

    public Cooler findChoice() {
        return coolerRepository.findByCoolerChoice(true);
    }

    @Transactional
    public void makeCoolerBrand(Cooler cooler) {
        Optional<Cooler> foundCooler = coolerRepository.findById(cooler.getId());
        if (foundCooler.isPresent()) {
            foundCooler.get().setCoolerChoice(true);
        }
    }

    @Transactional
    public void freedomBrand(Cooler cooler) {
        Optional<Cooler> foundCooler = coolerRepository.findById(cooler.getId());
        if (foundCooler.isPresent()) {
            foundCooler.get().setCoolerChoice(false);
        }
    }
}
