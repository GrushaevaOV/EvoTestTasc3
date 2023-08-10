package evo.task.evoTestTask3.services;

import evo.task.evoTestTask3.models.HardDisc;
import evo.task.evoTestTask3.repositories.HardDiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class HardDiskService {
    private final HardDiskRepository hardDiskRepository;

    @Autowired
    public HardDiskService(HardDiskRepository hardDiskRepository) {
        this.hardDiskRepository = hardDiskRepository;
    }

    public List<HardDisc> findAll() {
        return hardDiskRepository.findAll();
    }

    public HardDisc findOne(int id) {
        Optional<HardDisc> foundHardDisc = hardDiskRepository.findById(id);
        return foundHardDisc.orElse(null);
    }

    public HardDisc findChoice() {
        return hardDiskRepository.findByHardChoice(true);
    }

    @Transactional
    public void save(HardDisc hardDisc) {
        hardDiskRepository.save(hardDisc);
    }

    @Transactional
    public void update(int id, HardDisc hardDisc) {
        hardDisc.setId(id);
        hardDiskRepository.save(hardDisc);
    }

    @Transactional
    public void delete(int id) {
        hardDiskRepository.deleteById(id);
    }


    @Transactional
    public void makeYardDiscBrand(HardDisc hardDisc) {
        Optional<HardDisc> foundHardDisc = hardDiskRepository.findById(hardDisc.getId());
        if (foundHardDisc.isPresent()) {
            foundHardDisc.get().setHardChoice(true);
        }
    }

    @Transactional
    public void freedomBrand(HardDisc hardDisc) {
        Optional<HardDisc> foundHardDisc = hardDiskRepository.findById(hardDisc.getId());
        if (foundHardDisc.isPresent()) {
            foundHardDisc.get().setHardChoice(false);
        }
    }

}
