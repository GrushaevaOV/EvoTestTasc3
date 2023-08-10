package evo.task.evoTestTask3.services;

import evo.task.evoTestTask3.models.Processor;
import evo.task.evoTestTask3.repositories.ProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProcessorService {

    private final ProcessorRepository processorRepository;

    @Autowired
    public ProcessorService(ProcessorRepository processorRepository) {
        this.processorRepository = processorRepository;
    }

    public Processor findChoice() {
        return processorRepository.findByProcessorChoice(true);
    }

    @Transactional
    public void makeProcessorBrand(Processor processor) {
        Optional<Processor> foundProcessor = processorRepository.findById(processor.getId());
        if (foundProcessor.isPresent()) {
            foundProcessor.get().setProcessorChoice(true);
        }
    }

    @Transactional
    public void freedomBrand(Processor processor) {
        Optional<Processor> foundBook = processorRepository.findById(processor.getId());
        if (foundBook.isPresent()) {
            foundBook.get().setProcessorChoice(false);
        }
    }
}
