/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.monolith.model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author loisceka
 */
@Entity
public class Brand {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer brandId;

    @Column(name = "brand_name", length = 50)
    private String brandName;

    public Brand() {
    }
    
    public Brand(String brandName){
        this.brandName = brandName;
    }
    /*
    public Brand(String brandName, List<Belonging> belongings) {
        this.brandName = brandName;
        this.belongings = belongings;
    } */

    public Brand(String brandName, Country country) {
        this.brandName = brandName;
        this.country = country;
    }       

    public Integer getId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    /*
    @OneToMany(mappedBy="brand")
    private List<Belonging> belongings;

    public List<Belonging> getBelongings() {
        return belongings;
    }

    public void setBelongings(List<Belonging> belongings) {
        this.belongings = belongings;
    } */    
    
    @ManyToOne
    @JoinColumn(name="country", nullable=true)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }    
}
