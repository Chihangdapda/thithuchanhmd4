package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table(name = "citys")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Size(min = 1,max = 50)
    private String cityName;

    private String country;

    @Min(1)
    private double cityAcreage;

    @Min(1)
    private double cityPopulation;

   @Min(1)
    private double GDP;

    private String description;

    public City() {
    }

    public City(Long cityId, @Size(min = 1, max = 50) String cityName, String country, @Min(1) double cityAcreage, @Min(1) double cityPopulation, @Min(1) double GDP, String description) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
        this.cityAcreage = cityAcreage;
        this.cityPopulation = cityPopulation;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getCityAcreage() {
        return cityAcreage;
    }

    public void setCityAcreage(double cityAcreage) {
        this.cityAcreage = cityAcreage;
    }

    public double getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(double cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
