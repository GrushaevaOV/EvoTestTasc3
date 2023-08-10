package evo.task.evoTestTask3.services;


import evo.task.evoTestTask3.models.*;
import evo.task.evoTestTask3.repositories.BrandRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findOne(int id) {
        Optional<Brand> foundBrand = brandRepository.findById(id);
        return foundBrand.orElse(null);
    }

    @Transactional
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Transactional
    public void update(int id, Brand brand) {
        brand.setId(id);
        brandRepository.save(brand);
    }

    @Transactional
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    public List<Processor> getProcessor(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            Hibernate.initialize(brand.get().getProcessors());
            return brand.get().getProcessors();
        } else {
            return Collections.emptyList();
        }
    }

    public List<HardDisc> getHardDisc(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            Hibernate.initialize(brand.get().getHardDiscss());
            return brand.get().getHardDiscss();
        } else {
            return Collections.emptyList();
        }
    }

    public List<OperatingFee> getOperatingFee(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            Hibernate.initialize(brand.get().getOperatingFeeList());
            return brand.get().getOperatingFeeList();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Cooler> getCooler(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            Hibernate.initialize(brand.get().getCoolers());
            return brand.get().getCoolers();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Motherboarder> getMotherboarder(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            Hibernate.initialize(brand.get().getMotherboarderLists());
            return brand.get().getMotherboarderLists();
        } else {
            return Collections.emptyList();
        }
    }

}
