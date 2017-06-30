package io.egen.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Sreedhar on 6/29/2017.
 */
public class ReadingID implements Serializable {
    private String vin;
    private String timestamp;

    public ReadingID() {
    }

    public ReadingID(String vin, String timestamp) {
        this.vin = vin;
        this.timestamp = timestamp;
    }

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
}
