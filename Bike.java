package com.klef.jfsd.exam;

import javax.persistence.*;

@Entity
@Table(name = "bike")
public class Bike extends Vehicle {
    @Column(name = "model")
    private String model;
    
    @Column(name = "type")
    private String type;

    // Getters and Setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
