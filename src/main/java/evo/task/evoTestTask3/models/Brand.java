package evo.task.evoTestTask3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "Brand")
public class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название бренда не должно быть пустым")
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "brands")
    private List<Processor> processors;

    @OneToMany(mappedBy = "brands")
    private List<HardDisc> hardDiscss;

    @OneToMany(mappedBy = "brands")
    private List<OperatingFee> operatingFeeList;

    @OneToMany(mappedBy = "brands")
    private List<Cooler> coolers;

    @OneToMany(mappedBy = "brands")
    private List<Motherboarder> motherboarderLists;
    public Brand() {
    }

    public Brand(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Processor> getProcessors() {
        return processors;
    }

    public void setProcessors(List<Processor> processors) {
        this.processors = processors;
    }

    public List<HardDisc> getHardDiscss() {
        return hardDiscss;
    }

    public void setHardDiscss(List<HardDisc> hardDiscss) {
        this.hardDiscss = hardDiscss;
    }

    public List<OperatingFee> getOperatingFeeList() {
        return operatingFeeList;
    }

    public void setOperatingFeeList(List<OperatingFee> operatingFeeList) {
        this.operatingFeeList = operatingFeeList;
    }

    public List<Cooler> getCoolers() {
        return coolers;
    }

    public void setCoolers(List<Cooler> coolers) {
        this.coolers = coolers;
    }

    public List<Motherboarder> getMotherboarderLists() {
        return motherboarderLists;
    }

    public void setMotherboarderLists(List<Motherboarder> motherboarderLists) {
        this.motherboarderLists = motherboarderLists;
    }
}
