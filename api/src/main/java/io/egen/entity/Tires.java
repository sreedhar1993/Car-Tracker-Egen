package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@Entity
public class Tires {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tID;

    private Integer frontLeft;
    private Integer frontRight;
    private Integer rearLeft;
    private Integer rearRight;

    public Integer gettID() {
        return tID;
    }

    public void settID(Integer tID) {
        this.tID = tID;
    }

    public Integer getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(Integer frontLeft) {
        this.frontLeft = frontLeft;
    }

    public Integer getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(Integer frontRight) {
        this.frontRight = frontRight;
    }

    public Integer getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(Integer rearLeft) {
        this.rearLeft = rearLeft;
    }

    public Integer getRearRight() {
        return rearRight;
    }

    public void setRearRight(Integer rearRight) {
        this.rearRight = rearRight;
    }
}
