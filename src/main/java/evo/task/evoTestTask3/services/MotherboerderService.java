package evo.task.evoTestTask3.services;

import evo.task.evoTestTask3.models.Motherboarder;
import evo.task.evoTestTask3.repositories.MotherboarderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MotherboerderService {
    private final MotherboarderRepository motherboarderRepository;

    @Autowired
    public MotherboerderService(MotherboarderRepository motherboarderRepository) {
        this.motherboarderRepository = motherboarderRepository;
    }

    public Motherboarder findChoice() {
        return motherboarderRepository.findByMotherboarderChoice(true);
    }

    @Transactional
    public void makeMotherboarderBrand(Motherboarder motherboarder) {
        Optional<Motherboarder> foundMotherBoarder = motherboarderRepository.findById(motherboarder.getId());
        if (foundMotherBoarder.isPresent()) {
            foundMotherBoarder.get().setMotherboarderChoice(true);
        }
    }

    @Transactional
    public void freedomBrand(Motherboarder motherboarder) {
        Optional<Motherboarder> foundMotherBoarder = motherboarderRepository.findById(motherboarder.getId());
        if (foundMotherBoarder.isPresent()) {
            foundMotherBoarder.get().setMotherboarderChoice(false);
        }
    }
}
