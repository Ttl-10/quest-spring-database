package fr.wildcodeschool.quetespringbdd.queteSpringBdd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

    public City() {
    }

    public City(String cityName, String zipCode) {
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String cityName;

    private String zipCode;
    

    @Override
    public String toString() { 
        return "City [id=" + id + ", cityName=" + cityName + 
                ", zipCode=" + zipCode + "]";
    }                    

    public Long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }    

}
