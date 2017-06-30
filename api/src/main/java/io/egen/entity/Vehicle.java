package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",
                query = "SELECT vehicle FROM Vehicle vehicle ORDER BY vehicle.year DESC")
})
public class Vehicle {

    @Id
    private String vin;
    private String make;
    private String model;
    private Integer year;
    private Integer redlineRpm;
    private Integer maxFuelVolume;
    private String lastServiceDate;

    public Vehicle(){}

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(Integer redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public Integer getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Integer maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
