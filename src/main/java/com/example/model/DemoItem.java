package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "demo_items")
public class DemoItem {

    private Integer id;
    private String demoValue;

    public DemoItem() {
    }

    public DemoItem(Integer id, String value) {
        this.id = id;
        this.demoValue = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "demoValue", nullable = false) 
    public String getValue() {
        return demoValue;
    }

    public void setValue(String value) {
        this.demoValue = value;
    }
}
