package evo.task.evoTestTask3.models;

import jakarta.persistence.*;

@Entity
@Table(name = "kulers")
public class Cooler {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "kuler_choice")
    private boolean coolerChoice;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brands;

    public Cooler() {
    }

    public Cooler(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCoolerChoice() {
        return coolerChoice;
    }

    public void setCoolerChoice(boolean coolerChoice) {
        this.coolerChoice = coolerChoice;
    }

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
    }
}
