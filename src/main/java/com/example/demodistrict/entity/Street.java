package com.example.demodistrict.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date inauguratedAt;
    private int status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "districtId")
    private District district;
    @Column(insertable = false, updatable = false)
    private int districtId;

    public Street(String name, String description, Date inauguratedAt, int status, District district) {
        this.name = name;
        this.description = description;
        this.inauguratedAt = inauguratedAt;
        this.status = status;
        this.district = district;
    }
}
