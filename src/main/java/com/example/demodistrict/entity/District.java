package com.example.demodistrict.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Street> streets;

    public District(String name) {
        this.name = name;
    }

    public void addStreet(Street street) {
        if(this.streets == null){
            this.streets = new HashSet<>();
        }
        this.streets.add(street);
    }
}
