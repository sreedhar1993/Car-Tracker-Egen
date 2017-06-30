package io.egen.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Readings.findAll",
                query = "SELECT readings FROM Readings readings"),

})
@IdClass(ReadingID.class)
public class Readings
{
    @Id
    private String vin;
    @Id
    private String timestamp;
    private Integer latitude;
    private Integer longitude;
    private Integer fuelVolume;
    private Integer speed;
    private Integer engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private Integer engineRpm;

    @ManyToOne
    private Tires tires;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Integer fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(Integer engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public Integer getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(Integer engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }


}
