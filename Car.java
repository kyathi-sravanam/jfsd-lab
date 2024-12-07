package com.klef.jfsd.exam;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car extends Vehicle {
    @Column(name = "model")
    private String model;
    
    @Column(name = "automatic")
    private boolean automatic;

    // Getters and Setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }
}
