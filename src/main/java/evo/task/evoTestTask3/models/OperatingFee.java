package evo.task.evoTestTask3.models;

import jakarta.persistence.*;

@Entity
@Table(name = "operating_fee")
public class OperatingFee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private int size;

    @Column(name = "operating_choice")
    private boolean operatingChoice;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brands;

    public OperatingFee() {
    }

    public OperatingFee(int id, String type, int size) {
        this.id = id;
        this.type = type;
        this.size = size;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOperatingChoice() {
        return operatingChoice;
    }

    public void setOperatingChoice(boolean operatingChoice) {
        this.operatingChoice = operatingChoice;
    }

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
    }
}
