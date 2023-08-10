package evo.task.evoTestTask3.models;

import jakarta.persistence.*;

@Entity
@Table(name = "processor")
public class Processor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title_processor")
    private String titleProcessor;

    @Column(name = "core")
    private int core;

    @Column(name = "processor_choice")
    private boolean processorChoice;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brands;

    public Processor() {
    }

    public Processor(int id, String titleProcessor, int core) {
        this.id = id;
        this.titleProcessor = titleProcessor;
        this.core = core;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleProcessor() {
        return titleProcessor;
    }

    public void setTitleProcessor(String titleProcessor) {
        this.titleProcessor = titleProcessor;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
    }

    public boolean isProcessorChoice() {
        return processorChoice;
    }

    public void setProcessorChoice(boolean processorChoice) {
        this.processorChoice = processorChoice;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ", titleProcessor='" + titleProcessor + '\'' +
                ", core=" + core +
                ", brands=" + brands +
                '}';
    }
}
