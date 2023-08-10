package evo.task.evoTestTask3.models;

import jakarta.persistence.*;

@Entity
@Table(name = "motherboarder")
public class Motherboarder {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "ram")
    private int ram;

    @Column(name = "motherboarder_choice")
    private boolean motherboarderChoice;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brands;

    public Motherboarder() {
    }

    public Motherboarder(int id, String title, int ram) {
        this.id = id;
        this.title = title;
        this.ram = ram;
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public boolean isMotherboarderChoice() {
        return motherboarderChoice;
    }

    public void setMotherboarderChoice(boolean motherboarderChoice) {
        this.motherboarderChoice = motherboarderChoice;
    }

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
    }
}
