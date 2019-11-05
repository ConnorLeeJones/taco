package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Taco")
public class Taco extends MenuItem {

    public Taco() {
        super();
    }
}
