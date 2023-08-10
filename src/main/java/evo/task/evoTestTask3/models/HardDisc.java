package evo.task.evoTestTask3.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hard_disk")
public class HardDisc {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private int size;

    @Column(name = "hard_choice")
    private boolean hardChoice;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brands;

    public HardDisc() {
    }

    public HardDisc(int id, String type, int size) {
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

    public boolean isHardChoice() {
        return hardChoice;
    }

    public void setHardChoice(boolean hardChoice) {
        this.hardChoice = hardChoice;
    }

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "HardDisk{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", hardChoice=" + hardChoice +
                ", brands=" + brands +
                '}';
    }
}
